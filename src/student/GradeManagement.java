package student;

import java.util.Scanner;

public class GradeManagement {
	  // ���� ���� ȭ�� �޼ҵ�
	   public static void gradeMenu() {

	      Scanner scanner = new Scanner(System.in);

	      while (true) {
	         System.out.println("*���� ���� ����Դϴ�.");
	         System.out.println("========================================================");
	         System.out.println("���ϴ� ����� �������ּ���.( 1~4 ��ȣ�� �Է����ּ���. )");
	         System.out.println("1.���� �Է�  2.���� ��ȸ  3.���� ����   4.�����޴�");
	         System.out.println("========================================================");
	         int ScoreMenuNum = Integer.parseInt(scanner.nextLine());

	         if (ScoreMenuNum == 1) {
	            // ���� �Է� �޼ҵ� ȣ��
	            break;
	         } else if (ScoreMenuNum == 2) {
	            // ���� ��ȸ �޼ҵ� ȣ��
	            break;
	         } else if (ScoreMenuNum == 3) {
	            // ���� ���� �޼ҵ� ȣ��
	            break;
	         } else if (ScoreMenuNum == 4) {
	            Menu menu = new Menu();
	            menu.selectMenu();
	            scanner.close();
	            break;
	         } else {
	            System.out.println("�ٽ� �Է����ּ���.");
	            System.out.println("========================================================");
	            System.out.println("1.���� �Է�  2.���� ��ȸ  3.���� ����   4.�����޴�");
	            System.out.println("========================================================");
	            ScoreMenuNum = Integer.parseInt(scanner.nextLine());
	         }
	      }
	   }


}
