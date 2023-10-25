package SelfLearning;

import java.util.TreeSet;

public class PointCompare implements Comparable{
	
	private int x;
	private int y;
	
	public PointCompare(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public String toString() {
		return "X ="+x+" Y "+y;
	}
	
	@Override
	public int compareTo(Object o) {
		PointCompare p=(PointCompare)o;
		if(p.x<x) { return 1;}
		else if(p.x>x) {return -1;}
		else {
			if(p.y<y) {return 1;}
			else if(p.y>y) {return -1;}
			else {return 0;}
		}
}
	
	public static void main(String[] args) {
		TreeSet<PointCompare> th=new TreeSet<>();
		th.add(new PointCompare(2, 3));
		th.add(new PointCompare(3, 2));
		th.add(new PointCompare(3, 4));
		System.out.println(th.size());
		System.out.println(th);
	}

}
