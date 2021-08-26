package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Score> scoreArray = new ArrayList<>();
	
	//StudentData.txt 불러오기
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

	//StudentData.txt 저장하기
	public static void saveStudentFile() {
		
		try {
			FileWriter saveStd = new FileWriter("StudentData.txt",false);
			BufferedWriter bwStd = new BufferedWriter(saveStd);
			for (int i = 0; i < studentArray.size(); i++) {
				bwStd.write(studentArray.get(i).toString());
				bwStd.newLine();
			}	
			bwStd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//ScoreData.txt 불러오기
	public static void loadScoreFile(){
		try {		
			BufferedReader reader = new BufferedReader(new FileReader("ScoreData.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] scoreInfo = line.split("\t");
				Score score = new Score(scoreInfo);
				scoreArray.add(score);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//ScoreData.txt 저장하기
	public static void saveScoreFile() {
		try {
			FileWriter saveScore = new FileWriter("test.txt",false);
			BufferedWriter bwScore = new BufferedWriter(saveScore);
			for (int i = 0; i < scoreArray.size(); i++) {
				bwScore.write(scoreArray.get(i).toString());
				bwScore.newLine();
			}
			score();
			bwScore.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void score() {
		for(Student std : studentArray) {
			ArrayList<Score> scArray = new ArrayList<>();
			for(Score sc : scoreArray) {
				if(std.student_id == sc.student_id) {
					scArray.add(sc);
				}
			}
			std.score = scArray;
		}
	}
}
