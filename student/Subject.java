package student;

public class Subject {
	String subject_code, subject_name, professor, type;

	public Subject(String subject_code, String subject_name, String professor, String type) {
		this.subject_code = subject_code;
		this.subject_name = subject_name;
		this.professor = professor;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s", subject_code, subject_name, professor, type);
	}

	public static boolean compare(Subject a, Subject b) {
		if(a.subject_code.equals(b.subject_code)) {
			return true;
		}
		return false;
	}
	

}
