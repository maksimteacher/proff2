package threadGame;

public class ThreadWriter extends Thread {
	 @Override
	 public void run(){
	  while(true){
	   if(isInterrupted())break;
	  }
	  System.out.println("done ThreadWriter");  
	 }
}
