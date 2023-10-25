package Day7;
import SelfLearning.*;

public class VarArgs extends Overloading{
	
	public VarArgs() {
		super.message();
	}
	public int add(int a,int ... b) {
		int res=a;
		for(int b1:b) {
			res+=b1;
		}
		return res;
	}
	public static void main(String[] args) {
		VarArgs va=new VarArgs();
		
		//a mandatory arguments
		System.out.println(va.add(2));
		System.out.println(va.add(2,3));
		System.out.println(va.add(2,3,4));
		System.out.println(va.add(2,3,4,5));
	}
}
