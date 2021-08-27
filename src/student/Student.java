package student;

import java.util.ArrayList;

public class Student {
	int student_id, student_grade;
	String student_name, student_major, student_tel, student_state;
	
	// 해당 학생의 수강한 성적 정보가 담긴 ArrayList
	ArrayList<Score> score = new ArrayList<>();

	// studentInfo : 학생의 학번, 학년, 이름, 학과, 전화번호, 학적상태 가 담긴 String 배열
	public Student(String[] studentInfo) {
		this.student_id = Integer.parseInt(studentInfo[0]);
		this.student_grade = Integer.parseInt(studentInfo[1]);
		this.student_name = studentInfo[2];
		this.student_major = studentInfo[3];
		this.student_tel = studentInfo[4];
		this.student_state = studentInfo[5];
	}

	// 학번을 통해 전체 Student ArrayList에서 해당 학번을 가진 Student 객체를 리턴하는 메소드
	public static Student getStudentFromID(int student_id) {
		for (Student student : FileManager.studentArray) {
			if (student.student_id == student_id) {
				return student;
			}
		}
		return null;
	}
	
	// 전화번호를 통해 전체 Student ArrayList에서 해당 전화번호를 가진 Student 객체를 리턴하는 메소드
	public static Student getStudentFromTel(String student_tel) {
		for (Student student : FileManager.studentArray) {
			if (student.student_tel.equals(student_tel)) {
				return student;
			}
		}
		return null;
	}

	// 탭으로 구분된 toString(파일 불러오기 및 저장)
	public String toTabbedString() {
		String[] toArray = new String[] { String.valueOf(this.student_id), String.valueOf(this.student_grade),
				this.student_name, this.student_major, this.student_tel, this.student_state };
		return String.join("\t", toArray);
	}

	// 출력을 위한 toString(학생 조회)
	@Override
	public String toString() {
		return String.format("%-11d%-5d%-5s%-9s%-17s%-10s", student_id, student_grade, student_name, student_major,
				student_tel, student_state);
	}

	// 파일을 불러올 때, 해당 학생의 성적들을 score 객체 변수에 추가하는 메소드
	public static void loadScore(Score score) {
		for (Student std : FileManager.studentArray) {

			if (std.student_id == score.student_id) {
				std.score.add(score);
			}
		}
	}
	
}
