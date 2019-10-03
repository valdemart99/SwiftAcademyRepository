/* a) int a = 5; int b = 10; int c = ++a * b--;
* 		The answer is c = 60, because on the last statement we are first incrementing the value of a, 
* 		then multiplying by the value of b and only then decrementing the value of b;
* 		The answer is just stored in memory and not displayed (in memory we have a = 6, b = 9 and c = 60)
* 
* b) System.out.println("1 + 2 = " + 1 + 2); System.out.println("1 + 2 = " + (1 + 2));
* 		The first statement will result in (in console):
* 			1 + 2 = 12
* 		The second statement will result in (in console):
* 			1 + 2 = 3
* 		The first line happens because the calculation is started with a String variable and the following "+" signs
* 		are simply concatenating the rest of the characters as strings.
* 		The second line avoids this by placing parenthesis and forcing a calculation of 1 + 2 before converting the result
* 		to a String value for concatenation
* 
* c) System.out.println(1 + 2 + "abc"); System.out.println("abc" + 1 + 2);
* 		The first statement will result in:
* 			3abc
* 		The second statement will result in:
* 			abc12
* 		The reason is the compiler interprets the statements left to right: the first one it sees numbers and starts
* 		summing them until it reaches the string which can't be calculated so the resulted sum is cast as string and concatenated; 
* 		the second one starts with a String and so the compiler interprets each "+" sign as concatenation.
* 
* d) int x = 7; float y = 5.6f; float z = x * y; System.out.println(z + “ “ + (x * y) );
* 		The last statement will result in (in console):
* 			39.2 39.2
* 		In memory we will have z = 39.2f.
* 		The reason for this specific printing is the compiler starts with getting the value of z, calculated in the previous statement,
* 		adds an interval after it and then calculated the x*y again (which is in parenthesis, so it is multiplied and not concatenated)
* 
* Note: I made a mistake when calculating 7 * 5.6 using an external calculator and somehow calculated that z = 28.
* Otherwise this didn't change the logical result of the program (initially I wrote 28 28)
*/

public class Task1_ResultFromCodeFragment {

	public static void main(String[] args) {
		// Subtask a
		int a = 5;
		int b = 10;
		int c = ++a * b--;
		// The following line is added to check the result:
		System.out.println(c); System.out.println(a); System.out.println(b);
		
		//Subtask b
		System.out.println("1 + 2 = " + 1 + 2);
		System.out.println("1 + 2 = " + (1 + 2));
		
		//Subtask c
		System.out.println(1 + 2 + "abc");
		System.out.println("abc" + 1 + 2);
		
		// Subtask d
		int x = 7;
		float y = 5.6f;
		float z = x * y;
		System.out.println(z + " " + (x * y) );
	}

}
