package student;

import java.util.Scanner;

public class ScoreManagement {

	// 학생 성적 관리 메뉴
	public static void scoreMenu(Scanner scanner) {

		while (true) {
			System.out.println("------------------------------------------------------------");
			System.out.println("원하는 기능을 선택해주세요.( 1~4 번호를 입력해주세요.)");
			System.out.println("1.성적 입력  2.성적 조회  3.성적 수정   4.이전메뉴");
			System.out.println("------------------------------------------------------------");

			int scoreMenuNum = Integer.parseInt(scanner.nextLine());

			if (scoreMenuNum == 1) {
				registerScore(scanner);
			} else if (scoreMenuNum == 2) {
				readScore(scanner);
			} else if (scoreMenuNum == 3) {
				// changeScore(scanner);
			} else if (scoreMenuNum == 4) {
				break;
			} else {
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	public static void registerScore(Scanner scanner) {

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 입력할 학생의 학번을 입력해주세요.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());
				Student student = Student.getStudentFromID(student_id);
				
				if (student != null) {
					
					System.out.println("------------------------------------------------------------");
					System.out.println("성적을 입력할 과목 코드를 입력해주세요.");
					String code = scanner.nextLine();
					
					if (!student.score.isEmpty()) {
						String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s");
						for (Score inScore : student.score) {
							inScore.toString().contains(code);
						}System.out.println("성적이 이미 입력되어 있습니다.");
					} else {
						System.out.println("해당 과목의 성적을 입력해주세요.");
						String score = scanner.nextLine();
						
						// 수정할 수 있는 성적들의 목록 출력
						for (int i = 0; i < student.score.size(); i++) {
							System.out.println(student.score.get(i).getScoreWithoutID());
						}
						
						//student.score = score;
					}
				} else {
					System.out.println("해당 학생이 존재하지 않습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("학번을 확인후 다시 입력해주세요.");
			}
		}

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
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "학번", "과목 코드", "과목명", "구분",
								"담당교수", "성적", "변동 사유"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentToRead.score) {
							System.out.println(grade.toString());
							// 20160506 C051 사회복지행정론 이은아 전선 C 없음
						}
					} else {
						System.out.println("조회할 성적이 없습니다.");
					}
				} else {
					System.out.println("해당 학생이 존재하지 않습니다.");
				}
				System.out.println("----------------------------------------------------------------------");
				System.out.println("다른 학생을 조회하시겠습니까?(y/n)");
				System.out.println("----------------------------------------------------------------------");

				restart = scanner.nextLine().equals("y") ? true : false;
			} catch (NumberFormatException e) {
				System.out.println("학번 8자리 숫자를 입력해주세요.");
			}
		}

	}

	public static void changeScore() {
	}

}
