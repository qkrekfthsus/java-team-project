package student;


public class Main {

	public static void main(String[] args) {
		
		// ���� �ҷ�����
		FileManager.loadStudentFile();
		FileManager.loadTimetableFile();
		
		Menu menu = new Menu();
		menu.selectMenu();
		
		
	}

}
