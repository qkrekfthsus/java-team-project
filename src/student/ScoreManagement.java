package student;

import java.util.Scanner;

public class ScoreManagement {
	
	public static void scoreMenu() {
		Scanner scanner = new Scanner(System.in);

		int MainMenuNum = 0;

		while(true) {
			System.out.println("========================================================");
			System.out.println("sfjsdfsdfsdkjf원하는 기능을 선택해주세요.( 1~5 번호를 입력해주세요. )");
			System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
			System.out.println("========================================================");
			MainMenuNum = Integer.parseInt(scanner.nextLine());

			if(MainMenuNum == 1) {
				StudentManagement.registerStudent();
				break;
			}else if(MainMenuNum == 2){
				StudentManagement.searchStudent(scanner);
				break;
			}else if(MainMenuNum == 3){
				StudentManagement.changeStudent(scanner);
				break;
			}else if(MainMenuNum == 4) {
				
				break;
			}else if(MainMenuNum == 5) {
				// System.out.println("프로그램이 종료되었습니다.");
				// 종료하시겠습니까?(y/n)
				// FileManager.saveStudentFile();
				// FileManager.saveScoreFile();
				break;
			}else {
				System.out.println("다시 입력해주세요.");
				System.out.println("----------------------------------------------------------------------");
				System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
				System.out.println("----------------------------------------------------------------------");
				MainMenuNum = Integer.parseInt(scanner.nextLine());
			}
		}
	}
	
	public static void registerScore() {}
	
	public static void readScore() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("성적을 조회할 학생의 학번을 입력해주세요.");
		System.out.println("----------------------------------------------------------------------");
		
		int student_id = Integer.parseInt(scanner.nextLine());
		
		Student readForStudent = Student.getStudentFromID(student_id);
		
		if(readForStudent != null) {
			if(!readForStudent.score.isEmpty()) {
				for(Score grade : readForStudent.score) {
					System.out.println("----------------------------------------------------------------------");
					System.out.println();
					System.out.println("----------------------------------------------------------------------");
					
				}
			}
			else {
				System.out.println("조회할 성적이 없습니다.");
			}
		}
		else {
			System.out.println("해당 학생이 존재하지 않습니다.");
		}
		
	}
	
	public static void changeScore() {}
	
}
