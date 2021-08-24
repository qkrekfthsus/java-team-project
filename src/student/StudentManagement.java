package student;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
	static Scanner scanner = new Scanner(System.in);
	static String number;
	
	static int savepoint;
	
	public static void registerStudent() {
		
	}
	
	public static void searchStudent() {
		
	}
	
	public static void changeStudent() throws IOException {
		File myFile = new File("studentData.txt");
		BufferedReader reader = new BufferedReader(new FileReader(myFile));
		
		String line =null;
		int n=0;
		ArrayList list=new ArrayList();
		
		  while((line=reader.readLine()) != null ){
		   n++;
		   list.add(line);
		  }
		  reader.close();
		  
		  Student[] Student=new Student[n];
		  
		  for(int i=0; i<n; i++){
		   String tok=(String)list.get(i);
		   String[] token=tok.split("\t");
		   Student[i]=new Student(token[0],token[1], token[2], token[3], token[4], token[5]);
		 
		  }
		while(true) {
		System.out.println("====================================================");
		System.out.println("인적사항을 변경할 학생의 학번을 입력해주세요.");
		System.out.println("====================================================");
		number = scanner.nextLine();
		
		for(int i=0; i<n; i++){
			if(number.equals(Student[i].student_id)) {
			System.out.println("====================================================");
			System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
			System.out.println(Student[i].student_id+" "+Student[i].student_grade+" 	"+Student[i].student_name+" 	"+Student[i].student_major+" "+Student[i].student_tel+"	 "+Student[i].student_state);
			System.out.println("인적 사항을 변경 하시겠습니까?(y/n)");
			System.out.println("====================================================");
			savepoint = i;
			}
			
			
		}
		number = scanner.nextLine();
		
		if(number.equals("y")) {
		System.out.println("====================================================");
		System.out.println("변경할 항목을 입력해주세요.");
		System.out.println("====================================================");
		number = scanner.nextLine();
			if(number.equals(Student[0].student_id)) {
				System.out.println("====================================================");
				System.out.println("학번은 변경할수 없습니다");
				
			}
			if(number.equals(Student[0].student_grade)) {
				System.out.println("====================================================");
				System.out.println("변경할 "+Student[0].student_grade+"을 입력해주세요. 현재학년은 " +Student[savepoint].student_grade+"입니다.");
				System.out.println("====================================================");
				number = scanner.nextLine();
				Student[savepoint].student_grade = number;
				System.out.println("====================================================");
				System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
				System.out.println(Student[savepoint].student_id+" "+Student[savepoint].student_grade+" 	"+Student[savepoint].student_name+" 	"+Student[savepoint].student_major+" "+Student[savepoint].student_tel+"	 "+Student[savepoint].student_state);
				System.out.println("변경되었습니다.");
				System.out.println("====================================================");
				break;
			}
			if(number.equals(Student[0].student_name)) {
				System.out.println("====================================================");
				System.out.println("변경할 "+Student[0].student_name+"을 입력해주세요. 현재이름은 " +Student[savepoint].student_name+"입니다.");
				System.out.println("====================================================");
				number = scanner.nextLine();
				Student[savepoint].student_name = number;
				System.out.println("====================================================");
				System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
				System.out.println(Student[savepoint].student_id+" "+Student[savepoint].student_grade+" 	"+Student[savepoint].student_name+" 	"+Student[savepoint].student_major+" "+Student[savepoint].student_tel+"	 "+Student[savepoint].student_state);
				System.out.println("변경되었습니다.");
				System.out.println("====================================================");
				break;
			}
			if(number.equals(Student[0].student_major)) {
				System.out.println("====================================================");
				System.out.println("변경할 "+Student[0].student_major+"을 입력해주세요. 현재학과는 " +Student[savepoint].student_major+"입니다.");
				System.out.println("====================================================");
				number = scanner.nextLine();
				Student[savepoint].student_major = number;
				System.out.println("====================================================");
				System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
				System.out.println(Student[savepoint].student_id+" "+Student[savepoint].student_grade+" 	"+Student[savepoint].student_name+" 	"+Student[savepoint].student_major+" "+Student[savepoint].student_tel+"	 "+Student[savepoint].student_state);
				System.out.println("변경되었습니다.");
				System.out.println("====================================================");
				break;
			}
			if(number.equals(Student[0].student_tel)) {
				System.out.println("====================================================");
				System.out.println("변경할 "+Student[0].student_tel+"을 입력해주세요. 현재전화번호는 " +Student[savepoint].student_tel+"입니다.");
				System.out.println("====================================================");
				number = scanner.nextLine();
				Student[savepoint].student_tel = number;
				System.out.println("====================================================");
				System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
				System.out.println(Student[savepoint].student_id+" "+Student[savepoint].student_grade+" 	"+Student[savepoint].student_name+" 	"+Student[savepoint].student_major+" "+Student[savepoint].student_tel+"	 "+Student[savepoint].student_state);
				System.out.println("변경되었습니다.");
				System.out.println("====================================================");
				break;
			}
			if(number.equals(Student[0].student_state)) {
				System.out.println("====================================================");
				System.out.println("변경할 "+Student[0].student_state+"을 입력해주세요. 현재학년은 " +Student[savepoint].student_state+"입니다.");
				System.out.println("====================================================");
				number = scanner.nextLine();
				Student[savepoint].student_state = number;
				System.out.println("====================================================");
				System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
				System.out.println(Student[savepoint].student_id+" "+Student[savepoint].student_grade+" 	"+Student[savepoint].student_name+" 	"+Student[savepoint].student_major+" "+Student[savepoint].student_tel+"	 "+Student[savepoint].student_state);
				System.out.println("변경되었습니다.");
				System.out.println("====================================================");
				break;
			}
			else {
				
				System.out.println("다시입력해주세요");
				System.out.println("====================================================");
				continue;
			}
			
			
		}
		if(number=="n") {
			break;
		}
		
		else {
			System.out.println("다시입력해주세요.");
			continue;
		}
			
		}
	}
	
	public static void gradeManagement() {
		
	}
}
