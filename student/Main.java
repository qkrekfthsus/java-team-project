package student;


public class Main {

	public static void main(String[] args) {
		
		// ���� �ҷ�����
		FileManager.loadStudentFile();
		FileManager.loadScoreFile();
		
		Menu.selectMenu();
		//StudentManagement.registerStudent();
	}

}
