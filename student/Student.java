package student;

import java.util.ArrayList;

public class Student {
	int student_id, student_grade;
	String student_name, student_major, student_tel, student_state;
	
	// �ش� �л��� ������ ���� ������ ��� ArrayList
	ArrayList<Score> score = new ArrayList<>();

	// studentInfo : �л��� �й�, �г�, �̸�, �а�, ��ȭ��ȣ, �������� �� ��� String �迭
	public Student(String[] studentInfo) {
		this.student_id = Integer.parseInt(studentInfo[0]);
		this.student_grade = Integer.parseInt(studentInfo[1]);
		this.student_name = studentInfo[2];
		this.student_major = studentInfo[3];
		this.student_tel = studentInfo[4];
		this.student_state = studentInfo[5];
	}

	// �й��� ���� ��ü Student ArrayList���� �ش� �й��� ���� Student ��ü�� �����ϴ� �޼ҵ�
	public static Student getStudentFromID(int student_id) {
		for (Student student : FileManager.studentArray) {
			if (student.student_id == student_id) {
				return student;
			}
		}
		return null;
	}
	
	// ��ȭ��ȣ�� ���� ��ü Student ArrayList���� �ش� ��ȭ��ȣ�� ���� Student ��ü�� �����ϴ� �޼ҵ�
	public static Student getStudentFromTel(String student_tel) {
		for (Student student : FileManager.studentArray) {
			if (student.student_tel.equals(student_tel)) {
				return student;
			}
		}
		return null;
	}

	// ������ ���е� toString(���� �ҷ����� �� ����)
	public String toTabbedString() {
		String[] toArray = new String[] { String.valueOf(this.student_id), String.valueOf(this.student_grade),
				this.student_name, this.student_major, this.student_tel, this.student_state };
		return String.join("\t", toArray);
	}

	// ����� ���� toString(�л� ��ȸ)
	@Override
	public String toString() {
		return String.format("%-11d%-5d%-5s%-9s%-17s%-10s", student_id, student_grade, student_name, student_major,
				student_tel, student_state);
	}

	// ������ �ҷ��� ��, �ش� �л��� �������� score ��ü ������ �߰��ϴ� �޼ҵ�
	public static void loadScore(Score score) {
		for (Student std : FileManager.studentArray) {

			if (std.student_id == score.student_id) {
				std.score.add(score);
			}
		}
	}
	
}
