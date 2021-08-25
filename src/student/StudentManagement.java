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
		String[] list = {"학번", "학년", "이름", "학과", "전화번호", "학적상태"};
		
		while (true) {
			
	
			System.out.println("====================================================");
			System.out.println("인적사항을 변경할 학생의 학번을 입력해주세요.");
			System.out.println("====================================================");
			
			input = scanner.nextLine();
			
			try{
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				if(updateStudent == null){
					System.out.println("존재 하지 않는 학번입니다. 다시 입력해주세요.");
					continue;
				}
				else {
					studentInfoArray = new String[]{String.valueOf(updateStudent.student_id),String.valueOf(updateStudent.student_grade),updateStudent.student_name,
							updateStudent.student_major,updateStudent.student_tel,updateStudent.student_state};
					System.out.println("====================================================");
					System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
					System.out.println(updateStudent.toString());
					System.out.println("인적 사항을 변경 하시겠습니까?(y/n)");
					System.out.println("====================================================");
					input = scanner.nextLine();

					if (input.equals("y")) {
						System.out.println("====================================================");
						System.out.println("변경할 항목을 입력해주세요. (항목 : 학번, 학년, 이름, 학과, 전화번호, 학적상태)");
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
				System.out.println("숫자를 입력해주세요.");
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
			System.out.println("항목이 잘못입력되었습니다.");
		}
		
		else {
			System.out.println("====================================================");
			System.out.println("변경할 " +list[index]+"을(를) 입력해주세요. 현재 "+list[index]+"은(는) " +studentInfoArray[index]+"입니다.");
			System.out.println("====================================================");
			switch(index) {
				case 0:
					System.out.println("학번은 변경할수 없습니다.");
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
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
		System.out.println(student.toString());
		System.out.println("변경되었습니다.");
		System.out.println("====================================================");
	}
	
	public static void gradeManagement(){
		
	}

}
