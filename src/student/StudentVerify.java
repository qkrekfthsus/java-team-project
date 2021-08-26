package student;

import java.util.regex.Pattern;

public class StudentVerify {
	public static String[] stateArray = {"����", "����", "����", "����"};
	// ��ȿ���˻�
	public static boolean isId(String str) {
		return Pattern.matches("^\\d{8}$", str);
	}

	public static boolean isGrade(String str) {
		return Pattern.matches("^\\d{1}$", str);
	}

	public static boolean isName(String str) {
		return Pattern.matches("^[a-zA-Z]|[��-����-�R]*$", str);
	}

	public static boolean isMajor(String str) {
		return Pattern.matches("^([��-�R]*)�а�$", str);
	}

	public static boolean isMob(String str) {
		return Pattern.matches("^\\d{3}\\d{3,4}\\d{4}$", str);
	}
	
	public static boolean isState(String str) {
		for(String state : stateArray) {
			if(str.equals(state)) {
				return true;
			}
		}
		return false;
	}
}
