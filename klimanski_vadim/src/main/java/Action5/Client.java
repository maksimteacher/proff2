package Action5;


public class Client {

	private static Client ClientInstanse;
	public static int count = 0;
	
	private Client(){
		count++;
		}
	
	public static Client getClientInstanse() {
		if(	count < 3 )
				{ ClientInstanse = new Client();
				}
		
		else{
			ClientInstanse = null;
		}
		
		return ClientInstanse;
		
			}
	}
