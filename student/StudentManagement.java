package student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagement {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> studentArray = new ArrayList<>();
	static String[] studentInfo = new String[6];

	// 이후 작업 여부 묻는 함수
	public static void registerQ() {

		System.out.println("==============================================");
		System.out.println("학생 등록이 완료되었습니다. 계속 작업하시겠습니까? (y/n)");
		System.out.println("==============================================");

		if (sc.nextLine().equals("y")) {
			// 학생 등록 함수 호출
			registerStudent();
		} else {
			// 메인메뉴로 돌아가기
			System.out.println("학생 등록을 종료하고 메인 메뉴로 돌아갑니다.");
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
			studentArray.add(student);

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
		return Pattern.matches("^[a-zA-Z]|[ㄱ-ㅎ가-힣]*$", str);
	}

	public static boolean isMajor(String str) {
		return Pattern.matches("^([가-힣]*)학과$", str);
	}

	public static boolean isMob(String str) {
		return Pattern.matches("^\\d{3}\\d{3,4}\\d{4}$", str);
	}

///////////////////////////////////////////////////////////////////////////////////

	public static void searchStudent() {

	}

	public static void changeStudent() {

	}

	public static void gradeManagement() {

	}

}
