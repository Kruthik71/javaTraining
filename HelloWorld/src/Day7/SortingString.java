package Day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingString {
	public static void main(String[] args) {
		String s=new String("Hello how are you");
		String[] splittedString=splitString(s);
		Map<String,Double> vowels=new HashMap<>();
		for(String str:splittedString) {
			vowels.put(str, (double) (((double) str.length()-(double) countVowels(str))/str.length()));
		}
		for(Map.Entry<String, Double> entry:vowels.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		 List<Map.Entry<String, Double>> list = new ArrayList<>(vowels.entrySet());
	}

	private static int countVowels(String str) {
		int count=0;
		for(int i=0;i<=str.length()-1;i++) {	
			 char ch = Character.toLowerCase(str.charAt(i));
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				count++;
			}
		}
		return count;
	}

	private static String[] splitString(String s) {
		String[] result=s.split(" ");
		for(String res:result) {
			System.out.println(res);
		}
		return result;
	}
}
