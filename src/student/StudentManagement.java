package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	static String[] studentInfo = new String[6];
	static String[] list = { "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������" };

	// �л� ��� �޼ҵ�
	public static void registerStudent(Scanner scanner) {
		System.out.println("*���ο� �л� ������ ����մϴ�. (���� �⺻���� �������� ��ϵ�)");
		registerId(scanner);
		registerGrade(scanner);
		registerName(scanner);
		registerMajor(scanner);
		registerTel(scanner);
		while (true) {
			if (infoQ(scanner)) {
				break;
			}
		}

	}

	// �й��Է�
	public static void registerId(Scanner scanner) {
		System.out.println("------------------------------------------------------------");
		System.out.println("����� �л��� �й��� �Է����ּ���. (���� 8�ڸ�)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String id = scanner.nextLine();
			if (StudentVerify.isId(id) && StudentVerify.isOverlabID(id)) {
				studentInfo[0] = id;
				break;
			} else {
				System.out.println("�ߺ��� �й��̰ų� �й� ���Ŀ� ���� �ʽ��ϴ�. Ȯ�� �� �ٽ� �Է����ּ���. (���� 8�ڸ�)");
				continue;
			}
		}

	}

	// �г��Է�
	public static void registerGrade(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("����� �л��� �г��� �Է����ּ���. (���� 1�ڸ�)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String grade = scanner.nextLine();
			if (StudentVerify.isGrade(grade)) {
				studentInfo[1] = grade;
				break;
			} else {
				System.out.println("�г��� Ȯ�� �� �ٽ� �Է����ּ���. (���� 1�ڸ�)");
				continue;
			}
		}

	}

	// �̸��Է�
	public static void registerName(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("����� �л��� �̸��� �Է����ּ���.");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String name = scanner.nextLine();
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
	public static void registerMajor(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("����� �л��� �а��� �Է����ּ���. (ex. xx�а�)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String major = scanner.nextLine();
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
	public static void registerTel(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("����� �л��� ��ȭ��ȣ�� �Է����ּ���. (ex. 010-xxxx-xxxx)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String tel = scanner.nextLine();
			if (StudentVerify.isMob(tel) && StudentVerify.isOverlabTel(tel)) {
				studentInfo[4] = tel;
				studentInfo[5] = "����";
				break;
			} else {
				System.out.println("��ȭ��ȣ�� Ȯ�� �� �ٽ� �Է����ּ���. (ex. 010-xxxx-xxxx)");
				continue;
			}
		}

	}

	// �Է��� ���� �´��� Ȯ��
	public static boolean infoQ(Scanner scanner) {

		Student student = new Student(studentInfo);
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println(student.toString());
		System.out.println("------------------------------------------------------------");

		System.out.println("����Ͻ� ������ �½��ϱ�? (y/n)");
		if (scanner.nextLine().equals("y")) {
			// Student ��ü �����Ͽ� ArrayList�� �߰�
			FileManager.studentArray.add(student);

			// ���� �۾����� ���� �Լ� ȣ��
			registerQ(scanner);
			return true;
		} else {
			System.out.println();

			System.out.println("------------------------------------------------------------");
			System.out.println("���Է��� �׸���� �Է����ּ���.(�й�, �г�, �̸�, �а�, ��ȭ��ȣ)");
			System.out.println("------------------------------------------------------------");

			String info = scanner.nextLine();
			if (info.equals("�й�")) {
				registerId(scanner);
			} else if (info.equals("�г�")) {
				registerGrade(scanner);
			} else if (info.equals("�̸�")) {
				registerName(scanner);
			} else if (info.equals("�а�")) {
				registerMajor(scanner);
			} else if (info.equals("��ȭ��ȣ")) {
				registerTel(scanner);
			}
			return false;
		}
	}

	// ���� �۾� ���� ���� �Լ�
	public static void registerQ(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�. ��� �۾��Ͻðڽ��ϱ�? (y/n)");
		System.out.println("------------------------------------------------------------");

		if (scanner.nextLine().equals("y")) {
			// �л� ��� �Լ� ȣ��
			registerStudent(scanner);
		} else {
			// ���θ޴��� ���ư���
			System.out.println("�л� ����� �����ϰ� ���� �޴��� ���ư��ϴ�.");
		}

	}

	public static void searchStudent(Scanner scanner) {

		boolean resetSearch = true;
		while (resetSearch) {
			System.out.println(" * �л� ���� �˻�");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" �˻��� �л��� ���� ������ ����� �����ؼ� �Է����ּ���.(ex. ��ö�� ��ǻ�Ͱ��а� 1)");
			System.out.println(" ������ �׸񺰷� �ϳ����� �Է°����մϴ�.(�׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
			System.out.println("----------------------------------------------------------------------");

			ArrayList<Student> result = new ArrayList<>();
			result.addAll(FileManager.studentArray);

			result = getSearchResult(scanner, true, result);

			boolean moreSearch = true;

			while (moreSearch && result != null) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println(" �� �˻��� �Ͻðڽ��ϱ�?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				moreSearch = scanner.nextLine().equals("y") ? true : false;
				if (!moreSearch) {
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
	public static ArrayList<Student> printSearchResult(ArrayList<Student> result, ArrayList<Integer> deleteIndex) {
		if (result.size() != deleteIndex.size()) {
			System.out.println();

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

		} else {
			System.out.println("�˻��� ����� �����ϴ�.");
			return null;
		}
	}

	// �˻� Ű���带 �Է� �ް�, �˻��� ����� ����
	public static ArrayList<Student> getSearchResult(Scanner scanner, boolean isFirst, ArrayList<Student> result) {
		// ó�� �˻�����, �߰� �˻����� Ȯ��
		if (!isFirst) {
			System.out.println();

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
			String stringStudentValue = " " + result.get(i).toString() + " ";
			for (String keyword : searchKeywords) {
				if (!stringStudentValue.contains(" " + keyword + " ") && !deleteIndex.contains(i)) {
					deleteIndex.add(i);
				}
			}
		}
		Collections.sort(deleteIndex, Collections.reverseOrder());

		return printSearchResult(result, deleteIndex);

	}

	// �л� �������� ���� ����
	public static void changeStudent(Scanner scanner) {
		String input;

		ArrayList<Student> studentArray = new ArrayList<>();
		studentArray.addAll(FileManager.studentArray);
		String[] studentInfoArray = new String[6];

		while (true) {

			System.out.println("----------------------------------------------------------------------");
			System.out.println("���������� ������ �л��� �й��� �Է����ּ���.");
			System.out.println("----------------------------------------------------------------------");

			input = scanner.nextLine();

			try {
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				if (updateStudent == null) {
					System.out.println("���� ���� �ʴ� �й��Դϴ�. �ٽ� �Է����ּ���.");
					continue;
				} else {
					studentInfoArray = new String[] { String.valueOf(updateStudent.student_id),
							String.valueOf(updateStudent.student_grade), updateStudent.student_name,
							updateStudent.student_major, updateStudent.student_tel, updateStudent.student_state };

					System.out.println("----------------------------------------------------------------------");
					System.out.println(
							String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
					System.out.println(updateStudent.toString());
					System.out.println("----------------------------------------------------------------------");
					System.out.println("���� ������ ���� �Ͻðڽ��ϱ�?(y/n)");

					input = scanner.nextLine();

					if (input.equals("y")) {
						System.out.println("----------------------------------------------------------------------");
						System.out.println("������ �׸��� �Է����ּ���. (�׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
						System.out.println("----------------------------------------------------------------------");
						input = scanner.nextLine();
						int index = getListIndex(input, list);

						update(scanner, index, studentInfoArray, updateStudent);
					} else {
						break;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}

			System.out.println("----------------------------------------------------------------------");
			System.out.println("�߰��� �۾��Ͻðڽ��ϱ�?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			input = scanner.nextLine();
			if (input.equals("y")) {
				continue;
			} else {
				System.out.println("�л� �������� ������ ��ġ�� ����ȭ������ ���ư��ϴ�.");
				break;
			}

		}
	}

	public static int getListIndex(String input, String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (input.equals(list[i])) {
				return i;
			}
		}
		return -1;
	}

	public static void update(Scanner scanner, int index, String[] studentInfoArray, Student student) {
		String input;
		if (index == -1) {
			System.out.println("�׸��� �߸��ԷµǾ����ϴ�.");
		} else {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("������ " + list[index] + "��(��) �Է����ּ���. ���� " + list[index] + "��(��) "
					+ studentInfoArray[index] + "�Դϴ�.");
			System.out.println("----------------------------------------------------------------------");
			switch (index) {
			case 0:
				System.out.println("�й��� ������ �� �����ϴ�.");
				break;
			case 1:
				while (true) {
					input = scanner.nextLine();
					if (StudentVerify.isGrade(input)) {
						student.student_grade = Integer.parseInt(input);
						Print(student);
						break;
					} else {
						System.out.println("�г��� Ȯ�� �� �ٽ� �Է����ּ���. (����1�ڸ�)");
					}
				}
				break;
			case 2:
				while (true) {
					input = scanner.nextLine();
					if (StudentVerify.isName(input)) {
						student.student_name = input;
						Print(student);
						break;
					} else {
						System.out.println("�̸��� Ȯ�� �� �ٽ� �Է����ּ���.");
					}

				}
				break;
			case 3:
				while (true) {
					input = scanner.nextLine();
					if (StudentVerify.isMajor(input)) {
						student.student_major = input;
						Print(student);
						break;
					} else {
						System.out.println("�а��� Ȯ�� �� �ٽ� �Է����ּ���. (ex. xx�а�)");
					}
				}
				break;
			case 4:
				while (true) {
					input = scanner.nextLine();
					if (StudentVerify.isMob(input)) {
						student.student_tel = input;
						Print(student);
						break;
					} else {
						System.out.println("��ȭ��ȣ�� Ȯ�� �� �ٽ� �Է����ּ���. (ex. 010-xxxx-xxxx)");
					}
				}
				break;
			case 5:
				while (true) {
					input = scanner.nextLine();
					if (StudentVerify.isState(input)) {
						student.student_state = input;
						Print(student);
						break;
					} else {
						System.out.println("�������¸� Ȯ�� �� �ٽ� �Է����ּ���. (����, ����, ����, ���� �Է� ����)");
					}
				}
				break;
			}
		}
	}

	public static void Print(Student student) {
		System.out.println("----------------------------------------------------------------------");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
		System.out.println(student.toString());
		System.out.println("----------------------------------------------------------------------");
		System.out.println("����Ǿ����ϴ�.");
	}
}
