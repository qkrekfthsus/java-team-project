package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();
	public static ArrayList<Score> scoreArray = new ArrayList<>();
	
	
	public static boolean loadStudentFile() {
		// 학생 정보 파일들을 불러와서 라인마다 Student 객체 생성
		// studentArray에 추가
		try {
			System.out.println("학생 정보 파일을 불러오는 중입니다.");
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
			System.out.println("학생 정보 파일을 불러오는데 성공했습니다.");
			
			return true;
		} catch (Exception e) {
			System.out.println("학생 정보 파일을 불러오는데 실패하였습니다.");
			e.printStackTrace();
			
			return false;
		}
	}
	
	public static void loadScoreFile() {
		// 성적 파일 불러온 뒤, scoreArray에 추가
		Student std = Student.getStudentFromID(20170505);
		std.score.add(new Score(new String[] {"20170505", "C051", "사회복지행정론", "이은아", "전선", "A", "없음"}));
		std.score.add(new Score(new String[] {"20170505", "C051", "ㅇㅇㅇㅇㅇㅇㅇ", "ㄹㄹㄹ", "전선", "A", "없음"}));
		std.score.add(new Score(new String[] {"20170505", "C051", "ㅁㅁㅁㅁㅁㅁㅁ", "ㅎㅎㅎ", "전선", "A", "없음"}));
		std.score.add(new Score(new String[] {"20170505", "C051", "ㅂㅂㅂㅂㅂㅂㅂ", "ㅁㅁㅁ", "전선", "A", "없음"}));
		

	}
	
	public static void saveStudentFile() {
		//프로그램 종료후 studentArray를 저장한다
		
	}
	public static void saveScoreFile() {
		
	}
	
	
}
