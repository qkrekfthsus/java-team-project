package student;

import java.util.Scanner;

public class GradeManagement {
	  // 성적 관리 화면 메소드
	   public static void gradeMenu() {

	      Scanner scanner = new Scanner(System.in);

	      while (true) {
	         System.out.println("*성적 관리 기능입니다.");
	         System.out.println("========================================================");
	         System.out.println("원하는 기능을 선택해주세요.( 1~4 번호를 입력해주세요. )");
	         System.out.println("1.성적 입력  2.성적 조회  3.성적 수정   4.이전메뉴");
	         System.out.println("========================================================");
	         int ScoreMenuNum = Integer.parseInt(scanner.nextLine());

	         if (ScoreMenuNum == 1) {
	            // 성적 입력 메소드 호출
	            break;
	         } else if (ScoreMenuNum == 2) {
	            // 성적 조회 메소드 호출
	            break;
	         } else if (ScoreMenuNum == 3) {
	            // 성적 수정 메소드 호출
	            break;
	         } else if (ScoreMenuNum == 4) {
	            Menu menu = new Menu();
	            menu.selectMenu();
	            scanner.close();
	            break;
	         } else {
	            System.out.println("다시 입력해주세요.");
	            System.out.println("========================================================");
	            System.out.println("1.성적 입력  2.성적 조회  3.성적 수정   4.이전메뉴");
	            System.out.println("========================================================");
	            ScoreMenuNum = Integer.parseInt(scanner.nextLine());
	         }
	      }
	   }


}
