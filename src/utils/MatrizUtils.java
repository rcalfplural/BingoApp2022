package utils;

public class MatrizUtils {
	
	public static boolean includes(int[][] matriz, int x) {
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] == x) {
					return true;
				}
			}
		}
		
		return false;
	}
}
