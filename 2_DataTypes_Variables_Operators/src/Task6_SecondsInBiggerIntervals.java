
public class Task6_SecondsInBiggerIntervals {

	public static void main(String[] args) {
		
		int input_seconds = 1234567;
		
		// A few declarations to make the code easier to read
		int sec_per_min = 60; int sec_per_hour = sec_per_min * 60; int sec_per_day = sec_per_hour * 24;

		int days = input_seconds / sec_per_day;
		int hours = (input_seconds % sec_per_day) / sec_per_hour;
		int minutes = (input_seconds % sec_per_hour) / sec_per_min;
		int seconds = input_seconds % sec_per_min;	

		System.out.println(days + " days, "+ hours + " hours, " + minutes + " minutes, " + seconds + " seconds");

	}

}
