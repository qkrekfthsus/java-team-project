package student;

import java.util.ArrayList;
import java.util.Collections;
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
				overlap(id);
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
				overlap(tel);
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
	
	public static String overlap(String str) {
		String a = str;
		for (int i = 0; i < FileManager.studentArray.size(); i++) {
			String existValue = FileManager.studentArray.get(i).toString();
			if(existValue.contains(" "+a+" ")) {
				a = "Áßº¹µÈ Á¤º¸ÀÔ´Ï´Ù. È®ÀÎ ÈÄ ´Ù½Ã ÀÔ·ÂÇØ ÁÖ½Ê½Ã¿À.";
			}
		}
		return a;
	}

///////////////////////////////////////////////////////////////////////////////////

	public static void searchStudent() {
		Scanner scanner = new Scanner(System.in);
		
		boolean resetSearch = true;
		while(resetSearch) {
			System.out.println(" * ÇĞ»ı Á¤º¸ °Ë»ö");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" °Ë»öÇÒ ÇĞ»ı¿¡ ´ëÇÑ Á¤º¸¸¦ ¶ç¾î¾²±â·Î ±¸ºĞÇØ¼­ ÀÔ·ÂÇØÁÖ¼¼¿ä.(ex. ±èÃ¶¼ö ÄÄÇ»ÅÍ°øÇĞ°ú 1)");
			System.out.println(" Á¤º¸´Â Ç×¸ñº°·Î ÇÏ³ª¾¿¸¸ ÀÔ·Â°¡´ÉÇÕ´Ï´Ù.(Ç×¸ñ : ÇĞ¹ø, ÇĞ³â, ÀÌ¸§, ÇĞ°ú, ÀüÈ­¹øÈ£, ÇĞÀû»óÅÂ)");
			System.out.println("----------------------------------------------------------------------");
			
			ArrayList<Student> result = new ArrayList<>();
			result.addAll(FileManager.studentArray);
			
			result = getSearchResult(scanner, true, result);
			
			boolean moreSearch = true;
			
			while(moreSearch && result != null) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println(" »ó¼¼ °Ë»öÀ» ÇÏ½Ã°Ú½À´Ï±î?(y/n)");
				System.out.println("----------------------------------------------------------------------");
				moreSearch = scanner.nextLine().equals("y") ? true : false;
				if(!moreSearch) {
					break;
				}
				result = getSearchResult(scanner, false, result);
			}
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" ´Ù½Ã °Ë»öÇÏ½Ã°Ú½À´Ï±î?(y/n)");
			System.out.println("----------------------------------------------------------------------");
			resetSearch = scanner.nextLine().equals("y") ? true : false;

		}
		System.out.println("¸ŞÀÎ È­¸éÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
	}
	
	public static void changeStudent() {
		
	}
	
	public static void gradeManagement() {
		
	}
	
	// °Ë»ö °á°ú¸¦ Ãâ·Â
	public static ArrayList<Student> printSearchResult(Scanner scanner, ArrayList<Student> result, ArrayList<Integer> deleteIndex) {
		if(result.size() != deleteIndex.size()) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println(String.format(" %-10s%-5s%-5s%-10s%-15s%-10s ", "ÇĞ¹ø", "ÇĞ³â", "ÀÌ¸§", "ÇĞ°ú", "ÀüÈ­¹øÈ£", "ÇĞÀû»óÅÂ"));
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
			System.out.println("°Ë»öµÈ °á°ú°¡ ¾ø½À´Ï´Ù.");
			return null;
		}
	}
	
	// °Ë»ö Å°¿öµå¸¦ ÀÔ·Â ¹Ş°í, °Ë»öµÈ °á°ú¸¦ ¸®ÅÏ
	public static ArrayList<Student> getSearchResult(Scanner scanner, boolean isFirst, ArrayList<Student> result) {
		// Ã³À½ °Ë»öÀÎÁö, Ãß°¡ °Ë»öÀÎÁö È®ÀÎ
		if(!isFirst) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println(" »ó¼¼ °Ë»öÇÒ ³»¿ëÀ» ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			System.out.println("----------------------------------------------------------------------");
		}
		
		
		// °Ë»öÇÒ Å°¿öµå ÀÔ·Â ¹ŞÀ½
		String[] searchKeywords = scanner.nextLine().split(" ");
		
		System.out.println(searchKeywords[0].equals("")); // °Ë»ö Å°¿öµå °ø¹é ÀÔ·Â ³ªÁß¿¡ Ãß°¡
		// »èÁ¦ÇÒ ÀÎµ¦½º ArrayList
		ArrayList<Integer> deleteIndex = new ArrayList<>();
		
		// ÀüÃ¼ ÇĞ»ıÀÌ ´ã±ä result ¹è¿­À» ¼øÈ¸ÇÏ¸é¼­
		// Student.toString()ÇÔ¼ö·Î Ãâ·ÂµÈ 
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

}
