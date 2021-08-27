package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<Student> studentArray = new ArrayList<>();

	public static boolean loadStudentFile() {
		// 학생 정보 파일들을 불러와서 라인마다 Student 객체 생성
		// studentArray에 추가
		try {
			System.out.println("학생 정보 파일을 불러오는 중입니다.");
			// FileReader와 BufferedReader로 StudentData 파일 읽어오기
			BufferedReader reader = new BufferedReader(new FileReader("StudentData.txt"));
			String line = null;

			// 라인별로 읽어와서 studentInfo에 탭 기준으로 split
			while ((line = reader.readLine()) != null) {
				String[] studentInfo = line.split("\t");

				// student객체 생성후 파라미터값으로 받은 studentInfo를 studentArray에 추가
				Student student = new Student(studentInfo);
				studentArray.add(student);
			}
			// reader닫기
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
		try {
			System.out.println("성적 정보 파일을 불러오는 중입니다.");

			BufferedReader reader = new BufferedReader(new FileReader("ScoreData.txt"));
			String line = null;

			// 라인별로 읽어와서 studentInfo에 탭 기준으로 split
			while ((line = reader.readLine()) != null) {
				String[] scoreInfo = line.split("\t");

				Score score = new Score(scoreInfo);

				for (Student student : studentArray) {
					if (student.student_id == score.student_id) {
						student.score.add(score);
					}
				}
			}
			reader.close();
			System.out.println("성적 정보 파일을 불러오는데 성공했습니다.");
		} catch (Exception e) {
			System.out.println("학생 정보 파일을 불러오는데 실패했습니다.");

			e.printStackTrace();
		}

	}

	public static void saveFiles() {

	}

}
