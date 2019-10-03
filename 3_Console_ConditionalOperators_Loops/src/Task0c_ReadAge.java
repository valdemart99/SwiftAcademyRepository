import java.util.Scanner;

public class Task0c_ReadAge {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		sc.close();
		if (age >= 0) {
			System.out.println(age>=18 ? "Adult" : "Kid");
		} else {
			System.out.println("Negative value: entered number is not an age.");
		}
		
		
	}

}