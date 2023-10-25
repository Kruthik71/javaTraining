package SelfLearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Overloading {
	private int a,b,c;
	public Overloading() {
		super();
	}
	private int add(int a,int b) {
		return a+b;
	}
	public int add(int a,int b, int c) {
		return a+b+c;
	}
	public void message() {
		System.out.println("This is Overloading");
	}
	public static void main(String[] args) {
		List<Integer> arr=new ArrayList<>();
		List<Integer> larr=new LinkedList<>();
		Overloading over=new Overloading();
		System.out.println(over.add(1, 2));
		System.out.println(over.add(1, 2, 3));
		over.message();
	}
}
