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
		File myFile = new File("strudent.txt");
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
		System.out.println("���������� ������ �л��� �й��� �Է����ּ���.");
		System.out.println("====================================================");
		number = scanner.nextLine();
		for(int i=0; i<n; i++){
			if(number.equals(Student[i].student_id)) {
			System.out.println("====================================================");
			System.out.println(Student[0].student_id+"	 "+Student[0].student_grade+" 	"+Student[0].student_name+" 	"+Student[0].student_major+"	 "+Student[0].student_tel+"		"+Student[0].student_state);
			System.out.println(Student[i].student_id+" "+Student[i].student_grade+" 	"+Student[i].student_name+" 	"+Student[i].student_major+" "+Student[i].student_tel+"	 "+Student[i].student_state);
			System.out.println("���� ������ ���� �Ͻðڽ��ϱ�?(y/n)");
			System.out.println("====================================================");
			savepoint = i;
			}
		}
		number = scanner.nextLine();
		
		if(number.equals("y")) {
		System.out.println("====================================================");
		System.out.println("������ �׸��� �Է����ּ���.");
		System.out.println("====================================================");
		number = scanner.nextLine();
			if(number.equals(Student[0].student_id)) {
				System.out.println("�й��� �����Ҽ� �����ϴ�");
				
			}
			if(number.equals(Student[0].student_grade)) {
				System.out.println("������ "+Student[0].student_grade+"�� �Է����ּ���. �����г��� " +Student[savepoint].student_grade+"�Դϴ�.");
				number = scanner.nextLine();
				Student[savepoint].student_grade = number;
				//System.out.println(System.out.println(Student[savepoint].student_id+" "+Student[savepoint].student_grade+" 	"+Student[savepoint].student_name+" 	"+Student[savepoint].student_major+" "+Student[savepoint].student_tel+"	 "+Student[savepoint].student_state);
				
			}
			if(number.equals(Student[0].student_name)) {
				
			}
			if(number.equals(Student[0].student_major)) {
				
			}
			if(number.equals(Student[0].student_tel)) {
	
			}
			if(number.equals(Student[0].student_state)) {
	
			}
			else {
				System.out.println("�ٽ��Է����ּ���");
				continue;
			}
			
			
		}
		if(number=="n") {
			break;
		}
		
		else {
			System.out.println("�ٽ��Է����ּ���.");
			continue;
		}
			
		}
	}
	
	public static void gradeManagement() {
		
	}
}
