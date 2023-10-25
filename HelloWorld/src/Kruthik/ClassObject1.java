package Kruthik;

public class ClassObject1 extends ClassObject{
	// ORIGIN can be defined here also
	public static final ClassObject1 ORIGIN=new ClassObject1();
	private int c;
	@Override
	public double distance() {
		System.out.println("ClassObject1 Distance");
		return Math.sqrt(a*a+b*b+c*c);
	}
	public static void main(String[] args) {
		ORIGIN.a=10;
		ClassObject1 Obj=new ClassObject1();
		System.out.println(ClassObject.ORIGIN.a);
		System.out.println(ClassObject.ORIGIN.b);
		System.out.println(Obj.c);
		System.out.println(ClassObject.ORIGIN.distance());
		System.out.println(ORIGIN.distance());
	}
}
