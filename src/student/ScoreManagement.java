package student;

import java.util.Scanner;

public class ScoreManagement {

	   public static void scoreMenu(Scanner scanner) {		  
		  //Scanner menuScanner = new Scanner(System.in);
		  System.out.println("*성적 관리 기능입니다.");
	      while (true) {
	         System.out.println("========================================================");
	         System.out.println("원하는 기능을 선택해주세요.( 1~4 번호를 입력해주세요.)");
	         System.out.println("1.성적 입력  2.성적 조회  3.성적 수정   4.이전메뉴");
	         System.out.println("========================================================");
	         int scoreMenuNum = Integer.parseInt(scanner.nextLine());
	         if (scoreMenuNum == 1) {
	        	 registerScore();
	            break;
	         } else if (scoreMenuNum == 2) {
	        	 readScore();
	            break;
	         } else if (scoreMenuNum == 3) {
	        	 changeScore();
	            break;
	         } else if (scoreMenuNum == 4) {
	            break;
	         } else {
	            System.out.println("다시 입력해주세요.");
	         }
	      }
	   }

	   public static void registerScore() {}
		
		public static void readScore() {}
		
		public static void changeScore() {}
	}

