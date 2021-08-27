package student;

import java.util.Scanner;

public class ScoreManagement {

	public static void scoreMenu(Scanner scanner) {

		while (true) {
			System.out.println("------------------------------------------------------------");
			System.out.println("원하는 기능을 선택해주세요.( 1~4 번호를 입력해주세요.)");
			System.out.println("1.성적 입력  2.성적 조회  3.성적 수정   4.이전메뉴");
			System.out.println("------------------------------------------------------------");

			int scoreMenuNum = Integer.parseInt(scanner.nextLine());

			if (scoreMenuNum == 1) {
				registerScore();
			} else if (scoreMenuNum == 2) {
				readScore(scanner);
			} else if (scoreMenuNum == 3) {
				changeScore(scanner);
			} else if (scoreMenuNum == 4) {
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	public static void registerScore() {
		System.out.println("성적을 입력할 학생의 학번을 입력해주세요.");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.학생 등록  2.학생 정보 조회  3.학생 정보 수정 4.성적 관리  5.종료");
	}

	public static void readScore(Scanner scanner) {
		boolean restart = true;
		while (restart) {

			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 조회할 학생의 학번을 입력해주세요.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());

				Student studentToRead = Student.getStudentFromID(student_id);

				if (studentToRead != null) {
					if (!studentToRead.score.isEmpty()) {
						System.out.println();
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "학번", "과목 코드", "과목명", "구분",
								"담당교수", "성적", "변동 사유"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentToRead.score) {
							System.out.println(grade.toString());

						}
					} else {
						System.out.println("조회할 성적이 없습니다.");
					}
				} else {
					System.out.println("해당 학생이 존재하지 않습니다.");
				}
				System.out.println();
				System.out.println("------------------------------------------------------------");
				System.out.println("다른 학생을 조회하시겠습니까?(y/n)");
				System.out.println("------------------------------------------------------------");

				if (scanner.nextLine().equals("y")) {
					restart = true;
				} else {
					System.out.println("성적 조회를 마치고 성적 관리 메뉴로 돌아갑니다.");
					restart = false;
				}

				// restart = scanner.nextLine().equals("y") ? true : false;
			} catch (NumberFormatException e) {
				System.out.println("학번 8자리 숫자를 입력해주세요.");
			}
		}

	}

	// 성적 수정하기 전 정보 출력 해야됨
	public static void changeScore(Scanner scanner) {
		Student changeScoreStudent;
		String input;

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 수정할 학생의 학번을 입력해주세요.");
				System.out.println("------------------------------------------------------------");
				String inputID = scanner.nextLine();

				changeScoreStudent = Student.getStudentFromID(Integer.parseInt(inputID));
				if (changeScoreStudent == null) {
					System.out.println("------------------------------------------------------------");
					System.out.println("없는 학번입니다. 다시 입력해주세요.");
					System.out.println("------------------------------------------------------------");
					continue;
				}

				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 수정할 과목코드를 입력해주세요. (처음으로 돌아가기(n))");
				System.out.println("------------------------------------------------------------");
				String inuputCode = scanner.nextLine();
				if (inuputCode.equals("n")) {
					break;
				} else {
					Score scoreUpdate = null;
					for (int i = 0; i < changeScoreStudent.score.size(); i++) {
						if (inuputCode.equals(String.valueOf(changeScoreStudent.score.get(i).subject_code))) {
							scoreUpdate = changeScoreStudent.score.get(i);
						}
					}
					// System.out.println(scoreUpdate.toString());

					if (scoreUpdate == null) {
						System.out.println("------------------------------------------------------------");
						System.out.println("없는 과목코드입니다. 다시 입력해주세요.");
						System.out.println("------------------------------------------------------------");
						continue;
					}
					System.out.println("----------------------------------------------------------------------");
					System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름",
							"구분", "성적", "변경사유"));
					System.out.println(scoreUpdate.toString());
					System.out.println("성적을 변경 하시겠습니까?(y/n)");
					System.out.println("----------------------------------------------------------------------");

					input = scanner.nextLine();
					if (input.equals("y")) {
						System.out.println("------------------------------------------------------------");
						System.out.println("변경할 성적을 입력해주세요.");
						System.out.println("------------------------------------------------------------");
						input = scanner.nextLine();
						scoreUpdate.score = input;

						System.out.println("------------------------------------------------------------");
						System.out.println("변경사유를 입력해주세요");
						System.out.println("------------------------------------------------------------");

						input = scanner.nextLine();
						scoreUpdate.reason = input;
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목",
								"강사이름", "구분", "성적", "변경사유"));
						System.out.println(scoreUpdate.toString());
						System.out.println("수정되었습니다.");
						System.out.println("----------------------------------------------------------------------");

						input = scanner.nextLine();

					}
				}

			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요. 학번은 8자리 숫자입니다.");
			}
		}

	}

}
