package MultiServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer extends Thread{
		

public static void main(String[] ar)    {
	int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
		//Socket socket;// = null;
		
       try {
         ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
         System.out.println("Waiting for a client...");

         Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
         System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
         System.out.println();

 // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту. 
         InputStream sin = socket.getInputStream();
         OutputStream sout = socket.getOutputStream();

 // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
         DataInputStream in = new DataInputStream(sin);
         DataOutputStream out = new DataOutputStream(sout);

         String line = null;
         while(true) {
           line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
           System.out.println("The dumb client just sent me this line : " + line);
           System.out.println("I'm sending it back...");
           out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
           out.flush(); // заставляем поток закончить передачу данных.
           System.out.println("Waiting for the next line...");
           System.out.println();
           sendToOtherThread(socket);
         }
      } catch(Exception x) { x.printStackTrace(); }
      }
   

   static List<MainServer> sockets = new ArrayList<>();
   
		public static void sendToOtherThread(Socket socket) {
			//send socket to new Thread
			MainServer obj = new MainServer();
			sockets.add(obj);
			obj.start();
		}
}