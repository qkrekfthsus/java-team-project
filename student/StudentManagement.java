package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagement {

	static Scanner sc = new Scanner(System.in);
	//static ArrayList<Student> studentArray = new ArrayList<>();
	static String[] studentInfo = new String[6];

	// ���� �۾� ���� ���� �Լ�
	public static void registerQ() {

		System.out.println("==============================================");
		System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�. ��� �۾��Ͻðڽ��ϱ�? (y/n)");

		if (sc.nextLine().equals("y")) {
			// �л� ��� �Լ� ȣ��
			registerStudent();
		} else {
			// ���θ޴��� ���ư���
			System.out.println("�л� ����� �����ϰ� ���� �޴��� ���ư��ϴ�.");
			System.out.println("==============================================");
			System.out.println();
			Menu.selectMenu();
		}

	}


	// �л� ��� �Լ�
	public static void registerStudent() {

		System.out.println("*���ο� �л� ������ ����մϴ�. (���� �⺻���� �������� ��ϵ�)");
		registerId();
	}
	
	// �Է��� ���� �´��� Ȯ��
	public static void infoQ() {
		
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
		} else {
			System.out.println("���Է��� �׸���� �Է����ּ���.");
			String info = sc.nextLine();
			if (info.equals("�й�")) {
				registerId();
				infoQ();
			} else if (info.equals("�г�")) {
				registerGrade();
				infoQ();
			} else if (info.equals("�̸�")) {
				registerName();
				infoQ();
			} else if (info.equals("�а�")) {
				registerMajor();
				infoQ();
			} else if (info.equals("��ȭ��ȣ")) {
				registerTel();
				infoQ();
			}
		}
	}

	// �й��Է�
	public static void registerId() {
		System.out.println("----------------------------------------------");
		System.out.println("����� �л��� �й��� �Է����ּ���. (����8�ڸ�)");
		while (true) {
			String id = sc.nextLine();
			if (isId(id) == true) {
				overlap(id);
				studentInfo[0] = id;
				registerGrade();
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
			if (isGrade(grade) == true) {
				studentInfo[1] = grade;
				registerName();
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
			if (isName(name) == true) {
				studentInfo[2] = name;
				registerMajor();
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
			if (isMajor(major) == true) {
				studentInfo[3] = major;
				registerTel();
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
			if (isMob(tel) == true) {
				overlap(tel);
				studentInfo[4] = tel;
				studentInfo[5] = "����";
				infoQ();
				break;
			} else {
				System.out.println("��ȭ��ȣ�� Ȯ�� �� �ٽ� �Է����ּ���. (��ȣ�� �Է����ּ���.)");
				continue;
			}
		}

	}

	// ��ȿ���˻�
	public static boolean isId(String str) {
		return Pattern.matches("^\\d{8}$", str);
	}

	public static boolean isGrade(String str) {
		return Pattern.matches("^\\d{1}$", str);
	}

	public static boolean isName(String str) {
		return Pattern.matches("^[a-zA-Z]*$|^[��-����-�R]*$", str);
	}

	public static boolean isMajor(String str) {
		return Pattern.matches("^([��-�R]*)�а�$", str);
	}

	public static boolean isMob(String str) {
		return Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}$", str);
	}
	
	public static String overlap(String str) {
		String a = str;
		for (int i = 0; i < FileManager.studentArray.size(); i++) {
			String existValue = FileManager.studentArray.get(i).toString();
			if(existValue.contains(" "+a+" ")) {
				a = "�ߺ��� �����Դϴ�. Ȯ�� �� �ٽ� �Է��� �ֽʽÿ�.";
			}
		}
		return a;
	}

///////////////////////////////////////////////////////////////////////////////////

	public static void searchStudent() {
		Scanner scanner = new Scanner(System.in);
		
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
	
	public static void changeStudent() {
		
	}
	
	public static void gradeManagement() {
		
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

}
