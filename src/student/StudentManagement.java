package student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	
	public static void registerStudent() {

	}

	public static void searchStudent() {

	}

	public static void changeStudent(){
		ArrayList<Student> studentArray = new ArrayList<>();
		studentArray.addAll(FileManager.studentArray);
		String[] studentInfoArray = new String[6];
		String[] list = {"�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"};
		
		while (true) {
			
	
			System.out.println("====================================================");
			System.out.println("���������� ������ �л��� �й��� �Է����ּ���.");
			System.out.println("====================================================");
			
			input = scanner.nextLine();
			
			try{
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				if(updateStudent == null){
					System.out.println("���� ���� �ʴ� �й��Դϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				else {
					studentInfoArray = new String[]{String.valueOf(updateStudent.student_id),String.valueOf(updateStudent.student_grade),updateStudent.student_name,
							updateStudent.student_major,updateStudent.student_tel,updateStudent.student_state};
					System.out.println("====================================================");
					System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
					System.out.println(updateStudent.toString());
					System.out.println("���� ������ ���� �Ͻðڽ��ϱ�?(y/n)");
					System.out.println("====================================================");
					input = scanner.nextLine();

					if (input.equals("y")) {
						System.out.println("====================================================");
						System.out.println("������ �׸��� �Է����ּ���. (�׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
						System.out.println("====================================================");
						input = scanner.nextLine();
						int index = getListIndex(input,list);
						
						update(index,list,studentInfoArray,updateStudent);
					}
					else {
						continue;
					}
				}
			}catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}
		}
	}
	
	public static int getListIndex(String input,String[] list) {
		for(int i =0; i< list.length; i++) {
			if(input.equals(list[i])) {
				return i;
			}
		}
		return -1;
	}
	public static void update(int index,String[] list,String[] studentInfoArray,Student student) {
		if(index == -1) {
			System.out.println("�׸��� �߸��ԷµǾ����ϴ�.");
		}
		
		else {
			System.out.println("====================================================");
			System.out.println("������ " +list[index]+"��(��) �Է����ּ���. ���� "+list[index]+"��(��) " +studentInfoArray[index]+"�Դϴ�.");
			System.out.println("====================================================");
			switch(index) {
				case 0:
					System.out.println("�й��� �����Ҽ� �����ϴ�.");
					break;
				case 1:
					input = scanner.nextLine();
					student.student_grade = Integer.parseInt(input);
					Print(student);
					break;
				case 2:
					input = scanner.nextLine();
					student.student_name = input;
					Print(student);
					break;
				case 3:
					input = scanner.nextLine();
					student.student_major = input;
					Print(student);
					break;
				case 4:
					input = scanner.nextLine();
					student.student_tel = input;
					Print(student);
					break;
				case 5:
					input = scanner.nextLine();
					student.student_state = input;
					Print(student);
					break;
			}
		}
	}
	
	public static void Print(Student student) {
		System.out.println("====================================================");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
		System.out.println(student.toString());
		System.out.println("����Ǿ����ϴ�.");
		System.out.println("====================================================");
	}
	
	public static void gradeManagement(){
		
	}

}
