package student;

import java.util.Scanner;

public class Menu {


	  // 메인 화면 출력 메소드
	   void selectMenu() {
	      // 1. 학생 등록 2. 학생 정보 조회 3. 학생 정보 수정 4. 성적 관리 5. 종료
	      System.out.println("*학생 관리 프로그램입니다.");

	      Scanner scanner = new Scanner(System.in);

	      while (true) {
	         System.out.println("========================================================");
	         System.out.println("원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
	         System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
	         System.out.println("========================================================");
	         int MainMenuNum = Integer.parseInt(scanner.nextLine());

	         if (MainMenuNum == 1) {
	            // 학생 등록 메소드 호출
	            break;
	         } else if (MainMenuNum == 2) {
	            // 학생 정보 조회 메소드 호출
	            break;
	         } else if (MainMenuNum == 3) {
	            // 학생 정보 수정 메소드 호출
	            break;
	         } else if (MainMenuNum == 4) {
	            GradeManagement.gradeMenu();
	            break;
	         } else if (MainMenuNum == 5) {
	            System.out.println("========================================================");
	            System.out.println("프로그램을 종료하시겠습니까?");
	            System.out.println("예(y 입력)/아니오(n 입력)");
	            System.out.println("========================================================");

	            String exitAnswer = scanner.nextLine();
	            if (exitAnswer.equals("y")) {
	               System.out.println("========================================================");
	               System.out.println("프로그램이 종료되었습니다.");
	               scanner.close();
	               // FileManager.saveStudentFile();
	               // FileManager.saveScoreFile();
	               break;
	            } else {
	               continue;
	            }
	         } else {
	            System.out.println("다시 입력해주세요.");
	            System.out.println("========================================================");
	            System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
	            System.out.println("========================================================");
	            MainMenuNum = Integer.parseInt(scanner.nextLine());
	         }
	      }
	   }


}
