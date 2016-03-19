package threadGame;

public class Monitor {
	
	static ThreadCreator threadCreator;
	static ThreadWriter threadWriter;
	
	 public static void main(String[] args) {
		 
		 threadCreator = new ThreadCreator();
		 threadWriter = new ThreadWriter();
		 
		 System.out.println("AAAAAAAAAa");
		 
		 threadCreator.run();
		 
		 System.out.println("AAAAAAAAAa");
		 threadWriter.run();
		 
		 System.out.println("AAAAAAAAAa");
		 
		
	}

}
