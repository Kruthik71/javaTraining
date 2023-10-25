package SelfLearning;

public class Overrding extends Overloading{
	public Overrding() {
		super.message();
	}
	public void message() {
		System.out.println("This is Overriding");
	}
	public static void main(String[] args) {
		Overrding over1=new Overrding();
//		Overloading over2=new Overloading();
//		over2.message();
//		over1.message();
	}
}
