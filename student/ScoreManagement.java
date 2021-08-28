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

	@SuppressWarnings("unused")
	public static void registerScore(Scanner scanner) {

		String[] studentScoreInfo = new String[7];

		boolean restart = true;
		while (restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ �Է��� �л��� �й��� �Է����ּ���.");

				int student_id = Integer.parseInt(scanner.nextLine());
				Student student = Student.getStudentFromID(student_id);

				if (student != null) {

					System.out.println("------------------------------------------------------------");
					System.out.println("������ �Է��� ���� �ڵ带 �Է����ּ���.");
					String code = scanner.nextLine();
					Subject subject = Subject.getFromcode(code);
					
					if (subject != null) {
						
						String alreadyin = "";
						for (Score inScore : student.score) {
							alreadyin += inScore.toString();
						}
						if (alreadyin.contains(code) == true) {
							System.out.println(subject.toString()+" ������ �̹� �ԷµǾ� �־� ���� �޴��� ���ư��ϴ�.");
							break;
						} else {
							System.out.println(subject.toString()+" ������ ������ �Է����ּ���.");
							String getscore = scanner.nextLine();

							String[] subinfo = subject.toString().split(" ");
							studentScoreInfo[0] = Integer.toString(student_id);
							for (int i = 1; i < subinfo.length+1; i++) {
								studentScoreInfo[i] = subinfo[i-1];
							}
							studentScoreInfo[5] = getscore;
							studentScoreInfo[6] = "����";
							
							for (int i = 0; i < studentScoreInfo.length-1; i++) {
								System.out.print(studentScoreInfo[i]+" ");
							}
							System.out.println();
							System.out.println("�ش� ������ �Է��Ͻðڽ��ϱ�? (y/n)");
							String Q = scanner.nextLine();
							if(Q.equals("y")){
								Score updatescore = new Score(studentScoreInfo);
								student.score.add(updatescore);
								System.out.println("������ ���������� �ԷµǾ����ϴ�.");
							}else {
								System.out.println("�����Է��� ��ҵǾ� ó������ ���Է��մϴ�.");
								continue;
							}
							
						}
						
					}else {
						System.out.println("�ش� �����ڵ�� �������� �ʽ��ϴ�. Ȯ�� �� �ٽ� �Է����ּ���.");
					}
				}else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}

				System.out.println("----------------------------------------------------------------------");
				System.out.println("���� ����� ��� �Ͻðڽ��ϱ�?(y/n)");
				System.out.println("----------------------------------------------------------------------");

				restart = scanner.nextLine().equals("y") ? true : false;
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
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "  ���� �ڵ�", "   �����", "  ����",
								"��米��", "����", "��������"));
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
