import java.util.*;

public class Task2_EmployeeSalarySort {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int employeeCount = sc.nextInt();
		sc.nextLine();
		Employee[] employeeList = new Employee[employeeCount];
		float[] salaryRank = new float[employeeCount];
		
		for (int i = 0; i < employeeCount; ++i) {
			String[] tempArr = sc.nextLine().split(", ");
			employeeList[i] = new Employee(tempArr[0], Float.valueOf(tempArr[1]), tempArr[2], tempArr[3]);
			salaryRank[i] = employeeList[i].getSalary();
			if(tempArr.length == 6) {
				employeeList[i].setAge(Short.valueOf(tempArr[4]));
				employeeList[i].setEmail(tempArr[5]);
			}
		}

		Arrays.sort(salaryRank);
		
		for (int j = employeeCount -1; j >= employeeCount - 3; --j) {
			for (int i = 0; i < employeeCount; ++i) {
				try {
					if (salaryRank[j] == employeeList[i].getSalary()) {
						System.out.printf("%s, %s, %s", employeeList[i].getName(),
								employeeList[i].getDepartment(), employeeList[i].getPosition());
						if (employeeList[i].getEmail().equals("")) {
							System.out.println();
						} else {
							System.out.printf(", %s\n", employeeList[i].getEmail());
						}
					}
				} catch(Exception ArrayIndexOutOfBoundsException) {}
			}
		}
		
		sc.close();
		
	}

}

class Employee {
	
	private String name;
	private float salary;
	private String position;
	private String department;
	private short age = -1;
	private String email = "";
	
	public Employee(String name, float salary, String position, String department) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
	}
	
	public Employee(String name, float salary, String position, String department, short age, String email) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.age = age;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}