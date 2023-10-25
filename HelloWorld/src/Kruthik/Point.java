package Kruthik;

import java.io.Serializable;

public class Point implements PointAirthemetic,Comparable<Point>,Serializable {//Comparable method usage for TreeSet

	public static final Point ORIGIN= new Point();
	
	//static {System.out.println(ORIGIN);} (Should ask about it)
	
	public Point() {}
	
	protected int x;
	protected int y;

	@Override
	public int compareTo(Point o) {
		return (x-o.x) == 0 ? (y-o.y) : (x-o.x);
	}
	
	//Overriding equals method by Type casting
	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		return p.x==x && p.y==y;
	}

	//Overriding hashCode
	@Override
	public int hashCode() {
		return toString().hashCode();
	}


	@Override
	public String toString() {
		System.out.println("Printing the values of X,Y,Distance");
		return " X = " + x + " Y = " + y + " Distance = " +distance();	
	}

	//Constructor with Parameters
	public Point(int x, int y){
		System.out.println("0. Invoking Point(x,y) in Point");
		this.x=x;
		this.y=y;
	}
	
	//Method with object as parameter
	public double distance (Point other)
	{
		System.out.println("1. Invoking distance(Point Obj) in Point");
		return distance (other.x,other.y);
	}

	//Method to calculate distance after the origin has been changed
	public double distance()
	{
		System.out.println("2. Invoking distance() in Point");
		int diffx = x-ORIGIN.x;
		int diffy = y-ORIGIN.y;
		return Math.sqrt(diffx*diffx +diffy*diffy);
	}
	
	//Method with integers as parameter
	public double distance(int x, int y)
	{
		System.out.println("3. Invoking distance(x,y) in Point");
		int diffx =this.x-x;
		int diffy =this.y-y;
		return Math.sqrt(diffx*diffx +diffy*diffy);
	}
	
	//Distance between 2 points
	public double diffPoint (Point a,Point b) {
		double x=a.x-b.x;
		double y=a.y-b.y;
		return Math.sqrt(x*x+y*y);
	}
	
	@Override
	public Point addPoints(Point a,Point b,Point c) {
		c.x=a.x+b.x;
		c.y=a.y+b.y;
		return c;
	}
	
	@Override
	public Point subPoints(Point a, Point b, Point c) {
		c.x=a.x-b.x;
		c.y=a.y-b.y;
		return c;
	}
	
	@Override
	public double distPoints(Point a, Point b) {
		double result=diffPoint(a,b);
		return result;
	}

	//Main function
	public static void main(String[] args) {
		Point p = new Point();
		System.out.println("When the origin was in 0,0");
		p.x=3;
		p.y=4;
		System.out.println(p.distance());
		
		System.out.println("After changing the origin");
		ORIGIN.x=1;
		ORIGIN.y=1;
		System.out.println(p.distance());
		
		Point p1 = new Point(3,4);
		
		Point p2 = new Point(20,30);
		Point p3 = new Point(10,20);
		Point p4 = new Point();
		
		PointAirthemetic p5=new Point();
		p5.addPoints(p2, p3, p4);
		System.out.println("("+p4.x+","+p4.y+")");
		p5.subPoints(p2, p3, p4);
		System.out.println("("+p4.x+","+p4.y+")");
		double answer=p5.distPoints(p2, p3);
		System.out.println(answer);
	}

}