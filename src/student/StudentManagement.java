package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	static String[] list = { "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������" };

	// �л� ��� �޼ҵ�
	public static void registerStudent(Scanner scanner) {
		String[] studentInfo = new String[6];

		int index = -1;
		boolean modify = false;
		while(true) {
			switch(index) {
			case -1:
				System.out.println();
				System.out.println("*���ο� �л� ������ ����մϴ�. (���� �⺻���� �������� ��ϵ�)");
				System.out.println("���� �Է� ���� q �Է����� ���� �޴��� ���ư� �� �ֽ��ϴ�.");
				
			case 0:
				System.out.println("------------------------------------------------------------");
				System.out.println("����� �л��� �й��� �Է����ּ���. (���� 8�ڸ�)");
				System.out.println("------------------------------------------------------------");

				while (true) {
					String id = scanner.nextLine();
					if(id.equals("q")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						return;
					}
					// ��ȿ�� �˻� �� �ߺ� üũ
					if (InformationVerify.isId(id) && InformationVerify.isOverlabID(id)) {
						studentInfo[0] = id;
						break;
					} else {
						System.out.println("�ߺ��� �й��̰ų� �й� ���Ŀ� ���� �ʽ��ϴ�. Ȯ�� �� �ٽ� �Է����ּ���. (���� 8�ڸ�)");
					}
				}
				if(modify) {
					index = 5;
					break;
				}
				
			case 1:
				System.out.println("------------------------------------------------------------");
				System.out.println("����� �л��� �г��� �Է����ּ���. (���� 1�ڸ�)");
				System.out.println("------------------------------------------------------------");

				while (true) {
					String grade = scanner.nextLine();
					if(grade.equals("q")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						return;
					}
					// ��ȿ�� �˻�
					if (InformationVerify.isGrade(grade)) {
						studentInfo[1] = grade;
						break;
					} else {
						System.out.println("�г��� Ȯ�� �� �ٽ� �Է����ּ���. (1~4 ������ ���� 1�ڸ�)");
					}
				}
				if(modify) {
					index = 5;
					break;
				}
				
			case 2:
				System.out.println("------------------------------------------------------------");
				System.out.println("����� �л��� �̸��� �Է����ּ���.");
				System.out.println("------------------------------------------------------------");

				while (true) {
					String name = scanner.nextLine();
					if(name.equals("q")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						return;
					}
					// ��ȿ�� �˻�
					if (InformationVerify.isName(name)) {
						studentInfo[2] = name;
						break;
					} else {
						System.out.println("�̸��� Ȯ�� �� �ٽ� �Է����ּ���.");
					}
				}
				if(modify) {
					index = 5;
					break;
				}
				
			case 3:
				System.out.println("------------------------------------------------------------");
				System.out.println("����� �л��� �а��� �Է����ּ���. (ex. xx�а�)");
				System.out.println("------------------------------------------------------------");

				while (true) {
					String major = scanner.nextLine();
					if(major.equals("q")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						return;
					}
					// ��ȿ�� �˻�
					if (InformationVerify.isMajor(major)) {
						studentInfo[3] = major;
						break;
					} else {
						System.out.println("�а��� Ȯ�� �� �ٽ� �Է����ּ���. (ex. xx�а�)");
					}
				}
				if(modify) {
					index = 5;
					break;
				}
				
			case 4:
				System.out.println("------------------------------------------------------------");
				System.out.println("����� �л��� ��ȭ��ȣ�� �Է����ּ���. (ex. 010-xxxx-xxxx)");
				System.out.println("------------------------------------------------------------");

				while (true) {
					String tel = scanner.nextLine();
					if(tel.equals("q")) {
						System.out.println("���� �޴��� ���ư��ϴ�.");
						return;
					}
					// ��ȿ�� �˻� �� �ߺ� üũ
					if (InformationVerify.isMob(tel) && InformationVerify.isOverlabTel(tel)) {
						studentInfo[4] = tel;
						studentInfo[5] = "����";
						break;
					} else {
						System.out.println("��ȭ��ȣ�� Ȯ�� �� �ٽ� �Է����ּ���. (ex. 010-xxxx-xxxx)");
					}
				}
				
			case 5:	
				// �Է��� ������ �´��� Ȯ��	
				Student student = new Student(studentInfo);
				System.out.println("------------------------------------------------------------");
				System.out.println(student.toString());
				System.out.println("------------------------------------------------------------");
				System.out.println("����Ͻ� ������ �½��ϱ�? (y/n)");
				
				if (scanner.nextLine().equals("y")) {
					// �л� ArrayList�� �߰�
					FileManager.studentArray.add(student);
				} else {
					// �׸��� �Է��ؼ� �߸� �Էµ� �� ����
					System.out.println("------------------------------------------------------------");
					System.out.println("���Է��� �׸���� �Է����ּ���. (�й�, �г�, �̸�, �а�, ��ȭ��ȣ)");
					System.out.println("------------------------------------------------------------");
					
					while(true) {
						String info = scanner.nextLine();
						index = Arrays.asList(list).indexOf(info);
						if(index != -1 && index != 5) {
							break;
						}
						else {
							System.out.println("------------------------------------------------------------");
							System.out.println("���Է��� �׸���� �ùٸ��� �Է����ּ���. (�й�, �г�, �̸�, �а�, ��ȭ��ȣ)");
							System.out.println("------------------------------------------------------------");
						}
					}
					modify = true;
					break;
				}
				
			case 6:
				// �߰� �۾����� ����
				System.out.println("------------------------------------------------------------");
				System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�. ��� �۾��Ͻðڽ��ϱ�? (y/n)");
				System.out.println("------------------------------------------------------------");
	
				if (!scanner.nextLine().equals("y")) {
					System.out.println("�л� ����� �����ϰ� ���� �޴��� ���ư��ϴ�.");
					return;
				}
				index = 0;
				modify = false;
			
			default:
				System.out.println("������ ������ ���� ���� �޴��� ���ư��ϴ�.");
				return;
			}


		}
	}

	// �л� ���� �˻�
	public static void searchStudent(Scanner scanner) {

		boolean resetSearch = true;
		while (resetSearch) {
			System.out.println();
			System.out.println("* �л� ������ �˻��մϴ�.");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("�˻��� �л��� ���� ������ ����� �����ؼ� �Է����ּ���.(ex. ��ö�� ��ǻ�Ͱ��а� 1)");
			System.out.println("������ �׸񺰷� �ϳ����� �Է°����մϴ�.(�׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
			System.out.println("----------------------------------------------------------------------");

			ArrayList<Student> result = new ArrayList<>();
			result.addAll(FileManager.studentArray);

			// �˻� Ű���带 �Է¹ް�, �˻� ����� ����
			result = getSearchResult(scanner, true, result);

			// �˻� ��, �߰� ������ �Է��Ͽ� �˻��� ���� ����
			boolean moreSearch = true;
			while (moreSearch && result != null) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("�� �˻��� �Ͻðڽ��ϱ�?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				moreSearch = scanner.nextLine().equals("y") ? true : false;
				
				if (!moreSearch) {
					// �� �˻����� �ʴ´ٸ� �˻� ����
					break;
				}
				// ���ο� �˻� Ű���带 �Է� �޾�, �� �˻�
				result = getSearchResult(scanner, false, result);
			}
			
			// �˻� ������ �߰����� �ʴ´ٸ� �ٽ� �˻����� ����
			System.out.println("----------------------------------------------------------------------");
			System.out.println("�ٽ� �˻��Ͻðڽ��ϱ�?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			resetSearch = scanner.nextLine().equals("y") ? true : false;

		}
		System.out.println("���� ȭ������ ���ư��ϴ�.");
	}

	// �˻� Ű���带 �Է� �ް�, �˻��� ����� ����
	public static ArrayList<Student> getSearchResult(Scanner scanner, boolean isFirst, ArrayList<Student> result) {
		// ó�� �˻�����, �߰� �˻����� Ȯ��
		if (!isFirst) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("�� �˻��� ������ �Է����ּ���.");
			System.out.println("----------------------------------------------------------------------");
		}

		// �˻��� Ű���� �Է� ����
		String[] searchKeywords = scanner.nextLine().split(" ");
		if (searchKeywords[0].equals("")) {
			System.out.println("���� �Է����ּ���.");
			return null;
		}
		
		// ������ �ε��� ArrayList
		ArrayList<Integer> deleteIndex = new ArrayList<>();

		// Student.toString �޼ҵ带 �̿��ؼ� �˻��� Ű���尡 ���ԵǾ����� Ȯ��
		// ������ �ε������� ����
		for (int i = 0; i < result.size(); i++) {
			String stringStudentValue = " " + result.get(i).toString() + " ";
			for (String keyword : searchKeywords) {
				if (!stringStudentValue.contains(" " + keyword + " ") && !deleteIndex.contains(i)) {
					deleteIndex.add(i);
				}
			}
		}
		
		// ������ �ε������� ��������
		Collections.sort(deleteIndex, Collections.reverseOrder());

		// �˻��� ����� �ִ� ���
		if (result.size() != deleteIndex.size()) {
			System.out.println();

			System.out.println("----------------------------------------------------------------------");
			System.out.println(String.format(" %-10s%-5s%-5s%-10s%-15s%-10s ", "�й�", "�г�", "�̸�", "�а�", "��ȭ��ȣ", "��������"));
			System.out.println("----------------------------------------------------------------------");
			
			// �˻� Ű���尡 ���� �ε��� ����
			for (Integer integer : deleteIndex) {
				result.remove((int) integer);
			}

			// �˻��� ��� ���
			for (Student student : result) {
				System.out.println(student.toString());
			}
			
			System.out.println();
			return result;

		} else {
			// �˻��� ����� ���� ���
			System.out.println("�˻��� ����� �����ϴ�.");
			return null;
		}

	}

	// �л� �������� ���� ����
	public static void changeStudent(Scanner scanner) {
		
		String input;
		String[] studentInfoArray = new String[6];

		while (true) {
			System.out.println();
			System.out.println("* �л� ������ �����մϴ�.");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("���������� ������ �л��� �й��� �Է����ּ���. (q : ���� �޴� ���ư���)");
			System.out.println("----------------------------------------------------------------------");

			input = scanner.nextLine();
			if(input.equals("q")) {
				System.out.println("���� �޴��� ���ư��ϴ�.");
				break;
			}
			try {
				// ���������� ������ Student ��ü
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				// ������ Student ��ü�� ���� ���
				if (updateStudent == null) {
					System.out.println("���� ���� �ʴ� �й��Դϴ�. �ٽ� �Է����ּ���.");
					continue;
				} else {
					// ������ ��ü�� �ִ� ��� �������� ����
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
						while(true) {
							System.out.println("----------------------------------------------------------------------");
							System.out.println("������ �׸��� �Է����ּ���. (q �Է� : ���, �׸� : �й�, �г�, �̸�, �а�, ��ȭ��ȣ, ��������)");
							System.out.println("----------------------------------------------------------------------");
							input = scanner.nextLine();
							
							if(input.equals("q")) {
								break;
							}
							// �Է� ���� �׸� String �� �׸� ����Ʈ�� index�� ��ȯ
							int index = getListIndex(input, list);
							
							// �л� ���� ���� ����
							if(update(scanner, index, studentInfoArray, updateStudent)) {
								break;
							}

						}
					} else {
						break;
					}
				}
			} catch (NumberFormatException e) {
				// �й� �Է� ��, ���ڿ��� �Է��� ��� ���� ó��
				System.out.println("���ڸ� �Է����ּ���.");
				continue;
			}

			// �߰� �۾� ����
			System.out.println("----------------------------------------------------------------------");
			System.out.println("�߰��� �۾��Ͻðڽ��ϱ�?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			input = scanner.nextLine();
			if (input.equals("y")) {
				continue;
			} else {
				System.out.println("���� �޴��� ���ư��ϴ�.");
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

	public static boolean update(Scanner scanner, int index, String[] studentInfoArray, Student student) {
		String input;
		if (index == -1) {
			System.out.println("�׸��� �߸� �ԷµǾ����ϴ�.");
			return false;
		} else if (index == 0) {
			System.out.println("�й��� ������ �� �����ϴ�.");
			return false;
		} else {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("������ " + list[index] + "��(��) �Է����ּ���. ���� " + list[index] + "��(��) "
					+ studentInfoArray[index] + "�Դϴ�.");
			System.out.println("----------------------------------------------------------------------");
			switch (index) {
			case 1:
				while (true) {
					input = scanner.nextLine();
					if (InformationVerify.isGrade(input)) {
						student.student_grade = Integer.parseInt(input);
						Print(student);
						break;
					} else {
						System.out.println("�г��� Ȯ�� �� �ٽ� �Է����ּ���. (1~4 ���� ����1�ڸ�)");
					}
				}
				break;
			case 2:
				while (true) {
					input = scanner.nextLine();
					if (InformationVerify.isName(input)) {
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
					if (InformationVerify.isMajor(input)) {
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
					if (InformationVerify.isMob(input)) {
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
					if (InformationVerify.isState(input)) {
						student.student_state = input;
						Print(student);
						break;
					} else {
						System.out.println("�������¸� Ȯ�� �� �ٽ� �Է����ּ���. (����, ����, ����, ���� �Է� ����)");
					}
				}
				break;
			}
			return true;
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
