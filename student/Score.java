package student;

public class Score {
	int student_id;
	String subject_code, subject_name, professor, type, score, reason;

	// scoreInfo : 성적을 받은 학생의 학번, 과목 코드, 과목명, 담당 교수, 이수 구분, 성적, 변동 사유 가 담긴 String 배열
	public Score(String[] scoreInfo) {
		this.student_id = Integer.parseInt(scoreInfo[0]);
		this.subject_code = scoreInfo[1];
		this.subject_name = scoreInfo[2];
		this.professor = scoreInfo[3];
		this.type = scoreInfo[4];
		this.score = scoreInfo[5];
		this.reason = scoreInfo[6];
	}

	// 탭으로 구분된 toString(파일 불러오기 및 저장)
	public String toTabbedString() {
		String[] toArray = new String[] { String.valueOf(this.student_id), this.subject_code, this.subject_name,
				this.professor, this.type, this.score, this.reason };
		return String.join("\t", toArray);
	}

	// 출력을 위한 toString(성적 조회)
	@Override
	public String toString() {
		return String.format("%-11d%-8s%-15s%-5s%-5s%-3s%-10s", student_id, subject_code, subject_name, type, professor,
				score, reason);
	}

	// 출력을 위한 toString2(성적 수정)
	public String getScoreWithoutID() {
		return String.format("%-8s%-15s%-5s%-5s%-3s%-10s", subject_code, subject_name, type, professor,
				score, reason);
	}


}
