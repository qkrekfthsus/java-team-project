package student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// ���� �ҷ�����
		FileManager.loadStudentFile();
		FileManager.loadScoreFile();
		// ���� ȭ�� ���
		// 1. �л� ��� 2. �л� ���� ��ȸ 3. �л� ���� ���� 4. ���� ���� 5. ����
		System.out.println("*�л� ���� ���α׷��Դϴ�.");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
				System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
				System.out.println("------------------------------------------------------------");

				int MainMenuNum = Integer.parseInt(scanner.nextLine());

				if (MainMenuNum == 1) {
					StudentManagement.registerStudent(scanner);
				} else if (MainMenuNum == 2) {
					StudentManagement.searchStudent(scanner);
				} else if (MainMenuNum == 3) {
					StudentManagement.changeStudent(scanner);
				} else if (MainMenuNum == 4) {
					ScoreManagement.scoreMenu(scanner);
				} else if (MainMenuNum == 5) {

					System.out.println("------------------------------------------------------------");
					System.out.println("���α׷��� �����Ͻðڽ��ϱ�?");
					System.out.println("��(y �Է�)/�ƴϿ�(n �Է�)");
					System.out.println("------------------------------------------------------------");
					String exitAnswer = scanner.nextLine();
					if (exitAnswer.equals("y")) {
						System.out.println("------------------------------------------------------------");
						System.out.println("���α׷��� ����Ǿ����ϴ�.");
						scanner.close();
						break;
					} else {
						continue;
					}

				} else {
					System.out.println("���� �߸� �Է��ϼ̽��ϴ�. 1~5 ������ ���ڸ� �Է����ּ���.");
				}
			} catch (NumberFormatException e) {
				System.out.println("���� �߸� �Է��ϼ̽��ϴ�. 1~5 ������ ���ڸ� �Է����ּ���.");
			}
		}

		FileManager.saveFiles();

	}

}
