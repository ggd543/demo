public class Person{
	
	public Person(){
		say();
	}
	
	public void say(){
		System.out.println("Person.say... ");
	}
	
	public static void main(String[] args){		
		new Student();  // 打印Student.say
	}
}

class Student extends Person{
	public Student(){
		super();
	}
	public void say(){
		System.out.println("Student.say...");
	}
}

