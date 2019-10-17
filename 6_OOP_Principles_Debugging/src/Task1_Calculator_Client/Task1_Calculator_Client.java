package Task1_Calculator_Client;
import java.util.*;

public class Task1_Calculator_Client {
	
	private static int getCommand(String command) {
		String[] commandList = { "SUM", "SUB", "MUL", "DIV", "PER" };
		for (int i = 0; i < commandList.length; ++i) {
			if (commandList[i].equals(command)) { return i; }
		}
		return -1;
	}
	
	private static void determineCommand(String command, Calculator calc) {
		double result = 0;
		
		switch (getCommand(command)) {
			case 0: result = calc.sum(); break;
			case 1: result = calc.substract(); break;
			case 2: result = calc.multiply(); break;
			case 3: result = calc.divide(); break;
			case 4: result = calc.percentage(); break;
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
