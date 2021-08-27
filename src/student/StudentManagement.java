package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManagement {
	static String[] studentInfo = new String[6];
	static String[] list = { "학번", "학년", "이름", "학과", "전화번호", "학적상태" };

	// 학생 등록 메소드
	public static void registerStudent(Scanner scanner) {
		System.out.println("*새로운 학생 정보를 등록합니다. (상태 기본값은 재학으로 등록됨)");
		registerId(scanner);
		registerGrade(scanner);
		registerName(scanner);
		registerMajor(scanner);
		registerTel(scanner);
		// 입력한 정보가 맞는지 확인
		while (true) {
			if (infoQ(scanner)) {
				break;
			}
		}
	}

	// 학번 입력
	public static void registerId(Scanner scanner) {
		System.out.println("------------------------------------------------------------");
		System.out.println("등록할 학생의 학번을 입력해주세요. (숫자 8자리)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String id = scanner.nextLine();
			// 유효성 검사 및 중복 체크
			if (StudentVerify.isId(id) && StudentVerify.isOverlabID(id)) {
				studentInfo[0] = id;
				break;
			} else {
				System.out.println("중복된 학번이거나 학번 형식에 맞지 않습니다. 확인 후 다시 입력해주세요. (숫자 8자리)");
				continue;
			}
		}

	}

	// 학년 입력
	public static void registerGrade(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("등록할 학생의 학년을 입력해주세요. (숫자 1자리)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String grade = scanner.nextLine();
			// 유효성 검사
			if (StudentVerify.isGrade(grade)) {
				studentInfo[1] = grade;
				break;
			} else {
				System.out.println("학년을 확인 후 다시 입력해주세요. (숫자 1자리)");
				continue;
			}
		}

	}

	// 이름 입력
	public static void registerName(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("등록할 학생의 이름을 입력해주세요.");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String name = scanner.nextLine();
			// 유효성 검사
			if (StudentVerify.isName(name)) {
				studentInfo[2] = name;
				break;
			} else {
				System.out.println("이름을 확인 후 다시 입력해주세요.");
				continue;
			}
		}

	}

	// 학과 입력
	public static void registerMajor(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("등록할 학생의 학과를 입력해주세요. (ex. xx학과)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String major = scanner.nextLine();
			// 유효성 검사
			if (StudentVerify.isMajor(major)) {
				studentInfo[3] = major;
				break;
			} else {
				System.out.println("학과를 확인 후 다시 입력해주세요. (ex. xx학과)");
				continue;
			}
		}

	}

	// 전화 번호 입력
	public static void registerTel(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("등록할 학생의 전화번호를 입력해주세요. (ex. 010-xxxx-xxxx)");
		System.out.println("------------------------------------------------------------");

		while (true) {
			String tel = scanner.nextLine();
			// 유효성 검사 및 중복 체크
			if (StudentVerify.isMob(tel) && StudentVerify.isOverlabTel(tel)) {
				studentInfo[4] = tel;
				studentInfo[5] = "재학";
				break;
			} else {
				System.out.println("전화번호를 확인 후 다시 입력해주세요. (ex. 010-xxxx-xxxx)");
				continue;
			}
		}

	}

	// 입력한 값이 맞는지 확인
	public static boolean infoQ(Scanner scanner) {

		// 입력한 값들을 출력
		Student student = new Student(studentInfo);
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println(student.toString());
		System.out.println("------------------------------------------------------------");
		System.out.println("등록하실 정보가 맞습니까? (y/n)");
		
		if (scanner.nextLine().equals("y")) {

			// 학생 ArrayList에 추가
			FileManager.studentArray.add(student);
			
			// 이후 작업여부 묻는 함수 호출
			registerQ(scanner);
			
			return true;
			
		} else {
			// 항목을 입력해서 잘못 입력된 값 수정
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println("재입력할 항목명을 입력해주세요.(학번, 학년, 이름, 학과, 전화번호)");
			System.out.println("------------------------------------------------------------");
			
			String info = scanner.nextLine();
			if (info.equals("학번")) {
				registerId(scanner);
			} else if (info.equals("학년")) {
				registerGrade(scanner);
			} else if (info.equals("이름")) {
				registerName(scanner);
			} else if (info.equals("학과")) {
				registerMajor(scanner);
			} else if (info.equals("전화번호")) {
				registerTel(scanner);
			}
			return false;
		}
	}

	// 이후 작업 여부 묻는 함수
	public static void registerQ(Scanner scanner) {
		System.out.println();

		System.out.println("------------------------------------------------------------");
		System.out.println("학생 등록이 완료되었습니다. 계속 작업하시겠습니까? (y/n)");
		System.out.println("------------------------------------------------------------");

		if (scanner.nextLine().equals("y")) {
			// 학생 등록 함수 호출
			registerStudent(scanner);
		} else {
			// 메인메뉴로 돌아가기
			System.out.println("학생 등록을 종료하고 메인 메뉴로 돌아갑니다.");
		}

	}

	// 학생 정보 검색
	public static void searchStudent(Scanner scanner) {

		boolean resetSearch = true;
		while (resetSearch) {
			System.out.println("* 학생 정보 검색");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("검색할 학생에 대한 정보를 띄어쓰기로 구분해서 입력해주세요.(ex. 김철수 컴퓨터공학과 1)");
			System.out.println("정보는 항목별로 하나씩만 입력가능합니다.(항목 : 학번, 학년, 이름, 학과, 전화번호, 학적상태)");
			System.out.println("----------------------------------------------------------------------");

			ArrayList<Student> result = new ArrayList<>();
			result.addAll(FileManager.studentArray);

			// 검색 키워드를 입력받고, 검색 결과를 리턴
			result = getSearchResult(scanner, true, result);

			// 검색 후, 추가 조건을 입력하여 검색을 할지 여부
			boolean moreSearch = true;
			while (moreSearch && result != null) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("상세 검색을 하시겠습니까?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				moreSearch = scanner.nextLine().equals("y") ? true : false;
				
				if (!moreSearch) {
					// 상세 검색하지 않는다면 검색 종료
					break;
				}
				// 새로운 검색 키워드를 입력 받아, 상세 검색
				result = getSearchResult(scanner, false, result);
			}
			
			// 검색 조건을 추가하지 않는다면 다시 검색할지 여부
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("다시 검색하시겠습니까?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			resetSearch = scanner.nextLine().equals("y") ? true : false;

		}
		System.out.println();
		System.out.println("메인 화면으로 돌아갑니다.");
	}

	// 검색 키워드를 입력 받고, 검색된 결과를 리턴
	public static ArrayList<Student> getSearchResult(Scanner scanner, boolean isFirst, ArrayList<Student> result) {
		// 처음 검색인지, 추가 검색인지 확인
		if (!isFirst) {
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("상세 검색할 내용을 입력해주세요.");
			System.out.println("----------------------------------------------------------------------");
		}

		// 검색할 키워드 입력 받음
		String[] searchKeywords = scanner.nextLine().split(" ");
		if (searchKeywords[0].equals("")) {
			System.out.println("값을 입력해주세요.");
			return null;
		}
		
		// 삭제할 인덱스 ArrayList
		ArrayList<Integer> deleteIndex = new ArrayList<>();

		// Student.toString 메소드를 이용해서 검색할 키워드가 포함되었는지 확인
		// 삭제할 인덱스들을 저장
		for (int i = 0; i < result.size(); i++) {
			String stringStudentValue = " " + result.get(i).toString() + " ";
			for (String keyword : searchKeywords) {
				if (!stringStudentValue.contains(" " + keyword + " ") && !deleteIndex.contains(i)) {
					deleteIndex.add(i);
				}
			}
		}
		
		// 삭제할 인덱스들을 내림차순
		Collections.sort(deleteIndex, Collections.reverseOrder());

		// 검색된 결과가 있는 경우
		if (result.size() != deleteIndex.size()) {
			System.out.println();

			System.out.println("----------------------------------------------------------------------");
			System.out.println(String.format(" %-10s%-5s%-5s%-10s%-15s%-10s ", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
			System.out.println("----------------------------------------------------------------------");
			
			// 검색 키워드가 없는 인덱스 삭제
			for (Integer integer : deleteIndex) {
				result.remove((int) integer);
			}

			// 검색된 결과 출력
			for (Student student : result) {
				System.out.println(student.toString());
			}
			
			System.out.println();
			return result;

		} else {
			// 검색된 결과가 없는 경우
			System.out.println("검색된 결과가 없습니다.");
			return null;
		}

	}

	// 학생 인적사항 정보 수정
	public static void changeStudent(Scanner scanner) {
		
		String input;
		String[] studentInfoArray = new String[6];

		while (true) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("인적사항을 변경할 학생의 학번을 입력해주세요.");
			System.out.println("----------------------------------------------------------------------");

			input = scanner.nextLine();

			try {
				// 인적사항을 변경할 Student 객체
				Student updateStudent = Student.getStudentFromID(Integer.parseInt(input));
				// 변경할 Student 객체가 없는 경우
				if (updateStudent == null) {
					System.out.println("존재 하지 않는 학번입니다. 다시 입력해주세요.");
					continue;
				} else {
					// 변경할 객체가 있는 경우 인적사항 변경
					studentInfoArray = new String[] { String.valueOf(updateStudent.student_id),
							String.valueOf(updateStudent.student_grade), updateStudent.student_name,
							updateStudent.student_major, updateStudent.student_tel, updateStudent.student_state };

					System.out.println("----------------------------------------------------------------------");
					System.out.println(
							String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
					System.out.println(updateStudent.toString());
					System.out.println("----------------------------------------------------------------------");
					System.out.println("인적 사항을 변경 하시겠습니까?(y/n)");

					input = scanner.nextLine();

					if (input.equals("y")) {
						while(true) {
							System.out.println("----------------------------------------------------------------------");
							System.out.println("변경할 항목을 입력해주세요. (항목 : 학번, 학년, 이름, 학과, 전화번호, 학적상태)");
							System.out.println("----------------------------------------------------------------------");
							input = scanner.nextLine();
							
							// 입력 받은 항목 String 을 항목 리스트의 index로 변환
							int index = getListIndex(input, list);
							
							// 학생 인적 사항 수정
							if(update(scanner, index, studentInfoArray, updateStudent)) {
								break;
							}
						}
					} else {
						break;
					}
				}
			} catch (NumberFormatException e) {
				// 학번 입력 시, 문자열을 입력한 경우 예외 처리
				System.out.println("숫자를 입력해주세요.");
				continue;
			}

			// 추가 작업 여부
			System.out.println("----------------------------------------------------------------------");
			System.out.println("추가로 작업하시겠습니까?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			input = scanner.nextLine();
			if (input.equals("y")) {
				continue;
			} else {
				System.out.println("학생 인적사항 수정을 마치고 메인화면으로 돌아갑니다.");
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
			System.out.println("항목이 잘못 입력되었습니다.");
			return false;
		} else if (index == 0) {
			System.out.println("학번은 변경할 수 없습니다.");
			return false;
		} else {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("변경할 " + list[index] + "을(를) 입력해주세요. 현재 " + list[index] + "은(는) "
					+ studentInfoArray[index] + "입니다.");
			System.out.println("----------------------------------------------------------------------");
			switch (index) {
			case 1:
				while (true) {
					input = scanner.nextLine();
					if (StudentVerify.isGrade(input)) {
						student.student_grade = Integer.parseInt(input);
						Print(student);
						break;
					} else {
						System.out.println("학년을 확인 후 다시 입력해주세요. (숫자1자리)");
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
						System.out.println("이름을 확인 후 다시 입력해주세요.");
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
						System.out.println("학과를 확인 후 다시 입력해주세요. (ex. xx학과)");
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
						System.out.println("전화번호를 확인 후 다시 입력해주세요. (ex. 010-xxxx-xxxx)");
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
						System.out.println("학적상태를 확인 후 다시 입력해주세요. (재학, 휴학, 졸업, 자퇴만 입력 가능)");
					}
				}
				break;
			}
			return true;
		}
	}

	public static void Print(Student student) {
		System.out.println("----------------------------------------------------------------------");
		System.out.println(String.format("%-10s%-5s%-5s%-10s%-15s%-10s", "학번", "학년", "이름", "학과", "전화번호", "학적상태"));
		System.out.println(student.toString());
		System.out.println("----------------------------------------------------------------------");
		System.out.println("변경되었습니다.");
	}
}
