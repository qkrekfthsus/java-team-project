package student;

import java.util.Scanner;

public class Menu {


	  // ���� ȭ�� ��� �޼ҵ�
	   void selectMenu() {
	      // 1. �л� ��� 2. �л� ���� ��ȸ 3. �л� ���� ���� 4. ���� ���� 5. ����
	      System.out.println("*�л� ���� ���α׷��Դϴ�.");

	      Scanner scanner = new Scanner(System.in);

	      while (true) {
	         System.out.println("========================================================");
	         System.out.println("���ϴ� ����� �������ּ���.( 1~5 ��ȣ�� �Է����ּ���. )");
	         System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
	         System.out.println("========================================================");
	         int MainMenuNum = Integer.parseInt(scanner.nextLine());

	         if (MainMenuNum == 1) {
	            // �л� ��� �޼ҵ� ȣ��
	            break;
	         } else if (MainMenuNum == 2) {
	            // �л� ���� ��ȸ �޼ҵ� ȣ��
	            break;
	         } else if (MainMenuNum == 3) {
	            // �л� ���� ���� �޼ҵ� ȣ��
	            break;
	         } else if (MainMenuNum == 4) {
	            GradeManagement.gradeMenu();
	            break;
	         } else if (MainMenuNum == 5) {
	            System.out.println("========================================================");
	            System.out.println("���α׷��� �����Ͻðڽ��ϱ�?");
	            System.out.println("��(y �Է�)/�ƴϿ�(n �Է�)");
	            System.out.println("========================================================");

	            String exitAnswer = scanner.nextLine();
	            if (exitAnswer.equals("y")) {
	               System.out.println("========================================================");
	               System.out.println("���α׷��� ����Ǿ����ϴ�.");
	               scanner.close();
	               // FileManager.saveStudentFile();
	               // FileManager.saveScoreFile();
	               break;
	            } else {
	               continue;
	            }
	         } else {
	            System.out.println("�ٽ� �Է����ּ���.");
	            System.out.println("========================================================");
	            System.out.println("1.�л� ���  2.�л� ���� ��ȸ  3.�л� ���� ���� 4.���� ����  5.����");
	            System.out.println("========================================================");
	            MainMenuNum = Integer.parseInt(scanner.nextLine());
	         }
	      }
	   }


}
