package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Subject> timetableArray = new ArrayList<>();
	
	
	public static void loadStudentFile() {
		// �л� ���� ���ϵ��� �ҷ��ͼ� ���θ��� Student ��ü ����
		// studentArray�� �߰�
		studentArray.add(new Student("20211560	1	������	�����а�	010-2238-0548	����".split("\t")));
		studentArray.add(new Student("20210513	1	������	��ȸ�����а�	010-5483-1578	����".split("\t")));
		studentArray.add(new Student("20210123	1	�Ѱ���	�濵�а�	010-0311-1556	����".split("\t")));
		studentArray.add(new Student("20210864	1	������	��ǻ�Ͱ��а�	010-9566-5844	����".split("\t")));
		studentArray.add(new Student("20210708	1	Ȳ�ÿ�	������а�	010-1541-1366	����".split("\t")));
		studentArray.add(new Student("20190835	3	Ȳ��ä	��ǻ�Ͱ��а�	010-7225-0775	����".split("\t")));
	}
	
	public static void loadTimetableFile() {
		// �ð�ǥ ������ �ҷ��ͼ� ���θ��� Timetable ��ü ����
		// timetableArray�� �߰�
		
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
}
