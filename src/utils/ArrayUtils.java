package utils;

public class ArrayUtils {
	public static boolean includes(int[] array, int x) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == x) {
				return true;
			}
		}
		
		return false;
	}
}
