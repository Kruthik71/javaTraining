package Day7;

public class AdderImpl implements Adder{

	@Override
	public int add(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) {
		Adder a=new AdderImpl();
		//1
		System.out.println(a.add(1, 10));
		
		//2
		Adder a1=new Adder(){
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		System.out.println(a1.add(1, 10));
		
		//3 (Lambda expression)
		Adder a2=(i,j)->{return i+j;};
		System.out.println(a2.add(1, 10));
		
	}   
}
