package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Subject> subjectArray = new ArrayList<>();
	// StudentData.txt �ҷ�����
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

	// ScoreData.txt �ҷ�����
	public static void loadScoreFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ScoreData.txt"));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] scoreInfo = line.split("\t");
				Score score = new Score(scoreInfo);
				Subject subject = new Subject(scoreInfo[1], scoreInfo[2], scoreInfo[3], scoreInfo[4]);
				
				if(subjectArray.isEmpty()) {
					subjectArray.add(subject);
				}
				else {
					boolean subjectInclude = false;
					for(int i = 0; i < subjectArray.size(); i++) {
						subjectInclude = Subject.compare(subjectArray.get(i), subject);
						if(subjectInclude) {
							break;
						}
					}
					if(!subjectInclude) {
						subjectArray.add(subject);
					}
				}
				
				// Student ��ü ���� ���� ArrayList�� ������ �߰�
				Student.loadScore(score);
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ���α׷��� ����� �� ���� �����ϱ�
	public static void saveFiles() {
		try {
			// StudentData
			FileWriter saveStd = new FileWriter("StudentData.txt", false);
			BufferedWriter bwStd = new BufferedWriter(saveStd);
			
			// ScoreData
			FileWriter saveScore = new FileWriter("ScoreData.txt", false);
			BufferedWriter bwScore = new BufferedWriter(saveScore);

			for (int i = 0; i < studentArray.size(); i++) {
				// �л� ���� ���� ����
				bwStd.write(studentArray.get(i).toTabbedString());
				bwStd.newLine();

				// ���� ���� ���� ����
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