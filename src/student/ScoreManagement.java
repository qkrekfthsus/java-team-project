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
			System.out.println("������ ������ �л��� �й��� �Է����ּ���. (�ڷε��ư���(n))");
			System.out.println("====================================================");
			String IDinput = scanner.nextLine();
			if(IDinput.equals("n")) {
				StudentManagement.gradeManagement();
			}
			
			else {
				//Score updateScore = Score.getScoreID(Integer.parseInt(IDinput));
				if(Score.getScoreFromID(Integer.parseInt(IDinput)).equals(null)) {
					System.out.println("====================================================");
					System.out.println("���� �й��Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println("====================================================");
					continue;
				}
			}
			System.out.println("====================================================");
			System.out.println("������ ������ �����ڵ带 �Է����ּ���. (�ڷε��ư���(n))");
			System.out.println("====================================================");
			String Code = scanner.nextLine();
			if(Code.equals("n")) {
				StudentManagement.gradeManagement();
			}
			else {
				
				if(Score.getScoreFromID(Code).equals(null)) {
					System.out.println("====================================================");
					System.out.println("���� �����ڵ��Դϴ�. �ٽ� �Է����ּ���.");
					System.out.println("====================================================");
					continue;
				}

			}
			Score updateScore = Score.getScoreFromID(Integer.parseInt(IDinput),Code);
			GradeChange(updateScore);	
			input = scanner.nextLine();
			if(input.equals("y")) {
				System.out.println("====================================================");
				System.out.println("������ ������ �Է����ּ���.");
				System.out.println("====================================================");
				input = scanner.nextLine();
				Change(input,updateScore);
				Print(updateScore);
				System.out.println("====================================================");
				System.out.println("��������� �Է����ּ���");
				System.out.println("====================================================");
				input = scanner.nextLine();
				Reason(input,updateScore);
				Print(updateScore);
			}
		}
	}
	
	public static void GradeChange(Score updateScore) {
		System.out.println("====================================================");
		System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
		System.out.println(updateScore.toString());
		System.out.println("������ �����Ͻðڽ��ϱ�?(y/n)");
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
		System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
		System.out.println(updateScore.toString());
		System.out.println("====================================================");
	}
	
}

