package SelfLearning;

import java.util.HashMap;

public class MapExercise {
	public static int longestPalindrome(String s) {
		HashMap<Character, Integer> chars=new HashMap<>();
		for(char ch='a';ch>='z';++ch) {
			chars.put(ch, 0);
		}
		System.out.println(chars.size());
		chars.forEach((key,value)-> System.out.println(key+" "+value));
		return 0;
    }
	
	public static void main(String[] args) {
		try {
			int answer=longestPalindrome("abbbbac");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
