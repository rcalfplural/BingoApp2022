package bingo;

import java.util.Scanner;

import arquivos.ArquivosUtils;
import menus.Menu;
import utils.ArrayUtils;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		try {			
			ArquivosUtils.resetarDiretorio();
			Menu menuTipoJooj = new Menu("Tipo de Jogo", new String[] {"1 - Linha", "2 - Coluna", "3 - Janelao", "4 - Cheia", "Paulo Lima"});
			
			System.out.println("Sand Pipers Bingo");
			System.out.print("Numero de jogadores: ");
			int numeroJogadores = scanner.nextInt();
			
			if(numeroJogadores < 1) {
				throw new Exception("Numero invalido de jogadores.");
			}
			
			mostrarOpcoesMenu(menuTipoJooj);
			JogoTiposEnum jogoTipo = getJogoTipo(menuTipoJooj.nextInt());
			
			Bingo jooj = new Bingo(numeroJogadores, jogoTipo);
			
			do {
				System.out.print("Aperte ENTER para sortear um numero...");
				scanner.nextLine();
				int sorteado = jooj.getGlobo().sortearNumero();
				System.out.println(sorteado);
				/*Cartela c = jooj.getCartelas()[0];  // para testar se ta funcionando o sistema de mostrar cartela parcialmente na boa
				System.out.println("Acertos: "+c.getPorcentagemCompleta()+"%");
				System.out.println(c);*/
				
				System.out.println("Cartelas na boa: ");
				ArrayUtils.ordenarArray(jooj.getCartelas());
				int quant = (numeroJogadores > 3)?3:1;
				
				for(int i = 0; i < quant; i++) {
					System.out.println(jooj.getCartelas()[i]);
				}
			}while(jooj.temosVencedor() == null);
			
			System.out.println("Temos um vencedor: ");
			System.out.println(jooj.temosVencedor());
			
		}catch(Exception e) {
			System.out.println("Ocorreu um erro: ");
			e.printStackTrace();
		}
	}

	private static void mostrarOpcoesMenu(Menu m) {
		for(String opcao : m.getOptions()) {
			System.out.println(opcao);
		}
		
	}
	private static JogoTiposEnum getJogoTipo(int escolha) {
		switch(escolha) {
			case 1:
				return JogoTiposEnum.LINHA;
			case 2:
				return JogoTiposEnum.COLUNA;
			case 3: 
				return JogoTiposEnum.JANELA;
			case 4:
				return JogoTiposEnum.CHEIA;
				default:
					return JogoTiposEnum.CHEIA;
		}
	}
}
