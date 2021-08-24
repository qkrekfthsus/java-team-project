package student;


public class Main {

	public static void main(String[] args) {
		
		// 파일 불러오기
		FileManager.loadStudentFile();
		FileManager.loadTimetableFile();
		
		Menu menu = new Menu();
		menu.selectMenu();
		
		
	}

}
