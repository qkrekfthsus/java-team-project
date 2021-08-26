package student;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		FileManager.loadStudentFile();
		FileManager.loadTimetableFile();
		
		Menu menu = new Menu();
		menu.selectMenu();
		
	}

}