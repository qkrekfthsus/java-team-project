package student;

import java.util.regex.Pattern;

public class StudentVerify {
	public static String[] stateArray = { "ÀçÇĞ", "Á¹¾÷", "ÈŞÇĞ", "ÀÚÅğ" };

	// À¯È¿¼º°Ë»ç
	public static boolean isId(String str) {
		return Pattern.matches("^\\d{8}$", str);
	}

	public static boolean isGrade(String str) {
		return Pattern.matches("^\\d{1}$", str);
	}

	public static boolean isName(String str) {
		return Pattern.matches("^[a-zA-Z]|[¤¡-¤¾°¡-ÆR]*$", str);
	}

	public static boolean isMajor(String str) {
		return Pattern.matches("^([°¡-ÆR]*)ÇĞ°ú$", str);
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

	public static boolean isOverlabID(String str) {
		if (Student.getStudentFromID(Integer.parseInt(str)) != null) {
			return false;
		}
		return true;
	}

	public static boolean isOverlabTel(String str) {
		if (Student.getStudentFromTel(str) != null) {
			return false;
		}
		return true;
	}
}
