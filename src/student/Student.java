package student;

import java.util.ArrayList;

public class Student {
	int student_id, student_grade;
	String student_name, student_major, student_tel, student_state;
	ArrayList<Score> score = new ArrayList<>();
	
	public Student(String[] studentInfo) {
		this.student_id = Integer.parseInt(studentInfo[0]);
		this.student_grade = Integer.parseInt(studentInfo[1]);
		this.student_name = studentInfo[2];
		this.student_major = studentInfo[3];
		this.student_tel = studentInfo[4];
		this.student_state = studentInfo[5];
	}
	
	public static Student getStudentFromID(int student_id) {
		for(Student student : FileManager.studentArray) {
			if(student.student_id == student_id) {
				return student;
			}
		}
		return null;
	}
	
	public String[] toArray() {
		return new String[] {String.valueOf(this.student_id), String.valueOf(this.student_grade), this.student_name,
				this.student_major, this.student_tel, this.student_state};
	}
	@Override
	public String toString() {
		return String.format("%-11d%-5d%-5s%-9s%-17s%-10s", student_id, student_grade, student_name, student_major, student_tel, student_state);
	}
	
	public static void loadStudentScore() {
		for(Student std : FileManager.studentArray) {
			ArrayList<Score> scArray = new ArrayList<>();
			for(Score gd : FileManager.scoreArray) {
				if(std.student_id == gd.student_id) {
					scArray.add(gd);
				}
			}
			std.score = scArray;
		}
	}
	
	// 20170815/4/최무열/남/컴퓨터공학과/010-0456-4692/졸업
}
