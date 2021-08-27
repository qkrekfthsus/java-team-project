package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();

	// StudentData.txt 불러오기
	public static void loadStudentFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] studentInfo = line.split("\t");
				Student student = new Student(studentInfo);
				studentArray.add(student);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ScoreData.txt 불러오기
	public static void loadScoreFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ScoreData.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] scoreInfo = line.split("\t");
				Score score = new Score(scoreInfo);
				Student.loadScore(score);

			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 프로그램이 종료될 때 파일 저장하기
	public static void saveFiles() {
		try {
			// StudentData 저장
			FileWriter saveStd = new FileWriter("StudentData.txt", false);
			BufferedWriter bwStd = new BufferedWriter(saveStd);

			FileWriter saveScore = new FileWriter("ScoreData.txt", false);
			BufferedWriter bwScore = new BufferedWriter(saveScore);

			for (int i = 0; i < studentArray.size(); i++) {
				bwStd.write(studentArray.get(i).toTabbedString());
				bwStd.newLine();
				// ScoreData 저장
				ArrayList<Score> score = studentArray.get(i).score;
				if (!score.isEmpty()) {
					for (int j = 0; j < score.size(); j++) {
						bwScore.write(score.get(j).toTabbedString());
						bwScore.newLine();
					}
				}

			}
			bwStd.close();
			bwScore.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}




















