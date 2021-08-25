package student;

public class Student {
	int student_id, student_grade;
	String student_name, student_major, student_tel, student_state;
	
	
	public Student(String[] studentInfo) {
		this.student_id = Integer.parseInt(studentInfo[0]);
		this.student_grade = Integer.parseInt(studentInfo[1]);
		this.student_name = studentInfo[2];
		this.student_major = studentInfo[3];
		this.student_tel = studentInfo[4];
		this.student_state = studentInfo[5];
	}
	
	public static Student getStudentFromID(int student_id) {
	      for(Student student : FileManager.studentArray) {
	         if(student.student_id == student_id) {
	            return student;
	         }
	      }
	      return null;
	   }
	
	@Override
	public String toString() {
		return String.format("%-11d%-5d%-5s%-9s%-17s%-10s", student_id, student_grade, student_name, student_major, student_tel, student_state);
	}
	// 20170815/4/�ֹ���/��/��ǻ�Ͱ��а�/010-0456-4692/����
}
