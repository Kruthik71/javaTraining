package Day7;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
		// Always prefixed with 1900 (1947->47,2023-123)
		Date date=new Date(47,7,15);
		System.out.println(date);
		
		//After 1.7
		LocalDate date1=LocalDate.of(1947, 8, 15);
		System.out.println(date1);
	}

}
