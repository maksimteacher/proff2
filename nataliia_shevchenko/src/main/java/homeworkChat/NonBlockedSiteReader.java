package homeworkChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NonBlockedSiteReader {

    private static final int REQUESTS = 1000;
 
    private static final int THREADS = 3;
 
    private static final String HOST = "127.0.0.1"; //"192.168.10.181";
 
    private static final int PORT = 7001;
 
    private static final String PATH_FMT = "/DemoServlet/demo?reqno={0}"; 
 
    private static String formatRequest(int taskno) {
        return MessageFormat.format(PATH_FMT, taskno);
    }
 
    public static boolean isAllFinished(boolean[] finishes) {  
        for (int i = 0; i < finishes.length; i++)
            if (!finishes[i])
                return false;
        return true;
    }
 
    public static class Command {
        private int index;
  
        private boolean finish;
  
        public Command(int index, boolean finish) {
            this.index = index;
            this.finish = finish;
        }
  
        public int index() {
            return index;
        }
  
        public boolean isFinish() {
            return finish;
        }
    }
 
    public static class QueueReader implements Callable<Void> {
  
        private Queue<Command> queue;
  
        public QueueReader(Queue<Command> queue) {
            this.queue = queue;   
        }

       // @Override
        public Void call() throws Exception { 
            while(!Thread.currentThread().isInterrupted()) {
                Command command = queue.poll();
                if (command == null) { 
                    Thread.sleep(5);
                    continue;
                }
    
                if (command.isFinish()) {
                    System.out.println("Finish command: " + command.index);
                    break;
                }
    
                long mathstart = System.currentTimeMillis();
                long prod = 1;
                for (long i = 0; i < 150000; i++) {
                    prod *= Math.random() * 100;
                }
                long mathend = System.currentTimeMillis();
                System.out.println("TaskNo: " + command.index + ", " +
                    "Prod: " + prod + " time: " + (mathend - mathstart) + 
                    " ms.");
            }
   
            return null;
        }
    }
 
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
  
        long start = System.currentTimeMillis();
  
        Queue<Command> commandQueue = new ConcurrentLinkedQueue<NonBlockedSiteReader.Command>();
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        Future<Void>[] futures = new Future[THREADS]; 
        for (int i = 0; i < THREADS; i++) {
            futures[i] = executor.submit(new QueueReader(commandQueue));
        }
  
        Selector crowlerSelector = Selector.open();
    
        SocketChannel[] channels = new SocketChannel[REQUESTS];
        for (int i = 0; i < REQUESTS; i++) {
            channels[i] = SocketChannel.open();
            channels[i].configureBlocking(false);
            channels[i].register(crowlerSelector, 
                SelectionKey.OP_CONNECT, i);     
            channels[i].connect(new InetSocketAddress(HOST, PORT));
        }
  
        final boolean[] finishes = new boolean[REQUESTS];
        for (int i = 0; i < finishes.length; i++)
            finishes[i] = false;
  
        // NIO позволяет создать общий буфер для считывания всех ответов
        // За счет этого можно снизить потребление памяти на порядок 
        ByteBuffer readbuffer = ByteBuffer.allocate(8192);
  
        while (!isAllFinished(finishes)) {
            Set<SelectionKey> selectedKeys;   
            int channelCount = crowlerSelector.select(200);   
            if (channelCount == 0) {    
                continue;
            }
  
            selectedKeys = crowlerSelector.selectedKeys();
  
            Iterator<SelectionKey> selectedKeysIterator = selectedKeys.iterator();   
            while (selectedKeysIterator.hasNext()) {
                SelectionKey key = selectedKeysIterator.next();
                if (key.isConnectable()) {
                    System.out.println("Can connect to " + key.attachment());
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    System.out.println("Receive buffer size: " + socketChannel.socket().getReceiveBufferSize());
                    socketChannel.finishConnect();
                    key.interestOps(SelectionKey.OP_WRITE);     
                    System.out.println("Connected: " + socketChannel.isConnected());     
                } else if (key.isReadable()) {     
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    System.out.println("Readable " + key.attachment());         
                    int readed = socketChannel.read(readbuffer);
                    System.out.println("Reqno: " + key.attachment() + ", Readed: " + readed);
                    // т.к. буфер теперь общий, то его нужно чистить
                    readbuffer.clear();
                    if (readed == -1) {      
                        boolean oldfinished = finishes[(Integer) key.attachment()];
                        finishes[(Integer) key.attachment()] = true;
                        System.out.println("Done task no " + key.attachment());
                        if (!oldfinished) {      
                            commandQueue.add(new Command((Integer) key.attachment(), false));
                        }
                    }       
                } else if (key.isWritable()) {
                    System.out.println("Writeable " + key.attachment());     
                    SocketChannel socketChannel = (SocketChannel) key.channel();
     
                    ByteBuffer buffer = ByteBuffer.wrap(("GET " + 
                        formatRequest((Integer) key.attachment()) + 
                        " HTTP/1.0\r\nHost: " + HOST + "\r\n\r\n").getBytes());
             
                    while (buffer.hasRemaining()) {
                        socketChannel.write(buffer);
                    }
     
                    key.interestOps(SelectionKey.OP_READ);
                }
    
                selectedKeysIterator.remove();
            }
        }
      
        crowlerSelector.close();
  
        for (int i = 0; i < REQUESTS; i++) {
            channels[i].shutdownOutput();
            channels[i].shutdownInput();
            channels[i].close();  
        }
  
        System.out.println("Sockets finish work");
  
        // Отправляем специальные комманды завершения обработчиков
        for (int i = 0; i < THREADS; i++) {
            commandQueue.add(new Command(-1, true));
        }
  
        // Ждем завершения обработчиков
        for (int i = 0; i < THREADS; i++) {
            futures[i].get();
        }
  
        long end = System.currentTimeMillis();
        System.out.println("date: " + new Date() + ", " +
            "time: " + (end - start) + " ms.");
        executor.shutdown();
    } 
}
