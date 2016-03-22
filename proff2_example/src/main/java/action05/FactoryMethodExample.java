package action05;

public class FactoryMethodExample {
	public static void main(String[] args) {
		MyJDBC connect = new OracleJDBC();
		//
		String nameJDBC = "oracle";
		MyJDBC connect1 = null;
		if(nameJDBC.equals("oracle")){
			connect1 = new OracleJDBC();
		} else {
			connect1 = new MSSQLJDBC();
		}
		// First Example Factory method
		MyJDBC connect2 = JDBCManager.getInstance("MSSQL");
		MyJDBC connect3 = JDBCManager.getInstance("oracle");
		
		// Other Example Factory Method
		CreatorJDBC creator = new CreatorOracleJDBC(); // new CreatorMSSQLJDBC();
		
		MyJDBC connect4 = creator.factoryMethod();
	}
}
interface MyJDBC {
	public void save();
	public void read();
}
class OracleJDBC implements MyJDBC{
	@Override
	public void save() {
		System.out.println("oracle save");
	}
	@Override
	public void read() {
		System.out.println("oracle read");
	}
}
class MSSQLJDBC implements MyJDBC{
	@Override
	public void save() {
	}
	@Override
	public void read() {
	}
}
/*    First Example Factory method */
class JDBCManager{
	MyJDBC jdbc;
	public static MyJDBC getInstance(String base){
		if(base.equalsIgnoreCase("oracle")) return new OracleJDBC();
		if(base.equalsIgnoreCase("mssql")) return new MSSQLJDBC();
		return null;
	}
}
/*    Other Example Factory Method */
interface CreatorJDBC{
	public MyJDBC factoryMethod();
}
class CreatorOracleJDBC implements CreatorJDBC{
	@Override
	public MyJDBC factoryMethod() {
		return new OracleJDBC();
	}	
}
class CreatorMSSQLJDBC implements CreatorJDBC{
	@Override
	public MyJDBC factoryMethod() {
		return new MSSQLJDBC();
	}	
}

