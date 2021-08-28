package student;

public class Score {
	int student_id;
	String subject_code, subject_name, professor, type, score, reason;

	// scoreInfo : ������ ���� �л��� �й�, ���� �ڵ�, �����, ��� ����, �̼� ����, ����, ���� ���� �� ��� String �迭
	public Score(String[] scoreInfo) {
		this.student_id = Integer.parseInt(scoreInfo[0]);
		this.subject_code = scoreInfo[1];
		this.subject_name = scoreInfo[2];
		this.professor = scoreInfo[3];
		this.type = scoreInfo[4];
		this.score = scoreInfo[5];
		this.reason = scoreInfo[6];
	}

	// ������ ���е� toString(���� �ҷ����� �� ����)
	public String toTabbedString() {
		String[] toArray = new String[] { String.valueOf(this.student_id), this.subject_code, this.subject_name,
				this.professor, this.type, this.score, this.reason };
		return String.join("\t", toArray);
	}

	// ����� ���� toString(���� ��ȸ)
	@Override
	public String toString() {
		return String.format("%-11d%-8s%-15s%-5s%-5s%-3s%-10s", student_id, subject_code, subject_name, type, professor,
				score, reason);
	}

	// ����� ���� toString2(���� ����)
	public String getScoreWithoutID() {
		return String.format("%-8s%-15s%-5s%-5s%-3s%-10s", subject_code, subject_name, type, professor,
				score, reason);
	}


}
