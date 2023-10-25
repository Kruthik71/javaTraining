package Kruthik1;

public class EmployeeGenerator{
	
	private int senior;
	private int experience;
	private String name;
	private int age;
	private double salary;
		
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
	
	public EmployeeGenerator(){
	
		this.age=(int)(Math.random()*(60-22+1)+22);
		
		this.experience=age-22;
		
		if(age>=22 && age<=30) {
			this.senior=(int)(Math.random()*4); //0-4
		}
		else if(age>=31 && age<=41) {
			this.senior=(int)(Math.random()*(8-5+1)+5); //5-8
		}
		else if(age>=42 && age<=52) {
			this.senior=(int)(Math.random()*(12-8+1)+8); //8-12
		}
		else{
			this.senior=(int)(Math.random()*(15-12+1)+12); //12-15
		}
		
		this.salary=(age*18)*1000;
		
		String name=""; //Empty String
		int nameSize=(int)(Math.random()*(12-4+1)+4); //String size should be between 4 to 12
		for (int i = 0; i <=nameSize ; i++) {
			char randomChar = (char) ((int)(Math.random()*26 + 'a')); // char(ASCII) (random number+"a")
			name+=randomChar;
		}
		name=name.substring(0,1).toUpperCase()+name.substring(1); // k(0,1) ruthik
		this.name=name;
	}

}
