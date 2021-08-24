package student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> studentArray = new ArrayList<>();
	
	public static void registerStudent() {
		//Menu.selectMenu();
		
		String[] studentInfo = new String[6];
		
		System.out.println("*새로운 학생 정보를 등록합니다.");
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학번을 입력해주세요. (숫자8자리)");
		studentInfo[0] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학년을 입력해주세요. (숫자1자리)");
		studentInfo[1] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 이름을 입력해주세요.");
		studentInfo[2] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학과를 입력해주세요.");
		studentInfo[3] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 전화번호를 입력해주세요. (ex. 010-xxxx-xxxx)");
		studentInfo[4] = sc.nextLine();
		
		studentInfo[5] = "재학";
		
		Student student = new Student(studentInfo);
		studentArray.add(student);
		
		for (Student studentarr : studentArray) {
			System.out.print(studentarr.student_id);
			System.out.print(studentarr.student_grade);
			System.out.print(studentarr.student_name);
		}
		
		System.out.println("");
	}
	
	public static void searchStudent() {
		
	}
	
	public static void changeStudent() {
		
	}
	
	public static void gradeManagement() {
		
	}

}
