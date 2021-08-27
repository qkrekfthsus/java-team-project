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

				Student studentScore = Student.getStudentFromID(student_id);

				if (studentScore != null) {
					if (!studentScore.score.isEmpty()) {
						System.out.println();
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "���� �ڵ�", "�����", "����",
								"��米��", "����", "���� ����"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentScore.score) {
							System.out.println(grade.toString());

						}
					} else {
						System.out.println("��ȸ�� ������ �����ϴ�.");
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
