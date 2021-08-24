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
		// 학생 정보 파일들을 불러와서 라인마다 Student 객체 생성
		// studentArray에 추가
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
		// studentArray에 std 학생을 추가하고
		//studentArray.add(std);
	}

	public static void saveStudentFile(ArrayList<Student> studentInfo) {
		//프로그램 종료후 studentArray를 저장한다
		//studentArray.addAll(studentInfo);
	}

	public static void loadTimetableFile() throws IOException {
		// 시간표 파일을 불러와서 라인마다 Timetable 객체 생성
		// timetableArray에 추가
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
		 파일 입출력 진행하실 때, 상황에 맞게 수정해주세요
		 public static void delStudent(Student std) {
		 
		 }
		*/
	}
}
