package student;


import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int number;
	
	public static void main(String[] args) throws IOException {
		
		// ���� �ҷ�����
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
			System.out.println("����Ǿ����ϴ�.");
			break;
		}
		else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
			System.out.println("�ٽ��Է����ּ���.");
			continue;
		}
		
	}
	}

}
