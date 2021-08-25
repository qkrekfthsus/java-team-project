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
	static int savepoint = -1;


	public static void registerStudent() {

	}

	public static void searchStudent() {

	}

	public static void changeStudent() throws IOException {
		ArrayList<Student> studentArray = new ArrayList<>();
		studentArray.addAll(FileManager.studentArray);
		
		// �й� �г� �̸� �а� ��ȭ��ȣ ��������
		while (true) {
			MainScreen();
			input = scanner.nextLine();
			
			Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
			
			if(updateStudent == null){
				System.out.println("���� ���� �ʴ� �й��Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			else {
				First(updateStudent);
			}
			
			input = scanner.nextLine();

			if (input.equals("y")) {
				System.out.println("====================================================");
				System.out.println("������ �׸��� �Է����ּ���.");
				System.out.println("====================================================");
				input = scanner.nextLine();
				
				if (input.equals("�й�")) {
					function(0, updateStudent,"�й�");
					continue;
				}
				else if (input.equals("�г�")) {
					function(1,updateStudent,"�г�");
					break;
				}
				else if (input.equals("�̸�")) {
					function(2,updateStudent,"�̸�");
					break;
				}
				else if (input.equals("�а�")) {
					function(3,updateStudent,"�а�");
					break;
				}
				else if (input.equals("��ȭ��ȣ")) {
					function(4,updateStudent,"��ȭ��ȣ");
					break;
				}
				else if (input.equals("��������")) {
					function(5,updateStudent,"��������");
					break;
				} else {

					System.out.println("�ٽ��Է����ּ���");
					System.out.println("====================================================");
					continue;
				}

			}
			if (input == "n") {
				break;
			}

			else {
				System.out.println("�ٽ��Է����ּ���.");
				continue;
			}
		}
	}
	public static void MainScreen() {
		System.out.println("====================================================");
		System.out.println("���������� ������ �л��� �й��� �Է����ּ���.");
		System.out.println("====================================================");
	}
	
	public static void First(Student updateStudent) {
		System.out.println("====================================================");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
		System.out.println(updateStudent.toString());
		System.out.println("���� ������ ���� �Ͻðڽ��ϱ�?(y/n)");
		System.out.println("====================================================");
	}
	
	public static void function(int a,Student student , String b) {
		if (a == 0) {
			System.out.println("�й��� �����Ҽ� �����ϴ�.");
		} 
		else if(a==1) {
			ChangeGrade(student);
		}
		else if(a==2) {
			ChangeName(student);
		}
		else if(a==3) {
			ChangeMajor(student);
		}
		else if(a==4) {
			Changetel(student);
		}
		else if(a==5) {
			ChangeState(student);
		}
	}
	public static void ChangeGrade(Student student) {
		System.out.println("====================================================");
		System.out.println("������ �г��� �Է����ּ���. ���� �г���" + student.student_grade+ "�г��Դϴ�.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_grade = Integer.parseInt(input);
		Print(student);
	}
	public static void ChangeName(Student student) {
		System.out.println("====================================================");
		System.out.println("������ �̸��� �Է����ּ���. ���� �̸���" + student.student_name+ "�Դϴ�.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_name = input;
		Print(student);
	}
	public static void ChangeMajor(Student student) {
		System.out.println("====================================================");
		System.out.println("������ �а��� �Է����ּ���. ���� �а���" + student.student_major+ "�Դϴ�.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_major = input;
		Print(student);
	}
	public static void Changetel(Student student) {
		System.out.println("====================================================");
		System.out.println("������ ��ȭ��ȣ�� �Է����ּ���. ���� ��ȭ��ȣ��" + student.student_tel+ "�Դϴ�.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_tel = input;
		Print(student);
	}
	public static void ChangeState(Student student) {
		System.out.println("====================================================");
		System.out.println("������ �������¸� �Է����ּ���. ���� �������´�" + student.student_state+ "�Դϴ�.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_state = input;
		Print(student);
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

	//@Override
	//public String toString() {
	//	return String.format("%03d-%03d-%04d", Student[0], Student, Student);
	//}

}
