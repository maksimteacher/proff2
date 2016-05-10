package action18SpringAnnot2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Lift {
	
	@Value("CASINO")
	private String name;
	
	@Value("Ivanov A. I.")
	private String operator;
	
	public Lift() {
	}
	
	public Lift(String name) {
		this.name = name;
	}

	public Lift(String name, String operator) {
		this.name = name;
		this.operator = operator;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "Lift [name=" + name + ", operator=" + operator + "]";
	}
	
}
