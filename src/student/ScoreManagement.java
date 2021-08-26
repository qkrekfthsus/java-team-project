package student;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManagement {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	
	public static void ChangeScore(){
		ArrayList<Score> timetableArray = new ArrayList<>();
		timetableArray.addAll(FileManager.timetableArray);
	
		while(true) {
			System.out.println("====================================================");
			System.out.println("성적을 수정할 학생의 학번을 입력해주세요. (뒤로돌아가기(n))");
			System.out.println("====================================================");
			String IDinput = scanner.nextLine();
			if(IDinput.equals("n")) {
				StudentManagement.gradeManagement();
			}
			
			else {
				//Score updateScore = Score.getScoreID(Integer.parseInt(IDinput));
				if(Score.getScoreFromID(Integer.parseInt(IDinput)).equals(null)) {
					System.out.println("====================================================");
					System.out.println("없는 학번입니다. 다시 입력해주세요.");
					System.out.println("====================================================");
					continue;
				}
			}
			System.out.println("====================================================");
			System.out.println("성적을 수정할 과목코드를 입력해주세요. (뒤로돌아가기(n))");
			System.out.println("====================================================");
			String Code = scanner.nextLine();
			if(Code.equals("n")) {
				StudentManagement.gradeManagement();
			}
			else {
				
				if(Score.getScoreFromID(Code).equals(null)) {
					System.out.println("====================================================");
					System.out.println("없는 과목코드입니다. 다시 입력해주세요.");
					System.out.println("====================================================");
					continue;
				}

			}
			Score updateScore = Score.getScoreFromID(Integer.parseInt(IDinput),Code);
			GradeChange(updateScore);	
			input = scanner.nextLine();
			if(input.equals("y")) {
				System.out.println("====================================================");
				System.out.println("변경할 성적을 입력해주세요.");
				System.out.println("====================================================");
				input = scanner.nextLine();
				Change(input,updateScore);
				Print(updateScore);
				System.out.println("====================================================");
				System.out.println("변경사유를 입력해주세요");
				System.out.println("====================================================");
				input = scanner.nextLine();
				Reason(input,updateScore);
				Print(updateScore);
			}
		}
	}
	
	public static void GradeChange(Score updateScore) {
		System.out.println("====================================================");
		System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
		System.out.println(updateScore.toString());
		System.out.println("성적을 변경하시겠습니까?(y/n)");
		System.out.println("====================================================");
	}
	public static void Change(String input,Score updateScore) {
		updateScore.grade = input;
	}
	public static void Reason(String input,Score updateScore) {
		updateScore.reason = input;
	}
	public static void Print(Score updateScore) {
		System.out.println("====================================================");
		System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
		System.out.println(updateScore.toString());
		System.out.println("====================================================");
	}
	
}

