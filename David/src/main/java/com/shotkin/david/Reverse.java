package com.shotkin.david;

public class Reverse {

	/**
	 * The inefficient way to reverse a String
	 * 
	 * @param original
	 *            The String to reverse
	 * @return The reversed String
	 */
	@Deprecated
	public static String reverseEverythingInefficiently(String original) {

		if (original == null)
			return null;

		String reversed = "";
		for (int index = original.length() - 1; index >= 0; index--) {
			reversed += original.charAt(index);
		}
		return reversed;
	}

	/**
	 * 
	 * @param original The String to reverse
	 * @return  The reversed String
	 */
	public static String reverseEverything(String original) {
		
		if (original == null)
			return null;
		
		StringBuilder sb = new StringBuilder(original);
		return sb.reverse().toString();
	}
}
