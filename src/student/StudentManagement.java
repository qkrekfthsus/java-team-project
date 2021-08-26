package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	static String[] studentInfo = new String[6];
	static Scanner sc = new Scanner(System.in);
	static String[] list = {"�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"};

	// �л� ��� �޼ҵ�
	public static void registerStudent() {
		System.out.println("*���ο� �л� ������ ����մϴ�. (���� �⺻���� �������� ��ϵ�)");
		registerId();
		registerGrade();
		registerName();
		registerMajor();
		registerTel();


	}				

	
	// �й��Է�
	public static void registerId() {
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �й��� �Է����ּ���. (����8�ڸ�)");
		while (true) {
			String id = sc.nextLine();
			if (StudentVerify.isId(id)) {
				studentInfo[0] = id;
				break;
			} else {
				System.out.println("�й��� Ȯ�� �� �ٽ� �Է����ּ���. (����8�ڸ�)");
				continue;
			}
		}

	}

	// �г��Է�
	public static void registerGrade() {
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �г��� �Է����ּ���. (����1�ڸ�)");
		while (true) {
			String grade = sc.nextLine();
			if (StudentVerify.isGrade(grade)) {
				studentInfo[1] = grade;
				break;
			} else {
				System.out.println("�г��� Ȯ�� �� �ٽ� �Է����ּ���. (����1�ڸ�)");
				continue;
			}
		}

	}

	// �̸��Է�
	public static void registerName() {
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �̸��� �Է����ּ���.");
		while (true) {
			String name = sc.nextLine();
			if (StudentVerify.isName(name)) {
				studentInfo[2] = name;
				break;
			} else {
				System.out.println("�̸��� Ȯ�� �� �ٽ� �Է����ּ���.");
				continue;
			}
		}

	}

	// �а��Է�
	public static void registerMajor() {
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �а��� �Է����ּ���. (ex. xx�а�)");
		while (true) {
			String major = sc.nextLine();
			if (StudentVerify.isMajor(major)) {
				studentInfo[3] = major;
				break;
			} else {
				System.out.println("�а��� Ȯ�� �� �ٽ� �Է����ּ���. (ex. xx�а�)");
				continue;
			}
		}

	}

	// ��ȭ��ȣ�Է�
	public static void registerTel() {
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� ��ȭ��ȣ�� �Է����ּ���. (��ȣ�� �Է����ּ���.)");
		while (true) {
			String tel = sc.nextLine();
			if (StudentVerify.isMob(tel)) {
				studentInfo[4] = tel;
				studentInfo[5] = "����";
				while(true) {
					if(infoQ()) {
						break;
					}
				}
				break;
			} else {
				System.out.println("��ȭ��ȣ�� Ȯ�� �� �ٽ� �Է����ּ���. (��ȣ�� �Է����ּ���.)");
				continue;
			}
		}

	}

	// �Է��� ���� �´��� Ȯ��
	public static boolean infoQ() {
		
		for (int i = 0; i < studentInfo.length; i++) {
			System.out.print(studentInfo[i] + " ");
		}
		System.out.println();
		System.out.println("����Ͻ� ������ �½��ϱ�? (y/n)");
		if (sc.nextLine().equals("y")) {
			// Student ��ü �����Ͽ� ArrayList�� �߰�
			Student student = new Student(studentInfo);
			FileManager.studentArray.add(student);
			
			// ���� �۾����� ���� �Լ� ȣ��
			registerQ();
			return true;
		} else {
			System.out.println("���Է��� �׸���� �Է����ּ���.");
			String info = sc.nextLine();
			if (info.equals("�й�")) {
				registerId();
			} else if (info.equals("�г�")) {
				registerGrade();
			} else if (info.equals("�̸�")) {
				registerName();
			} else if (info.equals("�а�")) {
				registerMajor();
			} else if (info.equals("��ȭ��ȣ")) {
				registerTel();
			}
			return false;
		}
	}
	
	// ���� �۾� ���� ���� �Լ�
	public static void registerQ() {

		System.out.println("==============================================");
		System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�. ��� �۾��Ͻðڽ��ϱ�? (y/n)");
		System.out.println("==============================================");

		if (sc.nextLine().equals("y")) {
			// �л� ��� �Լ� ȣ��
			registerStudent();
		} else {
			// ���θ޴��� ���ư���
			System.out.println("�л� ����� �����ϰ� ���� �޴��� ���ư��ϴ�.");
		}

	}	
	
	public static void searchStudent(Scanner scanner) {

		
		boolean resetSearch = true;
		while(resetSearch) {
			System.out.println(" * �л� ���� �˻�");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" �˻��� �л��� ���� ������ ����� �����ؼ� �Է����ּ���.(ex. ��ö�� ��ǻ�Ͱ��а� 1)");
			System.out.println(" ������ �׸񺰷� �ϳ����� �Է°����մϴ�.(�׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
			System.out.println("----------------------------------------------------------------------");
			
			ArrayList<Student> result = new ArrayList<>();
			result.addAll(FileManager.studentArray);
			
			result = getSearchResult(scanner, true, result);
			
			boolean moreSearch = true;
			
			while(moreSearch && result != null) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println(" �� �˻��� �Ͻðڽ��ϱ�?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				moreSearch = scanner.nextLine().equals("y") ? true : false;
				if(!moreSearch) {
					break;
				}
				result = getSearchResult(scanner, false, result);
			}
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" �ٽ� �˻��Ͻðڽ��ϱ�?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			resetSearch = scanner.nextLine().equals("y") ? true : false;

		}
		System.out.println("���� ȭ������ ���ư��ϴ�.");
	}
	
	// �˻� ����� ���
	public static ArrayList<Student> printSearchResult(Scanner scanner, ArrayList<Student> result, ArrayList<Integer> deleteIndex) {
		if(result.size() != deleteIndex.size()) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println(String.format(" %-10s%-5s%-5s%-10s%-15s%-10s ", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
			System.out.println("----------------------------------------------------------------------");
			for (Integer integer : deleteIndex) {
				result.remove((int) integer);
			}
			
			for (Student student : result) {
				System.out.println(student.toString());
			}
			return result;
			
		}
		else {
			System.out.println("�˻��� ����� �����ϴ�.");
			return null;
		}
	}
	
	// �˻� Ű���带 �Է� �ް�, �˻��� ����� ����
	public static ArrayList<Student> getSearchResult(Scanner scanner, boolean isFirst, ArrayList<Student> result) {
		// ó�� �˻�����, �߰� �˻����� Ȯ��
		if(!isFirst) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" �� �˻��� ������ �Է����ּ���.");
			System.out.println("----------------------------------------------------------------------");
		}
		
		
		// �˻��� Ű���� �Է� ����
		String[] searchKeywords = scanner.nextLine().split(" ");
		
		System.out.println(searchKeywords[0].equals("")); // �˻� Ű���� ���� �Է� ���߿� �߰�
		// ������ �ε��� ArrayList
		ArrayList<Integer> deleteIndex = new ArrayList<>();
		
		// ��ü �л��� ��� result �迭�� ��ȸ�ϸ鼭
		// Student.toString()�Լ��� ��µ� 
		for (int i = 0; i < result.size(); i++) {
			String stringStudentValue = result.get(i).toString();
			for (String keyword : searchKeywords) {
				if(!stringStudentValue.contains(" " + keyword + " ") && !deleteIndex.contains(i)) {
					deleteIndex.add(i);
				}
			}
		}
		Collections.sort(deleteIndex, Collections.reverseOrder());
		
		return printSearchResult(scanner, result, deleteIndex);
	
	}
	
	public static void changeStudent(Scanner scanner){
		String input;
		
		ArrayList<Student> studentArray = new ArrayList<>();
		studentArray.addAll(FileManager.studentArray);
		String[] studentInfoArray = new String[6];
		
		while (true) {
			
	
			System.out.println("====================================================");
			System.out.println("���������� ������ �л��� �й��� �Է����ּ���.");
			System.out.println("====================================================");
			
			input = scanner.nextLine();
			
			try{
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				if(updateStudent == null){
					System.out.println("���� ���� �ʴ� �й��Դϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
				else {
					studentInfoArray = new String[]{String.valueOf(updateStudent.student_id),String.valueOf(updateStudent.student_grade),updateStudent.student_name,
							updateStudent.student_major,updateStudent.student_tel,updateStudent.student_state};
					System.out.println("====================================================");
					System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
					System.out.println(updateStudent.toString());
					System.out.println("���� ������ ���� �Ͻðڽ��ϱ�?(y/n)");
					System.out.println("====================================================");
					input = scanner.nextLine();

					if (input.equals("y")) {
						System.out.println("====================================================");
						System.out.println("������ �׸��� �Է����ּ���. (�׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
						System.out.println("====================================================");
						input = scanner.nextLine();
						int index = getListIndex(input, list);
						
						update(scanner, index, studentInfoArray, updateStudent);
					}
					else {
						continue;
					}
				}
			}catch(NumberFormatException e) {
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}
		}
	}
	
	public static int getListIndex(String input,String[] list) {
		for(int i =0; i< list.length; i++) {
			if(input.equals(list[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public static void update(Scanner scanner, int index, String[] studentInfoArray, Student student) {
		String input;
		if(index == -1) {
			System.out.println("�׸��� �߸��ԷµǾ����ϴ�.");
		}
		
		else {
			System.out.println("====================================================");
			System.out.println("������ " +list[index]+"��(��) �Է����ּ���. ���� "+list[index]+"��(��) " +studentInfoArray[index]+"�Դϴ�.");
			System.out.println("====================================================");
			switch(index) {
				case 0:
					System.out.println("�й��� �����Ҽ� �����ϴ�.");
					break;
				case 1:
					while(true) {
						input = scanner.nextLine();
						if(StudentVerify.isGrade(input)) {
							student.student_grade = Integer.parseInt(input);
							Print(student);
							break;
						}
						else {
							System.out.println("�г��� Ȯ�� �� �ٽ� �Է����ּ���. (����1�ڸ�)");
						}
					}
					break;
				case 2:
					while(true) {
						input = scanner.nextLine();
						if(StudentVerify.isName(input)) {
							student.student_name = input;
							Print(student);
							break;
						}
						else {
							System.out.println("�̸��� Ȯ�� �� �ٽ� �Է����ּ���.");
						}
						
					}
					break;
				case 3:
					while(true) {
						input = scanner.nextLine();
						if(StudentVerify.isMajor(input)) {
							student.student_major = input;
							Print(student);
							break;
						}
						else {
							System.out.println("�а��� Ȯ�� �� �ٽ� �Է����ּ���. (ex. xx�а�)");
						}
					}
					break;
				case 4:
					while(true) {
						input = scanner.nextLine();
						if(StudentVerify.isMob(input)) {
							student.student_tel = input;
							Print(student);
							break;
						}
						else {
							System.out.println("��ȭ��ȣ�� Ȯ�� �� �ٽ� �Է����ּ���. (����, ����, ����, ���� �Է� ����)");
						}
					}
					break;
				case 5:
					while(true) {
						input = scanner.nextLine();
						if(StudentVerify.isState(input)) {
							student.student_state = input;
							Print(student);
							break;
						}
						else {
							System.out.println("�������¸� Ȯ�� �� �ٽ� �Է����ּ���. (��ȣ�� �Է����ּ���.)");
						}
					}
					break;
			}
		}
	}
	
	public static void Print(Student student) {
		System.out.println("====================================================");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
		System.out.println(student.toString());
		System.out.println("����Ǿ����ϴ�.");
		System.out.println("====================================================");
	}
}
