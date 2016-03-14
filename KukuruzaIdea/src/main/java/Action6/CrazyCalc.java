package Action6;

/*
 	CrazyCalc.
 	operation: setValue
 	get : if(value>=0) return value; else throws new ArithmeticException();
 	clear: setValue(0) 
 * */
public class CrazyCalc {
	private int value;
	public void operation(int a){
		value = a;
	}
	public int get() throws ArithmeticException{
		//if(1==1)return 0;
		//if(value==0) throw new NullPointerException("Oy!Oy!Oy!");
		//if(value==0) return 5;
		if(value>=0) return value;
		throw new ArithmeticException("Oy!Oy!Oy!");
	}
	public void clear(){
		value = 0;
	}
}
