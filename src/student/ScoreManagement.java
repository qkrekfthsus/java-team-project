package student;

import java.util.Scanner;

public class ScoreManagement {
	
	public static void scoreMenu() {
		Scanner scanner = new Scanner(System.in);

		int MainMenuNum = 0;

		while(true) {
			System.out.println("========================================================");
			System.out.println("sfjsdfsdfsdkjf���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
			System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
			System.out.println("========================================================");
			MainMenuNum = Integer.parseInt(scanner.nextLine());

			if(MainMenuNum == 1) {
				StudentManagement.registerStudent(scanner);
				break;
			}else if(MainMenuNum == 2){
				StudentManagement.searchStudent(scanner);
				break;
			}else if(MainMenuNum == 3){
				StudentManagement.changeStudent(scanner);
				break;
			}else if(MainMenuNum == 4) {
				
				break;
			}else if(MainMenuNum == 5) {
				// System.out.println("���α׷��� ����Ǿ����ϴ�.");
				// �����Ͻðڽ��ϱ�?(y/n)
				// FileManager.saveStudentFile();
				// FileManager.saveScoreFile();
				break;
			}else {
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.println("----------------------------------------------------------------------");
				System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
				System.out.println("----------------------------------------------------------------------");
				MainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}
	
	public static void registerScore() {}
	
	public static void readScore(Scanner scanner) {
		boolean restart = true;
		while(restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ ��ȸ�� �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");
				
				int student_id = Integer.parseInt(scanner.nextLine());
				
				Student studentToRead = Student.getStudentFromID(student_id);
				
				if(studentToRead != null) {
					if(!studentToRead.score.isEmpty()) {
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "���� �ڵ�", "�����", "����", "��米��", "����", "���� ����"));
						System.out.println("----------------------------------------------------------------------");

						for(Score grade : studentToRead.score) {
							System.out.println(grade.toString());
						// 20160506	C051	��ȸ����������	������	����	C	����	
						}
					}
					else {
						System.out.println("��ȸ�� ������ �����ϴ�.");
					}
				}
				else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}
				System.out.println("----------------------------------------------------------------------");
				System.out.println("�ٸ� �л��� ��ȸ�Ͻðڽ��ϱ�?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				
				restart = scanner.nextLine().equals("y") ? true :false;
			}
			catch(NumberFormatException e) {
				System.out.println("�й� 8�ڸ� ���ڸ� �Է����ּ���.");
			}
		}
		
	}
	
	public static void changeScore() {}
	
}
