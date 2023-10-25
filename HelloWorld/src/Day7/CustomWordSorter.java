package Day7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomWordSorter {
	
	
	
	public List<String> breakAndSort(String str){
		//Splitting the word
		List<String> segments = Arrays.asList(str.split(" "));
		//Sorting based on vowels , ratio and accordingly
		return segments;
		
//		List<Word> words=segments.stream().map(s->new word(s)).collect(Collectors.toList());
//		Collections.sort(words);
//		return words.stream().map(w->w.actualWord).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		CustomWordSorter sorter=new CustomWordSorter();
		System.out.println(sorter.breakAndSort("Hello How are you doing"));
		System.out.println(sorter.breakAndSort("Hello How are you doing i amd doing good"));
	}
}
