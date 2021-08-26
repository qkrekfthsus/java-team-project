package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Score> scoreArray = new ArrayList<>();
	
	
	public static boolean loadStudentFile() {
		// �л� ���� ���ϵ��� �ҷ��ͼ� ���θ��� Student ��ü ����
		// studentArray�� �߰�
		try {
			System.out.println("�л� ���� ������ �ҷ����� ���Դϴ�.");
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
			System.out.println("�л� ���� ������ �ҷ����µ� �����߽��ϴ�.");
			
			return true;
		} catch (Exception e) {
			System.out.println("�л� ���� ������ �ҷ����µ� �����Ͽ����ϴ�.");
			e.printStackTrace();
			
			return false;
		}
	}
	
	public static void loadScoreFile() {
		// ���� ���� �ҷ��� ��, scoreArray�� �߰�
		Student std = Student.getStudentFromID(20170505);
		std.score.add(new Score(new String[] {"20170505", "C051", "��ȸ����������", "������", "����", "A", "����"}));
		std.score.add(new Score(new String[] {"20170505", "C051", "��������������", "������", "����", "A", "����"}));
		std.score.add(new Score(new String[] {"20170505", "C051", "��������������", "������", "����", "A", "����"}));
		std.score.add(new Score(new String[] {"20170505", "C051", "��������������", "������", "����", "A", "����"}));
		

	}
	
	public static void saveStudentFile() {
		//���α׷� ������ studentArray�� �����Ѵ�
		
	}
	public static void saveScoreFile() {
		
	}
	
	
}
