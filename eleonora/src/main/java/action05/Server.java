package action05;

public class Server{
	public static Server Sv=new Server();
	private String name="Name1";
	private String color = "red";
	private Server(){
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}	
