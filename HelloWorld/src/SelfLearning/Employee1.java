package SelfLearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee1{
	public int senior;
	public int experience;
	public String name;
	public int age;
	public double salary;
	
	public Employee1(int s,int e,String n,int a,double amt) {
		this.senior=s;
		this.experience=e;
		this.name=n;
		this.age=a;
		this.salary=amt;
	}
	
	public int getSeniority() {
        return senior;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    
	public static Comparator<Employee1> empCompare = new Comparator<Employee1> (){
		public int compare(Employee1 emp1, Employee1 emp2) {
			//Sorting on the basis of taking highest number as more senior member
			int sC = Integer.compare(emp1.getSeniority(), emp2.getSeniority());
            if (sC == -1) {
                return 1;
            }
            //If the seniority is same then it should be sorted based on experience in the same way as seniority
            int eC = Integer.compare(emp1.getExperience(), emp2.getExperience());
            if (eC == -1) {
                return 1;
            }
            //Lastly by name 
           return emp1.getName().compareTo(emp2.getName());
		}
	};
	
	public static void main(String[] args) {
		//Can be added this way also
		ArrayList<Employee1> emps=new ArrayList<Employee1>();
		emps.add(new Employee1(1,4,"Kruthik",22,40000));
		emps.add(new Employee1(3,7,"Gowrav",25,70000));
		emps.add(new Employee1(5,10,"Shashank",28,165000));
		emps.add(new Employee1(7,12,"Akhil",36,265000));
		System.out.println("-----------------------");
		for (Employee1 emp:emps) {
			System.out.println("Seniority "+emp.getSeniority() +" Experience "+ emp.getExperience() +" Name "+emp.getName());
		}
		System.out.println("-----------------------");
		Collections.sort(emps, empCompare); //Passing the arrayList and the method that is used to compare the objects
		for (Employee1 emp:emps) {
			System.out.println("Seniority "+emp.getSeniority() +" Experience "+ emp.getExperience() +" Name "+emp.getName());
		}
		System.out.println("-----------------------");
	}
}

