package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Score> scoreArray = new ArrayList<>();

	public static void loadStudentFile() {
		// �л� ���� ���ϵ��� �ҷ��ͼ� ���θ��� Student ��ü ����
		// studentArray�� �߰�
		try {
			//FileReader�� BufferedReader�� StudentData ���� �о����
			BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
			String line = null;
			
			//���κ��� �о�ͼ� studentInfo��  �� �������� split
			while ((line = reader.readLine()) != null) {
				String[] studentInfo = line.split("\t");
				
				//student��ü ������ �Ķ���Ͱ����� ���� studentInfo�� studentArray�� �߰�
				Student student = new Student(studentInfo);
				studentArray.add(student);
			}
			//reader�ݱ�
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void addStudent(Student std) {
		// studentArray�� std �л��� �߰��ϰ�
		studentArray.add(std);
	}

	public static void saveStudentFile(ArrayList<Student> studentInfo) {
		//���α׷� ������ studentArray�� �����Ѵ�
		studentArray.addAll(studentInfo);
	}

	
	public static void loadScoreFile(){
		// ���� ������ �ҷ��ͼ� ���θ��� Score��ü ����
		// scoreArray�� �߰�
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
		

		/*
		 ���� ����� �����Ͻ� ��, ��Ȳ�� �°� �������ּ���
		 public static void delStudent(Student std) {
		 
		 }
		*/
	}
}

