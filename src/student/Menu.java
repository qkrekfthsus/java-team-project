package student;

import java.util.Scanner;

public class Menu {


	void selectMenu() {
		// 메인 화면 출력
		// 1. 학생 등록 2. 학생 정보 조회 3. 학생 정보 수정 4. 성적 관리 5. 종료
		System.out.println("*학생 관리 프로그램입니다.");
		System.out.println("========================================================");
		System.out.println("원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
		System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
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
				
				System.out.println("*성적 관리 기능입니다.");
				System.out.println("========================================================");
				System.out.println("원하는 기능을 선택해주세요.( 1~4 번호를 입력해주세요. )");
				System.out.println("1.성적 입력  2.성적 조회  3.성적 수정  4.이전 메뉴");
				System.out.println("========================================================");
				int subjectNum = Integer.parseInt(scanner.nextLine());
					if(subjectNum == 1) {
						System.out.println(1);
						//성적 입력 메소드 호출
						break;
					}else if(subjectNum == 2) {
						System.out.println(2);
						//성적 조회 메소드 호출
						break;
					}else if(subjectNum == 3) {
						System.out.println(3);
						//성적 수정 메소드 호출
						break;
					}else if(subjectNum == 4) {
						System.out.println("*학생 관리 프로그램입니다.");
						System.out.println("========================================================");
						System.out.println("원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
						System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
						System.out.println("========================================================");
						mainMenuNum = Integer.parseInt(scanner.nextLine());
					}else {
						System.out.println("다시 입력해주세요.");
						System.out.println("========================================================");
						System.out.println("1.성적 입력  2.성적 조회  3.성적 수정");
						System.out.println("========================================================");
						subjectNum = Integer.parseInt(scanner.nextLine());
						break;
					}
					
			}else if(mainMenuNum == 5) {
				System.out.println("========================================================");
				System.out.println("프로그램을 종료하시겠습니까?");
				System.out.println("예(y 입력)/아니오(n 입력)");
				System.out.println("========================================================");
				String exitAnswer = scanner.nextLine();
				if(exitAnswer.equals("y")) {
					System.out.println("========================================================");
					System.out.println("프로그램이 종료되었습니다.");
					scanner.close();
				}else {
					System.out.println("*학생 관리 프로그램입니다.");
					System.out.println("========================================================");
					System.out.println("원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
					System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
					System.out.println("========================================================");
					mainMenuNum = Integer.parseInt(scanner.nextLine());
				}
				
				break;
			}else {
				System.out.println("다시 입력해주세요.");
				System.out.println("========================================================");
				System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
				System.out.println("========================================================");
				mainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}

}
