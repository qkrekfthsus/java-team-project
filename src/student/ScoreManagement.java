package student;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManagement {
	static Scanner scanner = new Scanner(System.in);
	static String input;
	
	public static void ChangeScore(){
		ArrayList<Score> timetableArray = new ArrayList<>();
		timetableArray.addAll(FileManager.timetableArray);
		
		for(Score a : timetableArray) {
			System.out.println(a);
		}
		while(true) {
			
			System.out.println("====================================================");
			System.out.println("������ ������ �л��� �й��� �Է����ּ���. (�ڷε��ư���(n))");
			System.out.println("====================================================");
			input = scanner.nextLine();
			Score updateScore = Score.getScoreFromID(Integer.parseInt(input));
			
			
		}
		
		
		
		
	}
}
