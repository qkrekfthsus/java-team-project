package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Grade> gradeArray = new ArrayList<>();
	
	
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
	
	public static void loadGradeFile() {
		// �ð�ǥ ������ �ҷ��ͼ� ���θ��� Timetable ��ü ����
		// timetableArray�� �߰�
		
		score();
	}
	
	/* ���� ����� �����Ͻ� ��, ��Ȳ�� �°� �������ּ���
	public static void addStudent(Student std) {
		// studentArray�� std �л��� �߰��ϰ�
		
	}
	
	public static void delStudent(Student std) {
		
	}
	
	public static void saveStudentFile(ArrayList<Student> studentInfo) {
		// 
	}
	*/
	public static void score() {
		for(Student std : studentArray) {
			ArrayList<Grade> gdArray = new ArrayList<>();
			for(Grade gd : gradeArray) {
				if(std.student_id == gd.student_id) {
					gdArray.add(gd);
				}
			}
			std.grade = gdArray;
		}
	}
}
