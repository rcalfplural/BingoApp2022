package bingo;

import java.util.Random;

import utils.ArrayUtils;

public class Globo {
	private static Random random = new Random();
	private int[] numerosSorteados;
	private int numerosSorteadosLength;
	public Globo() {
		numerosSorteados = new int[75];
		numerosSorteadosLength = 0;
	}
	
	public int sortearNumero() {
		int n = random.nextInt(1, 75);
		if(ArrayUtils.includes(numerosSorteados, n)) {
			return sortearNumero();
		}
		
		numerosSorteados[numerosSorteadosLength] = n;
		numerosSorteadosLength++;
		
		return n;
	}

	public int[] getNumerosSorteados() {
		return numerosSorteados;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int n:numerosSorteados) {
			str = str.concat(n+", ");
		}
		return str;
	}
}
