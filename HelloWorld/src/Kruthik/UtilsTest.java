package Kruthik;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class UtilsTest {
	
	public static void testQueue(Queue<Point> points) {
		points.add(new Point(1,3));
		points.add(new Point(2,3));
		points.add(new Point(3,3));
		System.out.println(points.size());
		System.out.println(points.poll()); // last element will be popped and size will be changed
		System.out.println(points.peek()); //last element will be shown without size reduction

	}
	
	public static void testStack(Stack<Point> points){
		points.push(new Point(1,3));
		points.push(new Point(2,3));
		points.push(new Point(3,3));
		System.out.println(points.size());
		System.out.println(points.pop()); // last element will be popped and size will be changed
		System.out.println(points.peek()); //last element will be shown without size reduction
	}
	
	public static void testMap(Map<String,Point> points){
		points.put("2,3", new Point(2,3));
		points.put("2,3", new Point(2,3));
		points.put("3,3", new Point(3,3));
		points.put("4,3", new Point(4,3));
		System.out.println(points.size()); //Its the keys not the value( key:pair )
	}
	public static void testList(List<Point> points) {
		Point p=new Point(2,3);
		Point p1=new Point(1,3);
		Point p2=new Point(3,2);
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(p2);
		System.out.println(points.size());
		//System.out.println(points);
	}
	public static void testSet(Set<Point> points) {
		Point p=new Point(2,3);
		Point p1=new Point(2,3);
		Point p2=new Point(3,2);
		//Set<Point> points= new HashSet<>(); Set normal
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(p2);
		System.out.println(points.size());
		//System.out.println(points);
		//if hashCode and equals implemented in Point then 2 or else 3
	}
	public static void main(String[] args) {
		// testSet(new HashSet<>()); //HashSet implementation //No order no duplicates
		// testSet(new TreeSet<>()); //Natural order no duplicates
		// testList(new ArrayList<>()); //Inputed order duplicates are encouraged
		// testList(new LinkedList<>());
		// testMap(new HashMap<>()); //No order
		// testMap(new TreeMap<>()); // Natural order
		// testStack(new Stack<>());
		// testQueue(new LinkedList<>()); //Queue is also a part of LinkedList
	}
}
