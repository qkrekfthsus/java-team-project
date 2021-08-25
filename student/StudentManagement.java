package student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManagement {

	static Scanner sc = new Scanner(System.in);
	//static ArrayList<Student> studentArray = new ArrayList<>();
	static String[] studentInfo = new String[6];

	// ÀÌÈÄ ÀÛ¾÷ ¿©ºÎ ¹¯´Â ÇÔ¼ö
	public static void registerQ() {

		System.out.println("==============================================");
		System.out.println("ÇĞ»ı µî·ÏÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù. °è¼Ó ÀÛ¾÷ÇÏ½Ã°Ú½À´Ï±î? (y/n)");

		if (sc.nextLine().equals("y")) {
			// ÇĞ»ı µî·Ï ÇÔ¼ö È£Ãâ
			registerStudent();
		} else {
			// ¸ŞÀÎ¸Ş´º·Î µ¹¾Æ°¡±â
			System.out.println("ÇĞ»ı µî·ÏÀ» Á¾·áÇÏ°í ¸ŞÀÎ ¸Ş´º·Î µ¹¾Æ°©´Ï´Ù.");
			System.out.println("==============================================");
			System.out.println();
			Menu.selectMenu();
		}

	}


	// ÇĞ»ı µî·Ï ÇÔ¼ö
	public static void registerStudent() {

		System.out.println("*»õ·Î¿î ÇĞ»ı Á¤º¸¸¦ µî·ÏÇÕ´Ï´Ù. (»óÅÂ ±âº»°ªÀº ÀçÇĞÀ¸·Î µî·ÏµÊ)");
		registerId();
	}
	
	// ÀÔ·ÂÇÑ °ªÀÌ ¸Â´ÂÁö È®ÀÎ
	public static void infoQ() {
		
		for (int i = 0; i < studentInfo.length; i++) {
			System.out.print(studentInfo[i] + " ");
		}
		System.out.println();
		System.out.println("µî·ÏÇÏ½Ç Á¤º¸°¡ ¸Â½À´Ï±î? (y/n)");
		if (sc.nextLine().equals("y")) {
			// Student °´Ã¼ »ı¼ºÇÏ¿© ArrayList¿¡ Ãß°¡
			Student student = new Student(studentInfo);
			FileManager.studentArray.add(student);

			// ÀÌÈÄ ÀÛ¾÷¿©ºÎ ¹¯´Â ÇÔ¼ö È£Ãâ
			registerQ();
		} else {
			System.out.println("ÀçÀÔ·ÂÇÒ Ç×¸ñ¸íÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			String info = sc.nextLine();
			if (info.equals("ÇĞ¹ø")) {
				registerId();
				infoQ();
			} else if (info.equals("ÇĞ³â")) {
				registerGrade();
				infoQ();
			} else if (info.equals("ÀÌ¸§")) {
				registerName();
				infoQ();
			} else if (info.equals("ÇĞ°ú")) {
				registerMajor();
				infoQ();
			} else if (info.equals("ÀüÈ­¹øÈ£")) {
				registerTel();
				infoQ();
			}
		}
	}

	// ÇĞ¹øÀÔ·Â
	public static void registerId() {
		System.out.println("----------------------------------------------");
		System.out.println("µî·ÏÇÒ ÇĞ»ıÀÇ ÇĞ¹øÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. (¼ıÀÚ8ÀÚ¸®)");
		while (true) {
			String id = sc.nextLine();
			if (isId(id) == true) {
				studentInfo[0] = id;
				registerGrade();
				break;
			} else {
				System.out.println("ÇĞ¹øÀ» È®ÀÎ ÈÄ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä. (¼ıÀÚ8ÀÚ¸®)");
				continue;
			}
		}

	}

	// ÇĞ³âÀÔ·Â
	public static void registerGrade() {
		System.out.println("----------------------------------------------");
		System.out.println("µî·ÏÇÒ ÇĞ»ıÀÇ ÇĞ³âÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä. (¼ıÀÚ1ÀÚ¸®)");
		while (true) {
			String grade = sc.nextLine();
			if (isGrade(grade) == true) {
				studentInfo[1] = grade;
				registerName();
				break;
			} else {
				System.out.println("ÇĞ³âÀ» È®ÀÎ ÈÄ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä. (¼ıÀÚ1ÀÚ¸®)");
				continue;
			}
		}

	}

	// ÀÌ¸§ÀÔ·Â
	public static void registerName() {
		System.out.println("----------------------------------------------");
		System.out.println("µî·ÏÇÒ ÇĞ»ıÀÇ ÀÌ¸§À» ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		while (true) {
			String name = sc.nextLine();
			if (isName(name) == true) {
				studentInfo[2] = name;
				registerMajor();
				break;
			} else {
				System.out.println("ÀÌ¸§À» È®ÀÎ ÈÄ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				continue;
			}
		}

	}

	// ÇĞ°úÀÔ·Â
	public static void registerMajor() {
		System.out.println("----------------------------------------------");
		System.out.println("µî·ÏÇÒ ÇĞ»ıÀÇ ÇĞ°ú¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. (ex. xxÇĞ°ú)");
		while (true) {
			String major = sc.nextLine();
			if (isMajor(major) == true) {
				studentInfo[3] = major;
				registerTel();
				break;
			} else {
				System.out.println("ÇĞ°ú¸¦ È®ÀÎ ÈÄ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä. (ex. xxÇĞ°ú)");
				continue;
			}
		}

	}

	// ÀüÈ­¹øÈ£ÀÔ·Â
	public static void registerTel() {
		System.out.println("----------------------------------------------");
		System.out.println("µî·ÏÇÒ ÇĞ»ıÀÇ ÀüÈ­¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä. (¹øÈ£¸¸ ÀÔ·ÂÇØÁÖ¼¼¿ä.)");
		while (true) {
			String tel = sc.nextLine();
			if (isMob(tel) == true) {
				studentInfo[4] = tel;
				studentInfo[5] = "ÀçÇĞ";
				infoQ();
				break;
			} else {
				System.out.println("ÀüÈ­¹øÈ£¸¦ È®ÀÎ ÈÄ ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä. (¹øÈ£¸¸ ÀÔ·ÂÇØÁÖ¼¼¿ä.)");
				continue;
			}
		}

	}

	// À¯È¿¼º°Ë»ç
	public static boolean isId(String str) {
		return Pattern.matches("^\\d{8}$", str);
	}

	public static boolean isGrade(String str) {
		return Pattern.matches("^\\d{1}$", str);
	}

	public static boolean isName(String str) {
		return Pattern.matches("^[a-zA-Z]*$|^[¤¡-¤¾°¡-ÆR]*$", str);
	}

	public static boolean isMajor(String str) {
		return Pattern.matches("^([°¡-ÆR]*)ÇĞ°ú$", str);
	}

	public static boolean isMob(String str) {
		return Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}$", str);
	}

///////////////////////////////////////////////////////////////////////////////////

	public static void searchStudent() {

	}

	public static void changeStudent() {

	}

}
