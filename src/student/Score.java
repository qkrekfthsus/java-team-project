package student;

public class Score {
	int student_id;
	String subject_code, subject_name, type, professor, grade , comment;
	
	public Score(String[] ScoreInfo) {
		this.student_id = Integer.parseInt(ScoreInfo[0]);
		this.subject_code = ScoreInfo[1];
		this.subject_name = ScoreInfo[2];
		this.type = ScoreInfo[3];
		this.professor = ScoreInfo[4];
		this.grade = ScoreInfo[5];
		this.comment = ScoreInfo[6];
	}
	
	public static Score getScoreFromID(int student_id) {
	      for(Score score : FileManager.timetableArray) {
	         if(score.student_id == student_id) {
	            return score;
	         }
	      }
	      return null;
	   }
	
	
	
	// 201xxxxx/과목명/과목 코드/담당 교수/요일/교시
}
