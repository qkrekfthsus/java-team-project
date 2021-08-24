package student;


import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int number;
	
	public static void main(String[] args) throws IOException {
		
		// 파일 불러오기
		//FileManager.loadStudentFile();
		//FileManager.loadTimetableFile();
		Scanner scanner = new Scanner(System.in);
		while(true) {
		
		Menu.selectMenu();
		number = Integer.parseInt(scanner.nextLine()); 
		if(number==1) {
			StudentManagement.registerStudent();
		}
		else if(number==2) {
			StudentManagement.searchStudent();
		}
		else if(number==3) {
			StudentManagement.changeStudent();
		}
		else if(number==4) {
			
		}
	
		else if(number==5) {
			System.out.println("종료되었습니다.");
			break;
		}
		else {
			System.out.println("잘못입력하셨습니다.");
			System.out.println("다시입력해주세요.");
			continue;
		}
		
	}
	}

}
