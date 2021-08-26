package student;

public class Score {
	int student_id;
	String subject_code, subject_name, type, professor, grade , reason;
	
	public Score(String[] ScoreInfo) {
		this.student_id = Integer.parseInt(ScoreInfo[0]);
		this.subject_code = ScoreInfo[1];
		this.subject_name = ScoreInfo[2];
		this.type = ScoreInfo[3];
		this.professor = ScoreInfo[4];
		this.grade = ScoreInfo[5];
		this.reason = ScoreInfo[6];
	}
	//학번과 과목코드 검색
	public static Score getScoreFromID(int student_id,String Code) {
	      for(Score score : FileManager.timetableArray) {
	         if((score.student_id == student_id) && (score.subject_code.equals(Code))) {
	        	
	            return score;
	         }        
	      }
	      return null;
	   }
	
	public static Score getScoreFromID(int student_id) {
		for(Score score : FileManager.timetableArray) {
	         if(score.student_id == student_id) {
	        	return score;
	         }        
	      }
	      return null;
	}
	
	public static Score getScoreFromID(String Code) {
		for(Score score : FileManager.timetableArray) {
	         if(score.subject_code.equals(Code)) {
	        	return score;
	         }        
	      }
	      return null;
	}
	@Override
	public String toString() {
		return String.format("%-11d%-10s%-10s%-9s%-5s%-5s%-5s", student_id, subject_code, subject_name, type, professor, grade , reason);
	}
	
	// 201xxxxx/과목명/과목 코드/담당 교수/요일/교시
}
