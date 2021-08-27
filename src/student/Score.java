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
	
	 public Score(String[] scoreInfo) {
	      this.student_id = Integer.parseInt(scoreInfo[0]);
	      this.subject_code = scoreInfo[1];
	      this.subject_name = scoreInfo[2];
	      this.professor = scoreInfo[3];
	      this.type = scoreInfo[4];
	      this.score = scoreInfo[5];
	      this.reason = scoreInfo[6];
	   }
	
	public String toTabbedString() {
	      String[] toArray = new String[] { String.valueOf(this.student_id), this.subject_code, this.subject_name,
	            this.professor, this.type, this.score, this.reason };
	      return String.join("\t", toArray);
	   }
	// 201xxxxx/과목명/과목 코드/담당 교수/요일/교시
}
