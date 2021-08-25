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
			System.out.println(" * 학생 정보 검색");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" 검색할 학생에 대한 정보를 띄어쓰기로 구분해서 입력해주세요.(ex. 김철수 컴퓨터공학과 1)");
			System.out.println(" 정보는 항목별로 하나씩만 입력가능합니다.(항목 : 학번, 학년, 이름, 학과, 전화번호, 학적상태)");
			System.out.println("----------------------------------------------------------------------");
			
			ArrayList<Student> result = new ArrayList<>();
			result.addAll(FileManager.studentArray);
			
			result = getSearchResult(scanner, true, result);
			
			boolean moreSearch = true;
			
			while(moreSearch && result != null) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println(" 상세 검색을 하시겠습니까?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				moreSearch = scanner.nextLine().equals("y") ? true : false;
				if(!moreSearch) {
					break;
				}
				result = getSearchResult(scanner, false, result);
			}
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" 다시 검색하시겠습니까?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			resetSearch = scanner.nextLine().equals("y") ? true : false;

		}
		System.out.println("메인 화면으로 돌아갑니다.");
	}
	
	public static void changeStudent() {
		
	}
	
	public static void gradeManagement() {
		
	}
	
	// 검색 결과를 출력
	public static ArrayList<Student> printSearchResult(Scanner scanner, ArrayList<Student> result, ArrayList<Integer> deleteIndex) {
		if(result.size() != deleteIndex.size()) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println(String.format(" %-10s%-5s%-5s%-10s%-15s%-10s ", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
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
			System.out.println("검색된 결과가 없습니다.");
			return null;
		}
	}
	
	// 검색 키워드를 입력 받고, 검색된 결과를 리턴
	public static ArrayList<Student> getSearchResult(Scanner scanner, boolean isFirst, ArrayList<Student> result) {
		// 처음 검색인지, 추가 검색인지 확인
		if(!isFirst) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" 상세 검색할 내용을 입력해주세요.");
			System.out.println("----------------------------------------------------------------------");
		}
		
		
		// 검색할 키워드 입력 받음
		String[] searchKeywords = scanner.nextLine().split(" ");
		
		System.out.println(searchKeywords[0].equals("")); // 검색 키워드 공백 입력 나중에 추가
		// 삭제할 인덱스 ArrayList
		ArrayList<Integer> deleteIndex = new ArrayList<>();
		
		// 전체 학생이 담긴 result 배열을 순회하면서
		// Student.toString()함수로 출력된 
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
