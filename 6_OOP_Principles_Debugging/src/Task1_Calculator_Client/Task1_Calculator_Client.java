package Task1_Calculator_Client;
import java.util.*;

public class Task1_Calculator_Client {
	
	private static void determineCommand(String command, Calculator calc) {
		double result = 0;
		
		switch (command) {
			case "SUM": result = calc.sum(); break;
			case "SUB": result = calc.substract(); break;
			case "MUL": result = calc.multiply(); break;
			case "DIV": result = calc.divide(); break;
			case "PER": result = calc.percentage(); break;
		}
		
		System.out.printf("%.3f\n", result);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Calculator calc = new Calculator();
		String command = input.nextLine();
		
		while (!command.equals("END")) {
			String[] tempArr = command.split(" ");
			calc.parseInputA(tempArr[1]);
			calc.parseInputB(tempArr[2]);
			
			if (calc.getB() == 0 && tempArr[0].equals("DIV")) {
				System.out.println("Error: Division by 0!");
			} else if (calc.getA() == 0 && tempArr[0].equals("PER")) {
				System.out.println("Error: Can't find percentage of 0!");
			} else {
				determineCommand(tempArr[0], calc);
			}
			
			command = input.nextLine();
		}
		
	}

}
