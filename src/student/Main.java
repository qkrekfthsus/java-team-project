package student;


public class Main {

	public static void main(String[] args) {
		
		// ���� �ҷ�����
		FileManager.loadStudentFile();
		FileManager.loadGradeFile();
		
		Menu menu = new Menu();
		menu.selectMenu();
		
		
	}

}
