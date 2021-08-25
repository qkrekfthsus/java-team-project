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
		
		// 학번 학년 이름 학과 전화번호 학적상태
		while (true) {
			MainScreen();
			input = scanner.nextLine();
			
			Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
			
			if(updateStudent == null){
				System.out.println("존재 하지 않는 학번입니다. 다시 입력해주세요.");
				continue;
			}
			else {
				First(updateStudent);
			}
			
			input = scanner.nextLine();

			if (input.equals("y")) {
				System.out.println("====================================================");
				System.out.println("변경할 항목을 입력해주세요.");
				System.out.println("====================================================");
				input = scanner.nextLine();
				
				if (input.equals("학번")) {
					function(0, updateStudent,"학번");
					continue;
				}
				else if (input.equals("학년")) {
					function(1,updateStudent,"학년");
					break;
				}
				else if (input.equals("이름")) {
					function(2,updateStudent,"이름");
					break;
				}
				else if (input.equals("학과")) {
					function(3,updateStudent,"학과");
					break;
				}
				else if (input.equals("전화번호")) {
					function(4,updateStudent,"전화번호");
					break;
				}
				else if (input.equals("학적상태")) {
					function(5,updateStudent,"학적상태");
					break;
				} else {

					System.out.println("다시입력해주세요");
					System.out.println("====================================================");
					continue;
				}

			}
			if (input == "n") {
				break;
			}

			else {
				System.out.println("다시입력해주세요.");
				continue;
			}
		}
	}
	public static void MainScreen() {
		System.out.println("====================================================");
		System.out.println("인적사항을 변경할 학생의 학번을 입력해주세요.");
		System.out.println("====================================================");
	}
	
	public static void First(Student updateStudent) {
		System.out.println("====================================================");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
		System.out.println(updateStudent.toString());
		System.out.println("인적 사항을 변경 하시겠습니까?(y/n)");
		System.out.println("====================================================");
	}
	
	public static void function(int a,Student student , String b) {
		if (a == 0) {
			System.out.println("학번은 변경할수 없습니다.");
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
		System.out.println("변경할 학년을 입력해주세요. 현재 학년은" + student.student_grade+ "학년입니다.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_grade = Integer.parseInt(input);
		Print(student);
	}
	public static void ChangeName(Student student) {
		System.out.println("====================================================");
		System.out.println("변경할 이름을 입력해주세요. 현재 이름은" + student.student_name+ "입니다.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_name = input;
		Print(student);
	}
	public static void ChangeMajor(Student student) {
		System.out.println("====================================================");
		System.out.println("변경할 학과를 입력해주세요. 현재 학과는" + student.student_major+ "입니다.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_major = input;
		Print(student);
	}
	public static void Changetel(Student student) {
		System.out.println("====================================================");
		System.out.println("변경할 전화번호를 입력해주세요. 현재 전화번호는" + student.student_tel+ "입니다.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_tel = input;
		Print(student);
	}
	public static void ChangeState(Student student) {
		System.out.println("====================================================");
		System.out.println("변경할 학적상태를 입력해주세요. 현재 학적상태는" + student.student_state+ "입니다.");
		System.out.println("====================================================");
		input = scanner.nextLine();
		student.student_state = input;
		Print(student);
	}
	public static void Print(Student student) {
		System.out.println("====================================================");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
		System.out.println(student.toString());
		System.out.println("변경되었습니다.");
		System.out.println("====================================================");
	}
	
	public static void gradeManagement(){
		
	}

	//@Override
	//public String toString() {
	//	return String.format("%03d-%03d-%04d", Student[0], Student, Student);
	//}

}
