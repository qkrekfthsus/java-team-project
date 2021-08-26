package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	static String[] studentInfo = new String[6];
	static Scanner sc = new Scanner(System.in);
	static String[] list = {"학번", "학년", "이름", "학과", "전화번호", "학적상태"};

	// 학생 등록 메소드
	public static void registerStudent() {
		System.out.println("*새로운 학생 정보를 등록합니다. (상태 기본값은 재학으로 등록됨)");
		registerId();
		registerGrade();
		registerName();
		registerMajor();
		registerTel();


	}				

	
	// 학번입력
	public static void registerId() {
		System.out.println("----------------------------------------------");
		System.out.println("등록할 학생의 학번을 입력해주세요. (숫자8자리)");
		while (true) {
			String id = sc.nextLine();
			if (StudentVerify.isId(id)) {
				studentInfo[0] = id;
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
			if (StudentVerify.isGrade(grade)) {
				studentInfo[1] = grade;
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
			if (StudentVerify.isName(name)) {
				studentInfo[2] = name;
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
			if (StudentVerify.isMajor(major)) {
				studentInfo[3] = major;
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
			if (StudentVerify.isMob(tel)) {
				studentInfo[4] = tel;
				studentInfo[5] = "재학";
				while(true) {
					if(infoQ()) {
						break;
					}
				}
				break;
			} else {
				System.out.println("전화번호를 확인 후 다시 입력해주세요. (번호만 입력해주세요.)");
				continue;
			}
		}

	}

	// 입력한 값이 맞는지 확인
	public static boolean infoQ() {
		
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
			return true;
		} else {
			System.out.println("재입력할 항목명을 입력해주세요.");
			String info = sc.nextLine();
			if (info.equals("학번")) {
				registerId();
			} else if (info.equals("학년")) {
				registerGrade();
			} else if (info.equals("이름")) {
				registerName();
			} else if (info.equals("학과")) {
				registerMajor();
			} else if (info.equals("전화번호")) {
				registerTel();
			}
			return false;
		}
	}
	
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
		}

	}	
	
	public static void searchStudent(Scanner scanner) {

		
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
	
	public static void changeStudent(Scanner scanner){
		String input;
		
		ArrayList<Student> studentArray = new ArrayList<>();
		studentArray.addAll(FileManager.studentArray);
		String[] studentInfoArray = new String[6];
		
		while (true) {
			
	
			System.out.println("====================================================");
			System.out.println("인적사항을 변경할 학생의 학번을 입력해주세요.");
			System.out.println("====================================================");
			
			input = scanner.nextLine();
			
			try{
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				if(updateStudent == null){
					System.out.println("존재 하지 않는 학번입니다. 다시 입력해주세요.");
					continue;
				}
				else {
					studentInfoArray = new String[]{String.valueOf(updateStudent.student_id),String.valueOf(updateStudent.student_grade),updateStudent.student_name,
							updateStudent.student_major,updateStudent.student_tel,updateStudent.student_state};
					System.out.println("====================================================");
					System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
					System.out.println(updateStudent.toString());
					System.out.println("인적 사항을 변경 하시겠습니까?(y/n)");
					System.out.println("====================================================");
					input = scanner.nextLine();

					if (input.equals("y")) {
						System.out.println("====================================================");
						System.out.println("변경할 항목을 입력해주세요. (항목 : 학번, 학년, 이름, 학과, 전화번호, 학적상태)");
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
				System.out.println("숫자를 입력해주세요.");
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
			System.out.println("항목이 잘못입력되었습니다.");
		}
		
		else {
			System.out.println("====================================================");
			System.out.println("변경할 " +list[index]+"을(를) 입력해주세요. 현재 "+list[index]+"은(는) " +studentInfoArray[index]+"입니다.");
			System.out.println("====================================================");
			switch(index) {
				case 0:
					System.out.println("학번은 변경할수 없습니다.");
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
							System.out.println("학년을 확인 후 다시 입력해주세요. (숫자1자리)");
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
							System.out.println("이름을 확인 후 다시 입력해주세요.");
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
							System.out.println("학과를 확인 후 다시 입력해주세요. (ex. xx학과)");
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
							System.out.println("전화번호를 확인 후 다시 입력해주세요. (재학, 휴학, 졸업, 자퇴만 입력 가능)");
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
							System.out.println("학적상태를 확인 후 다시 입력해주세요. (번호만 입력해주세요.)");
						}
					}
					break;
			}
		}
	}
	
	public static void Print(Student student) {
		System.out.println("====================================================");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
		System.out.println(student.toString());
		System.out.println("변경되었습니다.");
		System.out.println("====================================================");
	}
}
