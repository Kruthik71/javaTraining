package SelfLearning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//^(\\d)\1{4}(\\d)\2{4}$

// ^(\\d{2})(\\d{2})(\\d{2})(\\d{2})$
//^(\\d)(\\d)\\1\\2\\1\\2\\1\\2\\1\\2$

//^(\d)(2)\d(\d)(4)\d(\d)(6)\d$


public class Main {
	private static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile("\\d(\\d)\\1\\d\\1\\d\\1\\d\\1\\d\\1");

	public static boolean isValidPhoneNumber(String phoneNumber) {
		return VALID_PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
	}

	public static void main(String[] args) {
		String phoneNumber1 = "1234567890"; // Valid phone number
		String phoneNumber2 = "1222121212"; // Invalid phone number
		String phoneNumber3 = "6767676767"; // Invalid phone number

		System.out.println(phoneNumber1 + " is valid: " + isValidPhoneNumber(phoneNumber1));
		System.out.println(phoneNumber2 + " is valid: " + isValidPhoneNumber(phoneNumber2));
		System.out.println(phoneNumber3 + " is valid: " + isValidPhoneNumber(phoneNumber3));
	}

}
