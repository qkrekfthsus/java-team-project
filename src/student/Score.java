package student;

public class Score {
	int student_id;
	String subject_code, subject_name, type, professor, score, reason;
	
	public Score(int student_id, String subject_code, String subject_name, String type, String professor,
			String score, String reason) {
		this.student_id = student_id;
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.type = type;
		this.professor = professor;
		this.score = score;
		this.reason = reason;
	}
	
	
	
	
	// 201xxxxx/과목명/과목 코드/담당 교수/요일/교시
}
