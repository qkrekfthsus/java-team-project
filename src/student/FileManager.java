package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Subject> timetableArray = new ArrayList<>();
	
	
	public static void loadStudentFile() {
		// 학생 정보 파일들을 불러와서 라인마다 Student 객체 생성
		// studentArray에 추가
		studentArray.add(new Student("20211560	1	김재은	지리학과	010-2238-0548	재학".split("\t")));
		studentArray.add(new Student("20210513	1	서혜린	사회복지학과	010-5483-1578	휴학".split("\t")));
		studentArray.add(new Student("20210123	1	한가희	경영학과	010-0311-1556	재학".split("\t")));
		studentArray.add(new Student("20210864	1	이은유	컴퓨터공학과	010-9566-5844	재학".split("\t")));
		studentArray.add(new Student("20210708	1	황시우	국어국문학과	010-1541-1366	재학".split("\t")));
		studentArray.add(new Student("20190835	3	황은채	컴퓨터공학과	010-7225-0775	휴학".split("\t")));
	}
	
	public static void loadTimetableFile() {
		// 시간표 파일을 불러와서 라인마다 Timetable 객체 생성
		// timetableArray에 추가
		
	}
	
	/* 파일 입출력 진행하실 때, 상황에 맞게 수정해주세요
	public static void addStudent(Student std) {
		// studentArray에 std 학생을 추가하고
		
	}
	
	public static void delStudent(Student std) {
		
	}
	
	public static void saveStudentFile(ArrayList<Student> studentInfo) {
		// 
	}
	*/
}
