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

	// �л� ���� ���
	public static void registerScore() {
		System.out.println("������ �Է��� �л��� �й��� �Է����ּ���.");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
	}

	// �л� ���� ��ȸ
	public static void readScore(Scanner scanner) {
		boolean restart = true;
		
		while (restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ ��ȸ�� �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());
				
				// �й��� ���� �ش� �л��� ���� ��ȸ
				Student studentToRead = Student.getStudentFromID(student_id);

				// �л� ����Ʈ�� �ִ� �л��� �й��� �Է��� ���
				if (studentToRead != null) {
					// �л��� ������ �����ϴ� ��� ���� ���
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
						// �л��� ������ �������� �ʴ� ���
						System.out.println("��ȸ�� ������ �����ϴ�.");
					}
					
				} else {
					// �л� ����Ʈ�� ���� �й��� �Է��� ���
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

			} catch (NumberFormatException e) {
				// �й��� �Է� ���� ��, ���ڰ� �ƴ� ���ڿ��� �޾��� ��� ���� ó��
				System.out.println("�й� 8�ڸ� ���ڸ� �Է����ּ���.");
			}
		}

	}

	// �л� ���� ���� ����
	public static void changeScore(Scanner scanner) {
		Student changeScoreStudent;
		String input;

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ ������ �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");
				String inputID = scanner.nextLine();

				if (inputID.equals("n")) {
					break;
				} else {
					// �Է��� �й����� �л� ��ü�� ã��
					changeScoreStudent = Student.getStudentFromID(Integer.parseInt(inputID));
					
					// �л� ��ü�� ���ٸ� �ٽ� ó������ ���ư�
					if (changeScoreStudent == null) {
						System.out.println("------------------------------------------------------------");
						System.out.println("���� �й��Դϴ�. �ٽ� �Է����ּ���.");
						System.out.println("------------------------------------------------------------");
						continue;
					}

					System.out.println("------------------------------------------------------------");
					System.out.println(String.format("%-7s%-15s%-5s%-5s%-3s%-10s", "���� �ڵ�", "�����", "����",
							"��米��", "����", "���� ����"));
					System.out.println("------------------------------------------------------------");

					// ������ �� �ִ� �������� ��� ���
					for (int i = 0; i < changeScoreStudent.score.size(); i++) {
						System.out.println(changeScoreStudent.score.get(i).getScoreWithoutID());
					}

					System.out.println("------------------------------------------------------------");
					System.out.println("������ ������ �����ڵ带 �Է����ּ���. (ó������ ���ư���(n))");
					System.out.println("------------------------------------------------------------");
					String inuputCode = scanner.nextLine();
					if (inuputCode.equals("n")) {
						break;
					} else {
						// ã�� �л� ��ü�� ���� ArrayList���� �Է��� ���� �ڵ尡 �ִ� ���� ��ü�� ã��
						Score scoreUpdate = null;
						for (int i = 0; i < changeScoreStudent.score.size(); i++) {
							if (inuputCode.equals(String.valueOf(changeScoreStudent.score.get(i).subject_code))) {
								scoreUpdate = changeScoreStudent.score.get(i);
								break;
							}
						}

						// �Է� ���� �����ڵ带 ã�� ���� ���
						if (scoreUpdate == null) {
							System.out.println("------------------------------------------------------------");
							System.out.println("���� �����ڵ��Դϴ�. �ٽ� �Է����ּ���.");
							System.out.println("------------------------------------------------------------");
							continue;
						}
						
						// ���� �ڵ带 ã�� ��� ���� ���� ����
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "���� �ڵ�", "�����", "����",
								"��米��", "����", "���� ����"));
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
							System.out
									.println("----------------------------------------------------------------------");
							System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������",
									"�����̸�", "����", "����", "�������"));
							System.out.println(scoreUpdate.toString());
							System.out.println("�����Ǿ����ϴ�.");
							System.out
									.println("----------------------------------------------------------------------");

							input = scanner.nextLine();

						}
					}

				}

			} catch (NumberFormatException e) {
				// �й��� �Է� ���� ��, ���ڿ��� ��� ���� ó��
				System.out.println("���ڸ� �Է����ּ���. �й��� 8�ڸ� �����Դϴ�.");
			}
		}

	}

}
