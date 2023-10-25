package Kruthik1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee{
	public int senior;
	public int experience;
	public String name;
	public int age;
	public double salary;
	
	public Employee(int s,int e,String n,int a,double amt) {
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
    
	public static Comparator<Employee> empCompare = new Comparator<Employee> (){
		public int compare(Employee emp1, Employee emp2) {
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
		ArrayList<Employee> emps=new ArrayList<Employee>();
		emps.add(new Employee(1,4,"Kruthik",22,40000));
		emps.add(new Employee(3,7,"Gowrav",25,70000));
		emps.add(new Employee(5,10,"Shashank",28,165000));
		emps.add(new Employee(7,12,"Akhil",36,265000));
		//System.out.println(emps.size());
		System.out.println("-----------------------");
		for (Employee emp:emps) {
			System.out.println("Seniority "+emp.getSeniority() +" Experience "+ emp.getExperience() +" Name "+emp.getName());
		}
		System.out.println("-----------------------");
		Collections.sort(emps, empCompare); //Passing the arrayList and the method that is used to compare the objects
		//System.out.println(emps.size());
		for (Employee emp:emps) {
			System.out.println("Seniority "+emp.getSeniority() +" Experience "+ emp.getExperience() +" Name "+emp.getName());
		}
		System.out.println("-----------------------");
		EmployeeGenerator e1 = new EmployeeGenerator();

		System.out.println("Seniority "+e1.getSeniority()+" Age "+e1.getAge()+" Experience "+e1.getExperience()+" Name "+e1.getName()+" Salary "+e1.getSalary());
		//employeeSet(new ArrayList<>());
	}
}
