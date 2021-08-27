package student;

import java.util.Scanner;

public class ScoreManagement {

	public static void scoreMenu(Scanner scanner) {

		while (true) {
			System.out.println("------------------------------------------------------------");
			System.out.println("���ϴ� ����� �������ּ���.( 1~4 ��ȣ�� �Է����ּ���.)");
			System.out.println("1.���� �Է�  2.���� ��ȸ  3.���� ����   4.�����޴�");
			System.out.println("------------------------------------------------------------");

			int scoreMenuNum = Integer.parseInt(scanner.nextLine());

			if (scoreMenuNum == 1) {
				registerScore();
			} else if (scoreMenuNum == 2) {
				readScore(scanner);
			} else if (scoreMenuNum == 3) {
				changeScore(scanner);
			} else if (scoreMenuNum == 4) {
				break;
			} else {
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

	public static void registerScore() {
		System.out.println("������ �Է��� �л��� �й��� �Է����ּ���.");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
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
						System.out.println();
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "���� �ڵ�", "�����", "����",
								"��米��", "����", "���� ����"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentToRead.score) {
							System.out.println(grade.toString());

						}
					} else {
						System.out.println("��ȸ�� ������ �����ϴ�.");
					}
				} else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}
				System.out.println();
				System.out.println("------------------------------------------------------------");
				System.out.println("�ٸ� �л��� ��ȸ�Ͻðڽ��ϱ�?(y/n)");
				System.out.println("------------------------------------------------------------");

				if (scanner.nextLine().equals("y")) {
					restart = true;
				} else {
					System.out.println("���� ��ȸ�� ��ġ�� ���� ���� �޴��� ���ư��ϴ�.");
					restart = false;
				}

				// restart = scanner.nextLine().equals("y") ? true : false;
			} catch (NumberFormatException e) {
				System.out.println("�й� 8�ڸ� ���ڸ� �Է����ּ���.");
			}
		}

	}

	// ���� �����ϱ� �� ���� ��� �ؾߵ�
	public static void changeScore(Scanner scanner) {
		Student changeScoreStudent;
		String input;

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ ������ �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");
				String inputID = scanner.nextLine();

				changeScoreStudent = Student.getStudentFromID(Integer.parseInt(inputID));
				if (changeScoreStudent == null) {
					System.out.println("------------------------------------------------------------");
					System.out.println("���� �й��Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println("------------------------------------------------------------");
					continue;
				}

				System.out.println("------------------------------------------------------------");
				System.out.println("������ ������ �����ڵ带 �Է����ּ���. (ó������ ���ư���(n))");
				System.out.println("------------------------------------------------------------");
				String inuputCode = scanner.nextLine();
				if (inuputCode.equals("n")) {
					break;
				} else {
					Score scoreUpdate = null;
					for (int i = 0; i < changeScoreStudent.score.size(); i++) {
						if (inuputCode.equals(String.valueOf(changeScoreStudent.score.get(i).subject_code))) {
							scoreUpdate = changeScoreStudent.score.get(i);
						}
					}
					// System.out.println(scoreUpdate.toString());

					if (scoreUpdate == null) {
						System.out.println("------------------------------------------------------------");
						System.out.println("���� �����ڵ��Դϴ�. �ٽ� �Է����ּ���.");
						System.out.println("------------------------------------------------------------");
						continue;
					}
					System.out.println("----------------------------------------------------------------------");
					System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�",
							"����", "����", "�������"));
					System.out.println(scoreUpdate.toString());
					System.out.println("������ ���� �Ͻðڽ��ϱ�?(y/n)");
					System.out.println("----------------------------------------------------------------------");

					input = scanner.nextLine();
					if (input.equals("y")) {
						System.out.println("------------------------------------------------------------");
						System.out.println("������ ������ �Է����ּ���.");
						System.out.println("------------------------------------------------------------");
						input = scanner.nextLine();
						scoreUpdate.score = input;

						System.out.println("------------------------------------------------------------");
						System.out.println("��������� �Է����ּ���");
						System.out.println("------------------------------------------------------------");

						input = scanner.nextLine();
						scoreUpdate.reason = input;
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������",
								"�����̸�", "����", "����", "�������"));
						System.out.println(scoreUpdate.toString());
						System.out.println("�����Ǿ����ϴ�.");
						System.out.println("----------------------------------------------------------------------");

						input = scanner.nextLine();

					}
				}

			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է����ּ���. �й��� 8�ڸ� �����Դϴ�.");
			}
		}

	}

}
