package utils;

import bingo.Cartela;

public class ArrayUtils {
	public static boolean includes(int[] array, int x) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == x) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void ordenarArray(Cartela[] cartelas) {
		for(int i = 0; i < cartelas.length; i++) {
			for(int j = 0; j < cartelas.length - i - 1; j++) {
				if(cartelas[j].getPorcentagemCompleta() < cartelas[j+1].getPorcentagemCompleta()) {
					Cartela tmp = cartelas[j];
					cartelas[j] = cartelas[j+1];
					cartelas[j+1] = tmp;
				}
			}
		}
	}
	
	public static void printarArray(Object[] array) {
		for(Object o:array) {
			System.out.println(o);
		}
	}
}
