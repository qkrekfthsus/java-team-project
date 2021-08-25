package student;

import java.util.Scanner;

public class GradeManagement {
	
	public static void gradeMenu() {
		Scanner scanner = new Scanner(System.in);

		int MainMenuNum = 0;

		while(true) {
			System.out.println("========================================================");
			System.out.println("sfjsdfsdfsdkjf���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
			System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
			System.out.println("========================================================");
			MainMenuNum = Integer.parseInt(scanner.nextLine());

			if(MainMenuNum == 1) {
				StudentManagement.registerStudent();
				break;
			}else if(MainMenuNum == 2){
				StudentManagement.searchStudent();
				break;
			}else if(MainMenuNum == 3){
				StudentManagement.changeStudent();
				break;
			}else if(MainMenuNum == 4) {
				StudentManagement.gradeManagement();
				break;
			}else if(MainMenuNum == 5) {
				// System.out.println("���α׷��� ����Ǿ����ϴ�.");
				// �����Ͻðڽ��ϱ�?(y/n)
				// FileManager.saveStudentFile();
				// FileManager.saveScoreFile();
				break;
			}else {
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.println("========================================================");
				System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
				System.out.println("========================================================");
				MainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}
	
	public static void readGrade() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=======================================================");
		System.out.println("������ ��ȸ�� �л��� �й��� �Է����ּ���.");
		System.out.println("=======================================================");
		
		int student_id = Integer.parseInt(scanner.nextLine());
		
		Student readForStudent = Student.getStudentFromID(student_id);
		
		if(readForStudent != null) {
			if(!readForStudent.grade.isEmpty()) {
				for(Grade grade : readForStudent.grade) {
					System.out.println("=======================================================");
					System.out.println();
					System.out.println("=======================================================");
					
				}
			}
			else {
				System.out.println("��ȸ�� ������ �����ϴ�.");
			}
		}
		else {
			System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
		}
		
	}
	
}
