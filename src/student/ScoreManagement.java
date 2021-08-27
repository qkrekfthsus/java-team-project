package student;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManagement {
   static Scanner scanner = new Scanner(System.in);
   static String input;
   
   public static void ChangeScore(){
      ArrayList<Score> scoreArray = new ArrayList<>();
      scoreArray.addAll(FileManager.scoreArray);
      Student updateScore;
      while(true) {
        try {
            System.out.println("====================================================");
            System.out.println("성적을 수정할 학생의 학번을 입력해주세요. (처음으로 돌아가기(n))");
            System.out.println("====================================================");
            String IDinput = scanner.nextLine();
            if(IDinput.equals("n")) {
               StudentManagement.gradeManagement();
            }
            
            else {
               updateScore = Student.getStudentFromID(Integer.parseInt(IDinput));
               if(updateScore==null) {
                  System.out.println("====================================================");
                  System.out.println("없는 학번입니다. 다시 입력해주세요.");
                  System.out.println("====================================================");
                  continue;
               }
               //입력된 학번의 수강과목 출력
               System.out.println("====================================================");
               System.out.println(String.format("%-10s%-10s%-9s%-5s%-5s%-5s", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
               for(int i = 0; i < updateScore.score.size(); i++) {
                   if(IDinput.equals(String.valueOf(updateScore.score.get(i).student_id))) {            	                  	   
                	   System.out.println(String.format("%-10s%-10s%-9s%-5s%-5s%-5s", updateScore.score.get(i).subject_code, 
                			   updateScore.score.get(i).subject_name, updateScore.score.get(i).type, updateScore.score.get(i).professor,
                			   updateScore.score.get(i).grade , updateScore.score.get(i).reason));  	  
                   }
                }
               
               
               System.out.println("====================================================");
               
               System.out.println("====================================================");
               System.out.println("성적을 수정할 과목코드를 입력해주세요. (처음으로 돌아가기(n))");
               System.out.println("====================================================");
               String Code = scanner.nextLine();
               if(Code.equals("n")) {
                  StudentManagement.gradeManagement();
                  break;
               }
               else {
                  Score update = null;
                  for(int i = 0; i < updateScore.score.size(); i++) {
                     if(Code.equals(String.valueOf(updateScore.score.get(i).subject_code))) {
                        update = updateScore.score.get(i);
                     }
                  }
                  //System.out.println(update.toString());   
               
                  if(update==null) {
                     System.out.println("====================================================");
                     System.out.println("없는 과목코드입니다. 다시 입력해주세요.");
                     System.out.println("====================================================");
                     continue;
                  }
                  System.out.println("====================================================");
                  System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
                  System.out.println(update.toString()); 
                  System.out.println("성적을 변경 하시겠습니까?(y/n)");
                  System.out.println("====================================================");
                 
                  
                  input = scanner.nextLine();
                  if(input.equals("y")) {
                      System.out.println("====================================================");
                      System.out.println("변경할 성적을 입력해주세요.");
                      System.out.println("====================================================");
                      input = scanner.nextLine();
                      update.grade = input;
                     
                      System.out.println("====================================================");
                      System.out.println("변경사유를 입력해주세요");
                      System.out.println("====================================================");
                 
                      input = scanner.nextLine();
                      update.reason = input;
                      System.out.println("====================================================");
                      System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
                      System.out.println(update.toString());
                      System.out.println("수정되었습니다.");
                      System.out.println("====================================================");
                      
                      
                      System.out.println("추가로 수정하시겠습니까?(y/n)");
                      input = scanner.nextLine();
                      if(input.equals("y")) {
                    	  ScoreManagement.ChangeScore();
                      }
                      else {
                    	  StudentManagement.gradeManagement();
                      }
                   }
               }
            
            }
        }
        catch(NumberFormatException e) {
           System.out.println("숫자를 입력해주세요. 학번은 8자리 숫자입니다.");
        }
      }
         
   }
   
   public static void GradeChange(Score updateScore) {
      System.out.println("====================================================");
      System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
      System.out.println(updateScore.toString());
      System.out.println("성적을 변경하시겠습니까?(y/n)");
      System.out.println("====================================================");
   }
   
   public static void Change(String input,Score updateScore) {
      updateScore.grade = input;
   }
   
   public static void Reason(String input,Score updateScore) {
      updateScore.reason = input;
   }
   
   public static void Print(Score updateScore) {
      System.out.println("====================================================");
      System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "학번", "과목코드", "수강과목", "강사이름", "구분", "성적","변경사유"));
      System.out.println(updateScore.toString());
      System.out.println("====================================================");
   }
   
   
   
}