package bingo;

import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Sand Pipers Bingo");
		System.out.print("Numero de jogadores: ");
		
		Bingo jooj = new Bingo(scanner.nextInt(), JogoTiposEnum.JANELA);
		
		
		do {
			int sorteado = jooj.getGlobo().sortearNumero();
			System.out.println(sorteado);
		}while(jooj.temosVencedor() == null);
		
		System.out.println("Temos um vencedor: ");
		System.out.println(jooj.temosVencedor());
		
		/* ZONA DE TESTES
		Cartela c = new Cartela(jooj);
		
		
		int[] col0 = c.getColuna(0);
		int[] col2 = c.getColuna(4);
		
		System.out.println(c);
		
		for(int i:col0) {
			System.out.println(i);
		}
		
		for(int i:col2) {
			System.out.println(i);
		}
		*/
	}

}
