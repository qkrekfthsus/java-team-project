package student;

public class Subject {
	int student_id;
	String subject_code, subject_name, type, professor, grade, reason;
	
	public Subject(int student_id, String subject_code, String subject_name, String type, String professor,
			String grade, String reason) {
		this.student_id = student_id;
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.type = type;
		this.professor = professor;
		this.grade = grade;
		this.reason = reason;
	}
	
	public Subject(String[] subjectInfo) {
		this.type = subjectInfo[0];
		this.subject_code = subjectInfo[1];
		this.subject_name = subjectInfo[2];
		this.professor = subjectInfo[3];
		this.grade = subjectInfo[4];
		this.reason = subjectInfo[5];
	}
	
	// 201xxxxx/과목 코드/과목명/담당 교수/성적/성적 변동 사유
}
