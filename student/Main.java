package student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 파일 불러오기
		FileManager.loadStudentFile();
		FileManager.loadScoreFile();
		
		// 메인 화면 출력
		System.out.println("*학생 관리 프로그램입니다.");

		Scanner scanner = new Scanner(System.in);
		

		// 프로그램이 종료될 때 까지 메뉴 반복
		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
				System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
				System.out.println("------------------------------------------------------------");

				int MainMenuNum = Integer.parseInt(scanner.nextLine());

				// 메뉴 선택
				if (MainMenuNum == 1) {
					StudentManagement.registerStudent(scanner);
				} else if (MainMenuNum == 2) {
					StudentManagement.searchStudent(scanner);
				} else if (MainMenuNum == 3) {
					StudentManagement.changeStudent(scanner);
				} else if (MainMenuNum == 4) {
					ScoreManagement.scoreMenu(scanner);
				} else if (MainMenuNum == 5) {
					// 프로그램 종료
					System.out.println("------------------------------------------------------------");
					System.out.println("프로그램을 종료하시겠습니까?");
					System.out.println("예(y 입력)/아니오(n 입력)");
					System.out.println("------------------------------------------------------------");
					String exitAnswer = scanner.nextLine();
					
					if (exitAnswer.equals("y")) {
						System.out.println("------------------------------------------------------------");
						System.out.println("프로그램이 종료되었습니다.");
						scanner.close();
						break;
					} else {
						continue;
					}

				} else {
					// 잘못된 숫자를 입력 받았을 때
					System.out.println("값을 잘못 입력하셨습니다. 1~5 사이의 숫자를 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				// 메뉴 선택 시, 숫자가 아닌 문자열을 입력 받았을 때 예외 처리
				System.out.println("값을 잘못 입력하셨습니다. 1~5 사이의 숫자를 입력해주세요.");
			}
		}
		
		// 프로그램 종료 시 파일 저장
		FileManager.saveFiles();

	}

}