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
	//�й��� �����ڵ� �˻�
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
	
	// 201xxxxx/�����/���� �ڵ�/��� ����/����/����
}
