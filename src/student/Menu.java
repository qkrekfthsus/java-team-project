package student;

import java.util.Scanner;

public class Menu {


	void selectMenu() {
		// ���� ȭ�� ���
		// 1. �л� ��� 2. �л� ���� ��ȸ 3. �л� ���� ���� 4. ���� ���� 5. ����
		System.out.println("*�л� ���� ���α׷��Դϴ�.");
		System.out.println("========================================================");
		System.out.println("���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
		System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
		System.out.println("========================================================");

		Scanner scanner = new Scanner(System.in);
		int mainMenuNum = Integer.parseInt(scanner.nextLine());

		while(true) {
			if(mainMenuNum == 1) {
				StudentManagement.registerStudent();
				break;
			}else if(mainMenuNum == 2){
				StudentManagement.searchStudent();
				break;
			}else if(mainMenuNum == 3){
				StudentManagement.changeStudent();
				break;
			}else if(mainMenuNum == 4) {
				
				System.out.println("*���� ���� ����Դϴ�.");
				System.out.println("========================================================");
				System.out.println("���ϴ� ����� �������ּ���.( 1~4 ��ȣ�� �Է����ּ���. )");
				System.out.println("1.���� �Է�  2.���� ��ȸ  3.���� ����  4.���� �޴�");
				System.out.println("========================================================");
				int subjectNum = Integer.parseInt(scanner.nextLine());
					if(subjectNum == 1) {
						System.out.println(1);
						//���� �Է� �޼ҵ� ȣ��
						break;
					}else if(subjectNum == 2) {
						System.out.println(2);
						//���� ��ȸ �޼ҵ� ȣ��
						break;
					}else if(subjectNum == 3) {
						System.out.println(3);
						//���� ���� �޼ҵ� ȣ��
						break;
					}else if(subjectNum == 4) {
						System.out.println("*�л� ���� ���α׷��Դϴ�.");
						System.out.println("========================================================");
						System.out.println("���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
						System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
						System.out.println("========================================================");
						mainMenuNum = Integer.parseInt(scanner.nextLine());
					}else {
						System.out.println("�ٽ� �Է����ּ���.");
						System.out.println("========================================================");
						System.out.println("1.���� �Է�  2.���� ��ȸ  3.���� ����");
						System.out.println("========================================================");
						subjectNum = Integer.parseInt(scanner.nextLine());
						break;
					}
					
			}else if(mainMenuNum == 5) {
				System.out.println("========================================================");
				System.out.println("���α׷��� �����Ͻðڽ��ϱ�?");
				System.out.println("��(y �Է�)/�ƴϿ�(n �Է�)");
				System.out.println("========================================================");
				String exitAnswer = scanner.nextLine();
				if(exitAnswer.equals("y")) {
					System.out.println("========================================================");
					System.out.println("���α׷��� ����Ǿ����ϴ�.");
					scanner.close();
				}else {
					System.out.println("*�л� ���� ���α׷��Դϴ�.");
					System.out.println("========================================================");
					System.out.println("���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
					System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
					System.out.println("========================================================");
					mainMenuNum = Integer.parseInt(scanner.nextLine());
				}
				
				break;
			}else {
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.println("========================================================");
				System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
				System.out.println("========================================================");
				mainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}

}
