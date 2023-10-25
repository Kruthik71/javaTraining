package Kruthik;

public class Point3D extends Point {

	public static final Point3D ORIGIN = new Point3D();

	private transient int z;

	public Point3D() {}
	
	public Point3D(int x,int y) {
		this.x=x;
		this.y=y;
	}

	//Overridden from parent class
	@Override
	public boolean equals(Object obj) {
		Point3D p =(Point3D) obj;
		return p.x==x && p.y==y && p.z==z;
	}

	//toString class was overridden in parent class so need to override hashCode() in child class
	@Override
	public String toString() {
		System.out.println("Printing the values of X,Y,Z");
		return "X = " + x + " Y = " + y + " Z = " +z;
	}

	// Overloading the constructor
	public Point3D(int x ,int y,int z)
	{
		super(x,y); //Super method to parent class for x,y invocation
		System.out.println("4. Invoking Point3D(x,y,z) in Point3D");
		this.z=z;
	}
	//Overloading with 3 variables
	public double distance (Point3D p)
	{
		System.out.println("5. Invoking distance(Point3D Obj) in Point3D");
		return distance (p.x,p.y,p.z);
	}
	
	@Override
	public double distance() {
		System.out.println("6. Invoking distance() in Point3D");
		return Math.sqrt(x*x + y*y + z*z);
	}

	//Distance calculation from some point which is not 0,0,0
	public double distance(int x ,int y,int z) {
		System.out.println("7. Invoking distance(x,y,z) in Point3D");
		int diffx =this.x-x;
		int diffy =this.y-y;
		int diffz =this.z-z;
		return Math.sqrt(diffx*diffx +diffy*diffy + diffz*diffz);
	}
	
	//Main function
	public static void main(String[] args) {
		System.out.println(Point.ORIGIN.distance()); 
		System.out.println(ORIGIN.distance());  // (or) Point p =new Point3D(); p.distance(); 
		Point p0=new Point3D(); p0=new Point(); p0.distance(); //Invokes distance in point after the object is assigned wit Point after Point3D
		System.out.println("-------------");
		// Point p1= new Point(10,20);
		// Point p2= new Point3D(10,20,30); // First super then rest
		// double dis =p.distance(new Point3D(20,30,40)); //Why 3. is invoked should ask
		double dis1 =p0.distance(new Point(20,30)); //Why 3. is invoked should ask
		System.out.println("-------------");
		Point3D p=new Point3D(2,3,4);
		System.out.println(p.distance());
		System.out.println("-------------");
		Point3D p1=new Point3D();
		System.out.println(p1.distance(2,3,4));
		System.out.println("-------------");
		Point3D p3=new Point3D(3,4,5);
		System.out.println(p3.distance(p));
	}
}
