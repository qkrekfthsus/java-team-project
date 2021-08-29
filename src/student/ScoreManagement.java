package student;

import java.util.Scanner;

public class ScoreManagement {

	// �л� ���� ���� �޴�
	public static void scoreMenu(Scanner scanner) {

		while (true) {
			try {
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
					changeScore(scanner);
				} else if (scoreMenuNum == 4) {
					break;
				} else {
					System.out.println("�ٽ� �Է����ּ���.");
				}
			} catch (NumberFormatException e) {
				System.out.println("���� �߸� �Է��ϼ̽��ϴ�. 1~4 ������ ���ڸ� �Է����ּ���.");
			}
		}

	}

	// �л� ���� ���
	public static void registerScore(Scanner scanner) {

		String[] studentScoreInfo = new String[7];

		boolean restart = true;
		while (restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("������ �Է��� �л��� �й��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());
				Student student = Student.getStudentFromID(student_id);
				
				// �Էµ� �й��� �л��� �����ϴ� ��� 
				if (student != null) {

					System.out.println("------------------------------------------------------------");
					System.out.println("������ �Է��� ���� �ڵ带 �Է����ּ���.");
					System.out.println("------------------------------------------------------------");

					String code = scanner.nextLine();
					Subject subject = Subject.getFromcode(code);
					
					// �Էµ� �����ڵ尡 ���� ��Ͽ� �����ϴ� ���
					if (subject != null) {
						boolean alreadyin = false;
						//String alreadyin = "";
						
						for (Score inScore : student.score) {
							if(inScore.subject_code.equals(code)) {
								alreadyin = true;
								break;
							}
							//alreadyin += inScore.toString();
						}
						
						if (alreadyin) {
							System.out.println(subject.toString() + " ������ �̹� �ԷµǾ� �־� ���� �޴��� ���ư��ϴ�.");
							break;
						} else {
							System.out.println("------------------------------------------------------------");
							System.out.println(subject.toString() + " ������ ������ �Է����ּ���.");
							System.out.println("------------------------------------------------------------");
							String getscore = scanner.nextLine();
							
							while(true) {
								if (InformationVerify.isScore(getscore)) {
									String[] subinfo = subject.toString().split(" ");
									studentScoreInfo[0] = Integer.toString(student_id);
									for (int i = 1; i < subinfo.length + 1; i++) {
										studentScoreInfo[i] = subinfo[i - 1];
									}
									studentScoreInfo[5] = getscore;
									studentScoreInfo[6] = "����";
									break;
								}
								else {
									System.out.println("���� ������ ���� �ʽ��ϴ�. ������ �ٽ� �Է����ּ���.(�Է� ���� �׸� : A, B, C, F)");
									getscore = scanner.nextLine();
								}
							}
							

							for (int i = 0; i < studentScoreInfo.length - 1; i++) {
								System.out.print(studentScoreInfo[i] + " ");
							}

							System.out.println();
							System.out.println("------------------------------------------------------------");
							System.out.println("�ش� ������ �Է��Ͻðڽ��ϱ�? (y/n)");
							System.out.println("------------------------------------------------------------");

							String Q = scanner.nextLine();
							if (Q.equals("y")) {
								Score updatescore = new Score(studentScoreInfo);
								student.score.add(updatescore);
								System.out.println("������ ���������� �ԷµǾ����ϴ�.");
							} else {
								System.out.println("�����Է��� ��ҵǾ� ó������ ���Է��մϴ�.");
								continue;
							}

						}

					} else {
						System.out.println("�ش� �����ڵ�� �������� �ʽ��ϴ�. Ȯ�� �� �ٽ� �Է����ּ���.");
					}
				} else {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.");
				}

				System.out.println("------------------------------------------------------------");
				System.out.println("���� ����� ��� �Ͻðڽ��ϱ�?(y/n)");
				System.out.println("------------------------------------------------------------");

				restart = scanner.nextLine().equals("y") ? true : false;
			} catch (NumberFormatException e) {
				System.out.println("�й��� Ȯ���� �ٽ� �Է����ּ���.");
			}
		}

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
						System.out.println(String.format("%-7s%-15s%-5s%-5s%-3s%-10s", "���� �ڵ�", "�����", "����",
								"��米��", "����", "���� ����"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentToRead.score) {
							System.out.println(grade.getScoreWithoutID());

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
					System.out.println(
							String.format("%-7s%-15s%-5s%-5s%-3s%-10s", "���� �ڵ�", "�����", "����", "��米��", "����", "���� ����"));
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
							
							while(true) {
								if(InformationVerify.isScore(input)) {
									scoreUpdate.score = input;
									break;
								}
								else {
									System.out.println("���� ������ ���� �ʽ��ϴ�. ������ �ٽ� �Է����ּ���.(�Է� ���� �׸� : A, B, C, F)");
									input = scanner.nextLine();
								}
							}
							
							System.out.println("------------------------------------------------------------");
							System.out.println("��������� �Է����ּ���");
							System.out.println("------------------------------------------------------------");

							input = scanner.nextLine();
							scoreUpdate.reason = input;
							System.out
									.println("----------------------------------------------------------------------");
							System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "�й�", "���� �ڵ�", "�����",
									"����", "��米��", "����", "���� ����"));
							System.out.println(scoreUpdate.toString());
							System.out.println("�����Ǿ����ϴ�.");
							System.out
									.println("----------------------------------------------------------------------");

							System.out.println("------------------------------------------------------------");
							System.out.println("������ �߰��� �����Ͻðڽ��ϱ�?(y/n)");
							System.out.println("------------------------------------------------------------");

							input = scanner.nextLine();
							if (!input.equals("y")) {
								break;
							}

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
