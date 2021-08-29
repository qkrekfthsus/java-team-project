package student;

import java.util.regex.Pattern;

// À¯È¿¼º °Ë»ç Å¬·¡½º
public class InformationVerify {
	public static String[] stateArray = { "ÀçÇÐ", "Á¹¾÷", "ÈÞÇÐ", "ÀÚÅð" };
	public static String[] scoreArray = {"A", "B", "C", "F"};
	
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
		return Pattern.matches("^([°¡-ÆR]*)ÇÐ°ú$", str);
	}

	public static boolean isMob(String str) {
		return Pattern.matches("^\\d{3}-\\d{3,4}-\\d{4}$", str);
	}

	public static boolean isState(String str) {
		for (String state : stateArray) {
			if (str.equals(state)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isScore(String str) {
		for (String score : scoreArray) {
			if (str.equals(score)) {
				return true;
			}
		}
		return false;
	}

	// ÇÐ¹ø Áßº¹ Ã¼Å©
	public static boolean isOverlabID(String str) {
		if (Student.getStudentFromID(Integer.parseInt(str)) != null) {
			return false;
		}
		return true;
	}
	
	// ÀüÈ­ ¹øÈ£ Áßº¹ Ã¼Å©
	public static boolean isOverlabTel(String str) {
		if (Student.getStudentFromTel(str) != null) {
			return false;
		}
		return true;
	}
}
