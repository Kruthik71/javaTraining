package Kruthik;

public class Hello {
	int y;
	Hello(int x){
		this.y=x;
	}
	public static void main(String[] args) {
		Hello h=new Hello(4);
//		System.out.println(h.y);
//		System.out.println("Hello Team !");
		String s ="Hello World";
		String s1 = "Hello World";
		System.out.println(s==s1);
		final String s2 = "Hello"; // Without final false with final true
		String s3 = s2 +" World";
		System.out.println(s==s3);
	} 
}

// main + ctrl + space 
//