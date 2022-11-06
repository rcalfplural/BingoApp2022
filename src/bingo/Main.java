package bingo;

import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Sand Pipers Bingo");
		System.out.print("Numero de jogadores: ");
		
		Bingo jooj = new Bingo(scanner.nextInt(), JogoTiposEnum.CHEIA);
		
		
		do {
			int sorteado = jooj.getGlobo().sortearNumero();
			System.out.println(sorteado);
		}while(jooj.temosVencedor() == null);
		
		System.out.println("Temos um vencedor: ");
		System.out.println(jooj.temosVencedor());
		
	}

}
