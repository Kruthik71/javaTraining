package Kruthik;
/*
class second{
	int x=5;
	int y=10;
	String fname = "Kruthik";
	String lname = "B";
	void print() {
		System.out.println("This is another class . . . .");
	}
}
*/
public class ClassObject {
	int z=20;
	public static final ClassObject ORIGIN=new ClassObject();
	protected int a,b;
	public double distance() {
		int da=a-ORIGIN.a;
		int db=b-ORIGIN.b;
		return Math.sqrt(da*da+db*db);
	}
	
	//Equals 
	@Override
	public boolean equals(Object obj) {
		ClassObject p = (ClassObject) obj;
		return p.a==a && p.b==b;
	}
	
	//Hashcode
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return "A = "+ a +" B = "+ b + "Distance = " + distance();
	}
	public static void main(String[] args) {
		ClassObject Obj=new ClassObject();
		System.out.println(Obj.z);
		
		/*
		second myObj=new second();
		myObj.y=15;
		System.out.println("This is inside the main class . . . .");
		System.out.println(myObj);
		System.out.println(myObj.x);
		System.out.println(myObj.y); //Value can be changed if has not been made final
		myObj.print();
		System.out.println("Name: " + myObj.fname + " " + myObj.lname);
		*/
		Obj.a=30;
		Obj.b=4;
		System.out.println(Obj.distance());
		ORIGIN.a=20;
		ORIGIN.b=4;
		System.out.println(Obj.distance());
	}
}