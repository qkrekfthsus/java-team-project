package student;

import java.util.Scanner;

public class Menu {


	static void selectMenu() {
		// ���� ȭ�� ���
		// 1. �л� ��� 2. �л� ���� ��ȸ 3. �л� ���� ���� 4. ���� ���� 5. ����
		System.out.println("*�л� ���� ���α׷��Դϴ�.");
		System.out.println("========================================================");
		System.out.println("���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
		System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ����  4.���� ����  5.����");
		System.out.println("========================================================");

		Scanner scanner = new Scanner(System.in);
		int MainMenuNum = Integer.parseInt(scanner.nextLine());

		while(true) {
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
				//StudentManagement.gradeManagement();
				break;
			}else if(MainMenuNum == 5) {
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				scanner.close();
				break;
			}else {
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.println("========================================================");
				System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ����  4.���� ����  5.����");
				System.out.println("========================================================");
				MainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}

}
