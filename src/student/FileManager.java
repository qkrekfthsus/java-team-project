package student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Subject> timetableArray = new ArrayList<>();

	public static void loadStudentFile() throws IOException {
		// �л� ���� ���ϵ��� �ҷ��ͼ� ���θ��� Student ��ü ����
		// studentArray�� �߰�
		BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] studentInfo = line.split("\t");
			Student student = new Student(studentInfo);
			studentArray.add(student);
		}
		reader.close();
	}

	public static void addStudent(Student std) {
		// studentArray�� std �л��� �߰��ϰ�
		//studentArray.add(std);
	}

	public static void saveStudentFile(ArrayList<Student> studentInfo) {
		//���α׷� ������ studentArray�� �����Ѵ�
		//studentArray.addAll(studentInfo);
	}

	public static void loadTimetableFile() throws IOException {
		// �ð�ǥ ������ �ҷ��ͼ� ���θ��� Timetable ��ü ����
		// timetableArray�� �߰�
		File SubjectData = new File("SubjectData.txt");
		BufferedReader reader = new BufferedReader(new FileReader(SubjectData));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] SubjectInfo = line.split("\t");
			Subject subject = new Subject(SubjectInfo);
			timetableArray.add(subject);
		}
		reader.close();
		
		

		/*
		 ���� ����� �����Ͻ� ��, ��Ȳ�� �°� �������ּ���
		 public static void delStudent(Student std) {
		 
		 }
		*/
	}
}
