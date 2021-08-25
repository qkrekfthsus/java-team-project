package student;

import java.util.Scanner;

public class Menu {


	static void selectMenu() {
		// 메인 화면 출력
		// 1. 학생 등록 2. 학생 정보 조회 3. 학생 정보 수정 4. 성적 관리 5. 종료
		System.out.println("*학생 관리 프로그램입니다.");
		System.out.println("========================================================");
		System.out.println("원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
		System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정  4.성적 관리  5.종료");
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
				System.out.println("프로그램이 종료되었습니다.");
				scanner.close();
				break;
			}else {
				System.out.println("다시 입력해주세요.");
				System.out.println("========================================================");
				System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정  4.성적 관리  5.종료");
				System.out.println("========================================================");
				MainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}

}
