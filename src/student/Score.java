package student;

public class Score {
	int student_id;
	String subject_code, subject_name, type, professor, grade, reason;
	
	public Score(int student_id, String subject_code, String subject_name, String type, String professor,
			String grade, String reason) {
		this.student_id = student_id;
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.type = type;
		this.professor = professor;
		this.grade = grade;
		this.reason = reason;
	}
	
	public Score(String[] subjectInfo) {
		this.type = subjectInfo[0];
		this.subject_code = subjectInfo[1];
		this.subject_name = subjectInfo[2];
		this.professor = subjectInfo[3];
		this.grade = subjectInfo[4];
		this.reason = subjectInfo[5];
	}
	
	// 201xxxxx/과목명/과목 코드/담당 교수/요일/교시
}
