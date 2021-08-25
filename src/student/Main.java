package student;


public class Main {

	public static void main(String[] args) {
		
		// 파일 불러오기
		FileManager.loadStudentFile();
		FileManager.loadGradeFile();
		
		Menu menu = new Menu();
		menu.selectMenu();
		
		
	}

}
