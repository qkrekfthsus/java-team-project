package student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> studentArray = new ArrayList<>();
	
	public static void registerStudent() {
		//Menu.selectMenu();
		
		String[] studentInfo = new String[6];
		
		System.out.println("*���ο� �л� ������ ����մϴ�.");
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �й��� �Է����ּ���. (����8�ڸ�)");
		studentInfo[0] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �г��� �Է����ּ���. (����1�ڸ�)");
		studentInfo[1] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �̸��� �Է����ּ���.");
		studentInfo[2] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �а��� �Է����ּ���.");
		studentInfo[3] = sc.nextLine();
		
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� ��ȭ��ȣ�� �Է����ּ���. (ex. 010-xxxx-xxxx)");
		studentInfo[4] = sc.nextLine();
		
		studentInfo[5] = "����";
		
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
