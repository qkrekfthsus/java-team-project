package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	public static void registerStudent() {
		
		
		
	}
	
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
