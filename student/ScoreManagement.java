package student;

import java.util.ArrayList;
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

		String[] studentScoreInfo = new String[7];
		ArrayList<Score> score = new ArrayList<>();

		boolean restart = true;
		while (restart) {
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
					//과목정보 받아오는게 안됨
					Subject subject = Subject.getFromcode(code);
					System.out.println(subject.toString());
					
					//if (subject != null) {
						
						String alreadyin = "";
						for (Score inScore : student.score) {
							alreadyin += inScore.toString();
						}
						if (alreadyin.contains(code) == true) {
							System.out.println("성적이 이미 입력되어 있어 이전 메뉴로 돌아갑니다.");
							break;
						} else {
							System.out.println("해당 과목의 성적을 입력해주세요.");
							String getscore = scanner.nextLine();

							String[] subinfo = subject.toString().split("\t");
							studentScoreInfo[0] = Integer.toString(student_id);
							for (int i = 1; i < subinfo.length; i++) {
								studentScoreInfo[i] = subinfo[i];
							}
							studentScoreInfo[5] = getscore;
							studentScoreInfo[6] = "없음";

							Score updatescore = new Score(studentScoreInfo);
							score.add(updatescore);
						}
					}//else {
						//System.out.println("해당 과목코드는 존재하지 않습니다. 확인 후 다시 입력해주세요.");
						//continue;
					//}
				//}

				else {
					System.out.println("해당 학생이 존재하지 않습니다.");
				}

				System.out.println("----------------------------------------------------------------------");
				System.out.println("성적 등록을 계속 하시겠습니까?(y/n)");
				System.out.println("----------------------------------------------------------------------");

				restart = scanner.nextLine().equals("y") ? true : false;
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
