package student;

import java.util.ArrayList;
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

///////////////////////////////////////////////////////////////////////////////////

	public static void searchStudent() {

	}

	public static void changeStudent() {

	}

}
