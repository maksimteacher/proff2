package homeworkChat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.text.MessageFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class AsyncSocketsSiteReader {

    private static final int REQUESTS = 1000;
 
    private static final int THREADS = 16;
 
    private static final String HOST = "192.168.10.181";
 
    private static final int PORT = 7001;
 
    private static final String PATH_FMT = "/DemoServlet/demo?reqno={0}"; 
 
    private static String formatRequest(int taskno) {
        return MessageFormat.format(PATH_FMT, taskno);  
    }
 
    private static class BufferContainer {
  
        private ByteBuffer buffer;
  
        private AsynchronousSocketChannel channel;
  
        private int index;
  
        private boolean[] finishes;
  
        public BufferContainer(ByteBuffer buffer, AsynchronousSocketChannel channel, int index) {
            this.buffer = buffer;
            this.channel = channel;
            this.index = index;
        }
  
        public AsynchronousSocketChannel channel() {
            return channel;
        }
  
        public ByteBuffer buffer() {
            return buffer;   
        }
  
        public int index() {
            return index;
        }
    }
 
    public static boolean isAllFinished(boolean[] finishes) {  
        for (int i = 0; i < finishes.length; i++)
            if (!finishes[i])
                return false;
        return true;
    }
 
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
  
        final long start = System.currentTimeMillis();
 
        final boolean[] finishes = new boolean[REQUESTS];
        for (int i = 0; i < REQUESTS; i++)
            finishes[i] = false;
  
        AsynchronousChannelGroup group = AsynchronousChannelGroup
            .withFixedThreadPool(THREADS, Executors.defaultThreadFactory());
  
        AsynchronousSocketChannel[] channels = 
            new AsynchronousSocketChannel[REQUESTS];  
        for (int i = 0; i < REQUESTS; i++) {   
            ByteBuffer request = ByteBuffer.wrap(("GET " + formatRequest(i) + 
                " HTTP/1.0\r\nHost: " + HOST + "\r\n\r\n").getBytes());
   
            channels[i] = AsynchronousSocketChannel.open(group);   
            channels[i].connect(new InetSocketAddress(HOST, PORT), 
                new BufferContainer(request, channels[i], i), 
                new CompletionHandler<Void, BufferContainer>() {
                  //  @Override
                    public void completed(Void result, BufferContainer attachment) {
                        attachment.channel().write(attachment.buffer(), attachment, 
                            new CompletionHandler<Integer, BufferContainer>() {
                               // @Override
                                public void completed(Integer result, BufferContainer attachment) {
                                    if (attachment.buffer().hasRemaining()) {
                                        attachment.channel().write(
                                            attachment.buffer(), attachment, this);
                                    }
                                    System.out.println("Request for taskno " + 
                                        attachment.index() + " has been sent");
           
                                    // Записали весь запрос в буфер, теперь готовы читать       
                                    ByteBuffer readbuff = ByteBuffer.allocate(4096);            
                                    attachment.channel().read(readbuff, 
                                        new BufferContainer(readbuff, 
                                            attachment.channel(), 
                                            attachment.index()),
                                            new CompletionHandler<Integer, BufferContainer>() {
                                              //  @Override
                                                public void completed(Integer result, BufferContainer attachment) {
                                                    // Обрабатываем данные и вычитываем остаток
                                                    System.out.println("Taskno: " + 
                                                        attachment.index() + 
                                                        ", Readed: " + result);
                                                    if (result != -1) {
                                                        attachment.buffer().flip();
                                                        // Обработка данных
                                                        attachment.buffer().clear();
                                                        // Дочитка
                                                        attachment.channel().read(
                                                            attachment.buffer(),
                                                            attachment,
                                                            this);                
                                                    } else {
                                                        // Выполнение расчетов
                                                        long mathstart = System.currentTimeMillis();
                                                        long prod = 1;
                                                        for (long i = 0; i < 150000; i++) {
                                                            prod *= Math.random() * 100;
                                                        }
                                                        long mathend = System.currentTimeMillis();
                                                        System.out.println("Prod: " + prod + " time: " + 
                                                            (mathend - mathstart) + " ms.");
                                                        System.out.println("Done task: " + 
                                                            attachment.index());
                                                        finishes[attachment.index()] = true;            
                                                    }
                                                }

                                              //  @Override
                                                public void failed(Throwable exc, BufferContainer attachment) {
                                                    // Реагируем на ошибку чтения
                                                    System.out.println("Read fault!");
                                                    exc.printStackTrace();
                                                    // аварийно завершаем задачу
                                                    finishes[attachment.index()] = true;
                                                }
                                            });             
                                }

                            //    @Override
                                public void failed(Throwable exc, BufferContainer attachment) {
                                    // Реагиурем на ошибку записи
                                    System.out.println("Write fault!");
                                    exc.printStackTrace();       
                                }
                            });
                    }

                 //   @Override
                    public void failed(Throwable exc, BufferContainer attachment) {
                        System.out.println("Connect fault!");
                        exc.printStackTrace();       
                    }    
                });   
        }  
  
        // Ждем завершения всех задач
        while(!isAllFinished(finishes)) {
            Thread.sleep(5);
        }  

        for (int i = 0; i < channels.length; i++)
            channels[i].close();
  
        long end = System.currentTimeMillis();
        System.out.println("date: " + new Date() + ", " +
            "time: " + (end - start) + " ms.");
        group.shutdown();
    }
}