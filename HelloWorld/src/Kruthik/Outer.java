package Kruthik;

public class Outer {
	private int x;
	public Inner createrInner() {
		return new Inner();
	}
	
	//Here its confined to this class and subclasses
	public static interface some{
		
	}
	
	public abstract static class StaticInner implements some{
		public void jumpBy10(Outer o) {
			// x= x+10 is not possible cause x is not static
			o.x=o.x+10;
			//can be done cause we are accessing it through Outer class object
		}
		public abstract void jumpBy100(Outer o);
	}
	
	private class Inner{
		public void printX() {
			System.out.println("X = "+x);
		}
		public void increment() {
			x++;
		}
	}
	
	public static void main(String[] args) {
		Outer o=new Outer();
		Outer.Inner i=o.createrInner();
		Outer.Inner i1=o.createrInner();
		System.out.println(i);
		System.out.println(i1);
		i1.increment();
		i.printX(); //Same outer instance so x will be incremented
		new Outer().createrInner().printX(); //different outer instance so x will remain 0
		StaticInner si= new StaticInner() {
			@Override
			public void jumpBy100(Outer o) {
				o.x=o.x+100;
			}
		};
		si.jumpBy10(o);
		si.jumpBy100(o);
		i.printX();
		
	}
}
