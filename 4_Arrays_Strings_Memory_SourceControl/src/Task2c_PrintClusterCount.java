import java.util.Scanner;
import java.util.Arrays;

public class Task2c_PrintClusterCount {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		int[] masiv = new int[input.nextInt()];
		input.nextLine();
		
		for (int i = 0; i < masiv.length; i++) {
			masiv[i] = input.nextInt();
		}		
		input.close();
		
		Arrays.sort(masiv);
		
		int clusterCount = 0;
		boolean clusterFlag = false;
		
		for (int i = 0; i < masiv.length - 1; i++) {
			if (masiv[i] == masiv[i + 1] && clusterFlag == false) {
				clusterCount += 1;
				clusterFlag = true;
			} else if (masiv[i] != masiv[i + 1]) {
				clusterFlag = false;
			}
		}
		System.out.println(clusterCount);

	}

}
