package student;

import java.util.Scanner;

public class ScoreManagement {

	// 학생 성적 관리 메뉴
	public static void scoreMenu(Scanner scanner) {

		while (true) {
			try {
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
					changeScore(scanner);
				} else if (scoreMenuNum == 4) {
					break;
				} else {
					System.out.println("다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("값을 잘못 입력하셨습니다. 1~4 사이의 숫자를 입력해주세요.");
			}
		}

	}

	// 학생 성적 등록
	public static void registerScore(Scanner scanner) {

		String[] studentScoreInfo = new String[7];

		boolean restart = true;
		while (restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 입력할 학생의 학번을 입력해주세요.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());
				Student student = Student.getStudentFromID(student_id);
				
				// 입력된 학번의 학생이 존재하는 경우 
				if (student != null) {

					System.out.println("------------------------------------------------------------");
					System.out.println("성적을 입력할 과목 코드를 입력해주세요.");
					System.out.println("------------------------------------------------------------");

					String code = scanner.nextLine();
					Subject subject = Subject.getFromcode(code);
					
					// 입력된 과목코드가 과목 목록에 존재하는 경우
					if (subject != null) {
						boolean alreadyin = false;
						//String alreadyin = "";
						
						for (Score inScore : student.score) {
							if(inScore.subject_code.equals(code)) {
								alreadyin = true;
								break;
							}
							//alreadyin += inScore.toString();
						}
						
						if (alreadyin) {
							System.out.println(subject.toString() + " 성적이 이미 입력되어 있어 이전 메뉴로 돌아갑니다.");
							break;
						} else {
							System.out.println("------------------------------------------------------------");
							System.out.println(subject.toString() + " 과목의 성적을 입력해주세요.");
							System.out.println("------------------------------------------------------------");
							String getscore = scanner.nextLine();
							
							while(true) {
								if (InformationVerify.isScore(getscore)) {
									String[] subinfo = subject.toString().split(" ");
									studentScoreInfo[0] = Integer.toString(student_id);
									for (int i = 1; i < subinfo.length + 1; i++) {
										studentScoreInfo[i] = subinfo[i - 1];
									}
									studentScoreInfo[5] = getscore;
									studentScoreInfo[6] = "없음";
									break;
								}
								else {
									System.out.println("성적 형식이 맞지 않습니다. 성적을 다시 입력해주세요.(입력 가능 항목 : A, B, C, F)");
									getscore = scanner.nextLine();
								}
							}
							

							for (int i = 0; i < studentScoreInfo.length - 1; i++) {
								System.out.print(studentScoreInfo[i] + " ");
							}

							System.out.println();
							System.out.println("------------------------------------------------------------");
							System.out.println("해당 성적을 입력하시겠습니까? (y/n)");
							System.out.println("------------------------------------------------------------");

							String Q = scanner.nextLine();
							if (Q.equals("y")) {
								Score updatescore = new Score(studentScoreInfo);
								student.score.add(updatescore);
								System.out.println("성적이 정상적으로 입력되었습니다.");
							} else {
								System.out.println("성적입력이 취소되어 처음부터 재입력합니다.");
								continue;
							}

						}

					} else {
						System.out.println("해당 과목코드는 존재하지 않습니다. 확인 후 다시 입력해주세요.");
					}
				} else {
					System.out.println("해당 학생이 존재하지 않습니다.");
				}

				System.out.println("------------------------------------------------------------");
				System.out.println("성적 등록을 계속 하시겠습니까?(y/n)");
				System.out.println("------------------------------------------------------------");

				restart = scanner.nextLine().equals("y") ? true : false;
			} catch (NumberFormatException e) {
				System.out.println("학번을 확인후 다시 입력해주세요.");
			}
		}

	}

	// 학생 성적 조회
	public static void readScore(Scanner scanner) {
		boolean restart = true;

		while (restart) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 조회할 학생의 학번을 입력해주세요.");
				System.out.println("------------------------------------------------------------");

				int student_id = Integer.parseInt(scanner.nextLine());

				// 학번을 통해 해당 학생의 성적 조회
				Student studentToRead = Student.getStudentFromID(student_id);

				// 학생 리스트에 있는 학생의 학번을 입력한 경우
				if (studentToRead != null) {
					// 학생의 성적이 존재하는 경우 성적 출력
					if (!studentToRead.score.isEmpty()) {
						System.out.println();
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-7s%-15s%-5s%-5s%-3s%-10s", "과목 코드", "과목명", "구분",
								"담당교수", "성적", "변동 사유"));
						System.out.println("----------------------------------------------------------------------");

						for (Score grade : studentToRead.score) {
							System.out.println(grade.getScoreWithoutID());

						}
					} else {
						// 학생의 성적이 존재하지 않는 경우
						System.out.println("조회할 성적이 없습니다.");
					}

				} else {
					// 학생 리스트에 없는 학번을 입력한 경우
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

			} catch (NumberFormatException e) {
				// 학번을 입력 받을 때, 숫자가 아닌 문자열을 받았을 경우 예외 처리
				System.out.println("학번 8자리 숫자를 입력해주세요.");
			}
		}

	}

	// 학생 성적 정보 수정
	public static void changeScore(Scanner scanner) {
		Student changeScoreStudent;
		String input;

		while (true) {
			try {
				System.out.println("------------------------------------------------------------");
				System.out.println("성적을 수정할 학생의 학번을 입력해주세요.");
				System.out.println("------------------------------------------------------------");
				String inputID = scanner.nextLine();

				if (inputID.equals("n")) {
					break;
				} else {
					// 입력한 학번으로 학생 객체를 찾음
					changeScoreStudent = Student.getStudentFromID(Integer.parseInt(inputID));

					// 학생 객체가 없다면 다시 처음으로 돌아감
					if (changeScoreStudent == null) {
						System.out.println("------------------------------------------------------------");
						System.out.println("없는 학번입니다. 다시 입력해주세요.");
						System.out.println("------------------------------------------------------------");
						continue;
					}

					System.out.println("------------------------------------------------------------");
					System.out.println(
							String.format("%-7s%-15s%-5s%-5s%-3s%-10s", "과목 코드", "과목명", "구분", "담당교수", "성적", "변동 사유"));
					System.out.println("------------------------------------------------------------");

					// 수정할 수 있는 성적들의 목록 출력
					for (int i = 0; i < changeScoreStudent.score.size(); i++) {
						System.out.println(changeScoreStudent.score.get(i).getScoreWithoutID());
					}

					System.out.println("------------------------------------------------------------");
					System.out.println("성적을 수정할 과목코드를 입력해주세요. (처음으로 돌아가기(n))");
					System.out.println("------------------------------------------------------------");
					String inuputCode = scanner.nextLine();
					if (inuputCode.equals("n")) {
						break;
					} else {
						// 찾은 학생 객체의 성적 ArrayList에서 입력한 과목 코드가 있는 성적 객체를 찾음
						Score scoreUpdate = null;
						for (int i = 0; i < changeScoreStudent.score.size(); i++) {
							if (inuputCode.equals(String.valueOf(changeScoreStudent.score.get(i).subject_code))) {
								scoreUpdate = changeScoreStudent.score.get(i);
								break;
							}
						}

						// 입력 받은 과목코드를 찾지 못한 경우
						if (scoreUpdate == null) {
							System.out.println("------------------------------------------------------------");
							System.out.println("없는 과목코드입니다. 다시 입력해주세요.");
							System.out.println("------------------------------------------------------------");
							continue;
						}

						// 과목 코드를 찾은 경우 성적 변경 진행
						System.out.println("----------------------------------------------------------------------");
						System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "학번", "과목 코드", "과목명", "구분",
								"담당교수", "성적", "변동 사유"));
						System.out.println(scoreUpdate.toString());

						System.out.println("성적을 변경 하시겠습니까?(y/n)");
						System.out.println("----------------------------------------------------------------------");
						input = scanner.nextLine();
						if (input.equals("y")) {
							System.out.println("------------------------------------------------------------");
							System.out.println("변경할 성적을 입력해주세요.");
							System.out.println("------------------------------------------------------------");
							input = scanner.nextLine();
							
							while(true) {
								if(InformationVerify.isScore(input)) {
									scoreUpdate.score = input;
									break;
								}
								else {
									System.out.println("성적 형식이 맞지 않습니다. 성적을 다시 입력해주세요.(입력 가능 항목 : A, B, C, F)");
									input = scanner.nextLine();
								}
							}
							
							System.out.println("------------------------------------------------------------");
							System.out.println("변경사유를 입력해주세요");
							System.out.println("------------------------------------------------------------");

							input = scanner.nextLine();
							scoreUpdate.reason = input;
							System.out
									.println("----------------------------------------------------------------------");
							System.out.println(String.format("%-10s%-7s%-15s%-5s%-5s%-3s%-10s", "학번", "과목 코드", "과목명",
									"구분", "담당교수", "성적", "변동 사유"));
							System.out.println(scoreUpdate.toString());
							System.out.println("수정되었습니다.");
							System.out
									.println("----------------------------------------------------------------------");

							System.out.println("------------------------------------------------------------");
							System.out.println("성적을 추가로 수정하시겠습니까?(y/n)");
							System.out.println("------------------------------------------------------------");

							input = scanner.nextLine();
							if (!input.equals("y")) {
								break;
							}

						}
					}

				}

			} catch (NumberFormatException e) {
				// 학번을 입력 받을 때, 문자열인 경우 예외 처리
				System.out.println("숫자를 입력해주세요. 학번은 8자리 숫자입니다.");
			}
		}

	}

}
