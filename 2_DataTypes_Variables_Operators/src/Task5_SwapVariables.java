
public class Task5_SwapVariables {

	public static void main(String[] args) {
		// ***Variant 1, three variables
		int a = 5;
		int b = 9;
		System.out.println(a + " " + b);		
		
		int c = a;
		a = b;
		b = c;
		System.out.println(a + " " + b);
		
		// ***Variant 2, two variables
		int d = 11;
		int e = 7;
		System.out.println(d + " " + e);
		
		d = d + e;
		e = d - e;
		d = d - e;
		System.out.println(d + " " + e);
		
	}

}
