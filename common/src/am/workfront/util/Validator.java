package am.workfront.util;

/**
 * Created by Garik on 2/14/15.
 */
public class Validator {

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
}
