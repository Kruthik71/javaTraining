package SelfLearning;

public class Student {
	private int id;
	
	static void updateId(Student s1) {
		System.out.println("S1 address is :"+s1);
		s1.id=20;
	}
	
	public static void main(String[] args) {
		Student stu=new Student();
		stu.id=10;
		
		System.out.println(stu);
		
		updateId(stu);
		
	}
}
