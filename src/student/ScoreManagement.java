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
            System.out.println("������ ������ �л��� �й��� �Է����ּ���. (ó������ ���ư���(n))");
            System.out.println("====================================================");
            String IDinput = scanner.nextLine();
            if(IDinput.equals("n")) {
               StudentManagement.gradeManagement();
            }
            
            else {
               updateScore = Student.getStudentFromID(Integer.parseInt(IDinput));
               if(updateScore==null) {
                  System.out.println("====================================================");
                  System.out.println("���� �й��Դϴ�. �ٽ� �Է����ּ���.");
                  System.out.println("====================================================");
                  continue;
               }
               //�Էµ� �й��� �������� ���
               System.out.println("====================================================");
               System.out.println(String.format("%-10s%-10s%-9s%-5s%-5s%-5s", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
               for(int i = 0; i < updateScore.score.size(); i++) {
                   if(IDinput.equals(String.valueOf(updateScore.score.get(i).student_id))) {            	                  	   
                	   System.out.println(String.format("%-10s%-10s%-9s%-5s%-5s%-5s", updateScore.score.get(i).subject_code, 
                			   updateScore.score.get(i).subject_name, updateScore.score.get(i).type, updateScore.score.get(i).professor,
                			   updateScore.score.get(i).grade , updateScore.score.get(i).reason));  	  
                   }
                }
               
               
               System.out.println("====================================================");
               
               System.out.println("====================================================");
               System.out.println("������ ������ �����ڵ带 �Է����ּ���. (ó������ ���ư���(n))");
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
                     System.out.println("���� �����ڵ��Դϴ�. �ٽ� �Է����ּ���.");
                     System.out.println("====================================================");
                     continue;
                  }
                  System.out.println("====================================================");
                  System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
                  System.out.println(update.toString()); 
                  System.out.println("������ ���� �Ͻðڽ��ϱ�?(y/n)");
                  System.out.println("====================================================");
                 
                  
                  input = scanner.nextLine();
                  if(input.equals("y")) {
                      System.out.println("====================================================");
                      System.out.println("������ ������ �Է����ּ���.");
                      System.out.println("====================================================");
                      input = scanner.nextLine();
                      update.grade = input;
                     
                      System.out.println("====================================================");
                      System.out.println("��������� �Է����ּ���");
                      System.out.println("====================================================");
                 
                      input = scanner.nextLine();
                      update.reason = input;
                      System.out.println("====================================================");
                      System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
                      System.out.println(update.toString());
                      System.out.println("�����Ǿ����ϴ�.");
                      System.out.println("====================================================");
                      
                      
                      System.out.println("�߰��� �����Ͻðڽ��ϱ�?(y/n)");
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
           System.out.println("���ڸ� �Է����ּ���. �й��� 8�ڸ� �����Դϴ�.");
        }
      }
         
   }
   
   public static void GradeChange(Score updateScore) {
      System.out.println("====================================================");
      System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
      System.out.println(updateScore.toString());
      System.out.println("������ �����Ͻðڽ��ϱ�?(y/n)");
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
      System.out.println(String.format("%-17s%-10s%-10s%-9s%-5s%-5s%-5s", "�й�", "�����ڵ�", "��������", "�����̸�", "����", "����","�������"));
      System.out.println(updateScore.toString());
      System.out.println("====================================================");
   }
   
   
   
}