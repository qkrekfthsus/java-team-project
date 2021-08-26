package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagement {

	static Scanner sc = new Scanner(System.in);
	//static ArrayList<Student> studentArray = new ArrayList<>();
	static String[] studentInfo = new String[6];

	// 이후 작업 여부 묻는 함수
	public static void registerQ() {

		System.out.println("==============================================");
		System.out.println("학생 등록이 완료되었습니다. 계속 작업하시겠습니까? (y/n)");

		if (sc.nextLine().equals("y")) {
			// 학생 등록 함수 호출
			registerStudent();
		} else {
			// 메인메뉴로 돌아가기
			System.out.println("학생 등록을 종료하고 메인 메뉴로 돌아갑니다.");
			System.out.println("==============================================");
			System.out.println();
			Menu.selectMenu();
		}

	}


	// 학생 등록 함수
	public static void registerStudent() {

		System.out.println("*새로운 학생 정보를 등록합니다. (상태 기본값은 재학으로 등록됨)");
		registerId();
	}
	
	// 입력한 값이 맞는지 확인
	public static void infoQ() {
		
		for (int i = 0; i < studentInfo.length; i++) {
			System.out.print(studentInfo[i] + " ");
		}
		System.out.println();
		System.out.println("등록하실 정보가 맞습니까? (y/n)");
		if (sc.nextLine().equals("y")) {
			// Student 객체 생성하여 ArrayList에 추가
			Student student = new Student(studentInfo);
			FileManager.studentArray.add(student);

			// 이후 작업여부 묻는 함수 호출
			registerQ();
		} else {
			System.out.println("재입력할 항목명을 입력해주세요.");
			String info = sc.nextLine();
			if (info.equals("학번")) {
				registerId();
				infoQ();
			} else if (info.equals("학년")) {
				registerGrade();
				infoQ();
			} else if (info.equals("이름")) {
				registerName();
				infoQ();
			} else if (info.equals("학과")) {
				registerMajor();
				infoQ();
			} else if (info.equals("전화번호")) {
				registerTel();
				infoQ();
			}
		}
	}

	// 학번입력
	public static void registerId() {
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학번을 입력해주세요. (숫자8자리)");
		while (true) {
			String id = sc.nextLine();
			if (isId(id) == true) {
				overlap(id);
				studentInfo[0] = id;
				registerGrade();
				break;
			} else {
				System.out.println("학번을 확인 후 다시 입력해주세요. (숫자8자리)");
				continue;
			}
		}

	}

	// 학년입력
	public static void registerGrade() {
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학년을 입력해주세요. (숫자1자리)");
		while (true) {
			String grade = sc.nextLine();
			if (isGrade(grade) == true) {
				studentInfo[1] = grade;
				registerName();
				break;
			} else {
				System.out.println("학년을 확인 후 다시 입력해주세요. (숫자1자리)");
				continue;
			}
		}

	}

	// 이름입력
	public static void registerName() {
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 이름을 입력해주세요.");
		while (true) {
			String name = sc.nextLine();
			if (isName(name) == true) {
				studentInfo[2] = name;
				registerMajor();
				break;
			} else {
				System.out.println("이름을 확인 후 다시 입력해주세요.");
				continue;
			}
		}

	}

	// 학과입력
	public static void registerMajor() {
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학과를 입력해주세요. (ex. xx학과)");
		while (true) {
			String major = sc.nextLine();
			if (isMajor(major) == true) {
				studentInfo[3] = major;
				registerTel();
				break;
			} else {
				System.out.println("학과를 확인 후 다시 입력해주세요. (ex. xx학과)");
				continue;
			}
		}

	}

	// 전화번호입력
	public static void registerTel() {
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 전화번호를 입력해주세요. (번호만 입력해주세요.)");
		while (true) {
			String tel = sc.nextLine();
			if (isMob(tel) == true) {
				overlap(tel);
				studentInfo[4] = tel;
				studentInfo[5] = "재학";
				infoQ();
				break;
			} else {
				System.out.println("전화번호를 확인 후 다시 입력해주세요. (번호만 입력해주세요.)");
				continue;
			}
		}

	}

	// 유효성검사
	public static boolean isId(String str) {
		return Pattern.matches("^\\d{8}$", str);
	}

	public static boolean isGrade(String str) {
		return Pattern.matches("^\\d{1}$", str);
	}

	public static boolean isName(String str) {
		return Pattern.matches("^[a-zA-Z]*$|^[ㄱ-ㅎ가-힣]*$", str);
	}

	public static boolean isMajor(String str) {
		return Pattern.matches("^([가-힣]*)학과$", str);
	}

	public static boolean isMob(String str) {
		return Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}$", str);
	}
	
	public static String overlap(String str) {
		String a = str;
		for (int i = 0; i < FileManager.studentArray.size(); i++) {
			String existValue = FileManager.studentArray.get(i).toString();
			if(existValue.contains(" "+a+" ")) {
				a = "중복된 정보입니다. 확인 후 다시 입력해 주십시오.";
			}
		}
		return a;
	}

///////////////////////////////////////////////////////////////////////////////////

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
