package student;

import java.util.Scanner;

public class ScoreManagement {

	// �л� ���� ���� �޴�
	public static void scoreMenu(Scanner scanner) {

		while (true) {
			System.out.println("------------------------------------------------------------");
			System.out.println("���ϴ� ����� �������ּ���.( 1~4 ��ȣ�� �Է����ּ���.)");
			System.out.println("1.���� �Է�  2.���� ��ȸ  3.���� ����   4.�����޴�");
			System.out.println("------------------------------------------------------------");

			int scoreMenuNum = Integer.parseInt(scanner.nextLine());

			if (scoreMenuNum == 1) {
				registerScore(scanner);
			} else if (scoreMenuNum == 2) {
				readScore(scanner);
			} else if (scoreMenuNum == 3) {
				// changeScore(scanner);
			} else if (scoreMenuNum == 4) {
				break;
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

	public static void registerScore(Scanner scanner) {

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ �Է��� �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());
				Student student = Student.getStudentFromID(student_id);
				
				if (student != null) {
					
					System.out.println("------------------------------------------------------------");
					System.out.println("������ �Է��� ���� �ڵ带 �Է����ּ���.");
					String code = scanner.nextLine();
					
					if (!student.score.isEmpty()) {
						String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s");
						for (Score inScore : student.score) {
							inScore.toString().contains(code);
						}System.out.println("������ �̹� �ԷµǾ� �ֽ��ϴ�.");
					} else {
						System.out.println("�ش� ������ ������ �Է����ּ���.");
						String score = scanner.nextLine();
						
						// ������ �� �ִ� �������� ��� ���
						for (int i = 0; i < student.score.size(); i++) {
							System.out.println(student.score.get(i).getScoreWithoutID());
						}
						
						//student.score = score;
					}
				} else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}
			} catch (NumberFormatException e) {
				System.out.println("�й��� Ȯ���� �ٽ� �Է����ּ���.");
			}
		}

	}

	public static void readScore(Scanner scanner) {
		boolean restart = true;
		while (restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ ��ȸ�� �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());

				Student studentToRead = Student.getStudentFromID(student_id);

				if (studentToRead != null) {
					if (!studentToRead.score.isEmpty()) {
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "���� �ڵ�", "�����", "����",
								"��米��", "����", "���� ����"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentToRead.score) {
							System.out.println(grade.toString());
							// 20160506 C051 ��ȸ���������� ������ ���� C ����
						}
					} else {
						System.out.println("��ȸ�� ������ �����ϴ�.");
					}
				} else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}
				System.out.println("----------------------------------------------------------------------");
				System.out.println("�ٸ� �л��� ��ȸ�Ͻðڽ��ϱ�?(y/n)");
				System.out.println("----------------------------------------------------------------------");

				restart = scanner.nextLine().equals("y") ? true : false;
			} catch (NumberFormatException e) {
				System.out.println("�й� 8�ڸ� ���ڸ� �Է����ּ���.");
			}
		}

	}

	public static void changeScore() {
	}

}
