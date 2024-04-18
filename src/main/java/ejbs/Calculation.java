package ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;

import applogic.Calculator;


@Entity
@Stateless
public class Calculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="operation")
	private String operation;
	@Column(name="number1")
	private int number1;
	@Column(name="number2")
	private int number2;

	public Calculation() {
	}
	Calculation(String operation, int num1, int num2) {
		this.operation = operation;
		this.number1 = num1;
		this.number2 = num2;
	}
	
	//function to set all the values
	public void setValues(String operation, int num1, int num2) {
		this.operation = operation;
		this.number1 = num1;
		this.number2 = num2;
	}
	// Getters
	public int getId() {
		return this.id;
	}
	public String getOperation() {
		return this.operation;
	}
	
	public int getNumber1() {
		return this.number1;
	}
	
	public int getNumber2() {
		return this.number2;
	}
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setOperation(String Operation) {
		this.operation = Operation;
	}

	public void setNumber1(int num1) {
		this.number1 = num1;
	}
	
	public void setNumber2(int num2) {
		this.number2 = num2;
	}
	
	 public int calculate() {
	        Calculator calculator = new Calculator();
	        switch (operation) {
			case "+":
				return calculator.add(number1, number2);
			case "-":
				return calculator.subtract(number1, number2);
			case "*":
				return calculator.multiply(number1, number2);
			case "/":
				return calculator.divide(number1, number2);
			default:
				return 0;
	        }
	    }
	


}
