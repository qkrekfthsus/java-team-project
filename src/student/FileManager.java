package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Score> timetableArray = new ArrayList<>();

	public static void loadStudentFile() {
		// 학생 정보 파일들을 불러와서 라인마다 Student 객체 생성
		// studentArray에 추가
		try {
			//FileReader와 BufferedReader로 StudentData 파일 읽어오기
			BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
			String line = null;
			
			//라인별로 읽어와서 studentInfo에  탭 기준으로 split
			while ((line = reader.readLine()) != null) {
				String[] studentInfo = line.split("\t");
				
				//student객체 생성후 파라미터값으로 받은 studentInfo를 studentArray에 추가
				Student student = new Student(studentInfo);
				studentArray.add(student);
			}
			//reader닫기
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void addStudent(Student std) {
		// studentArray에 std 학생을 추가하고
		studentArray.add(std);
	}

	public static void saveStudentFile(ArrayList<Student> studentInfo) {
		//프로그램 종료후 studentArray를 저장한다
		studentArray.addAll(studentInfo);
	}

	
	public static void loadTimetableFile(){
		// 시간표 파일을 불러와서 라인마다 Timetable 객체 생성
		// timetableArray에 추가
		try {
			BufferedReader reader = new BufferedReader(new FileReader("SubjectData.txt"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] SubjectInfo = line.split("\t");
				//Score subject = new Score(SubjectInfo);
				//timetableArray.add(subject);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		/*
		 파일 입출력 진행하실 때, 상황에 맞게 수정해주세요
		 public static void delStudent(Student std) {
		 
		 }
		*/
	}
}