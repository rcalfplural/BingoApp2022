package bingo;

import java.util.Random;

import utils.ArrayUtils;
import utils.MatrizUtils;

public class Cartela {
	private int[][] cartelaDados;
	private Bingo jogo;
	private static Random random = new Random();
	private static final int TAMANHO_CARTELA = 5;
	private int acertos;
	private int porcentagemCompleta;
	public Cartela(Bingo bingo) {
		this.cartelaDados = new int[TAMANHO_CARTELA][TAMANHO_CARTELA];
		this.acertos = 0;
		this.jogo = bingo;
		this.porcentagemCompleta = 0;
		gerarCartela();
	}

	public boolean checarNumeroIncluido(int n) {
		return MatrizUtils.includes(cartelaDados, n);
	}
	
	private int gerarNumeroCartela(int coluna) {
		int minimo = (coluna*15)+1;
		int maximo = minimo+14;
		int res = random.nextInt(minimo, maximo);
		
		if(MatrizUtils.includes(cartelaDados, res)) {
			return gerarNumeroCartela(coluna);
		}
		
		return res;
	}
	
	
	
	public Bingo getJogo() {
		return jogo;
	}

	public void setJogo(Bingo jogo) {
		this.jogo = jogo;
	}

	private void gerarCartela() {
		if (acertos == 0) acertos = -1;
		for(int i = 0; i < TAMANHO_CARTELA; i++) {
			for(int j = 0; j < TAMANHO_CARTELA; j++) {
				double meio = Math.floor(TAMANHO_CARTELA/2);
				if(j == meio  && i == meio) {
					cartelaDados[i][j] = 0;
					continue;
				}
				cartelaDados[i][j] = gerarNumeroCartela(j);
			}
		}
	}
	
	private void calcularPorcentagemCompleta() {
		JogoTiposEnum tipoJogo = jogo.getTipoJogo();
		int acertos = 0, total = 0;
		if(tipoJogo == JogoTiposEnum.LINHA) {
			int maiorAcerto = 0;
			total = TAMANHO_CARTELA;
			for(int i = 0; i < TAMANHO_CARTELA; i++) {
				int acerto = getAcertosDeLinha(cartelaDados[i]);
				if(acerto > maiorAcerto)
					maiorAcerto = acerto;
			}
			
			acertos += maiorAcerto;
		}
		else if(tipoJogo == JogoTiposEnum.COLUNA) {
			int maiorAcerto = 0;
			total = TAMANHO_CARTELA;
			for(int i = 0; i < TAMANHO_CARTELA; i++) {
				int[] coluna = getColuna(i);
				int acerto = getAcertosDeLinha(coluna);
				
				if(acerto > maiorAcerto)
					maiorAcerto = acerto;
			}
			
			acertos += maiorAcerto;
		}
		else if(tipoJogo == JogoTiposEnum.CHEIA) {
			int acerto = 0;
			total = TAMANHO_CARTELA * TAMANHO_CARTELA;
			for(int i = 0; i < TAMANHO_CARTELA; i++) {
				acerto += getAcertosDeLinha(cartelaDados[i]);
			}
			
			acertos += acerto;
		}
		else if(tipoJogo == JogoTiposEnum.JANELA){
			int[] colunaFirst = getColuna(0);
			int[] colunaLast = getColuna(TAMANHO_CARTELA-1);
			int[] linhaFirst = cartelaDados[0];
			int[] linhaLast = cartelaDados[TAMANHO_CARTELA-1];
			
			acertos = getAcertosDeLinha(colunaFirst) + getAcertosDeLinha(colunaLast) + getAcertosDeLinha(linhaFirst) + getAcertosDeLinha(linhaLast);
			total = colunaFirst.length + colunaLast.length + linhaFirst.length + linhaLast.length;
		}
		
		this.porcentagemCompleta = (acertos*100)/total;
	}
	
	public boolean checarVenceu(JogoTiposEnum tipoJogo) {
		this.calcularPorcentagemCompleta();
		if(tipoJogo == JogoTiposEnum.LINHA) {
			for(int i = 0; i < cartelaDados.length; i++) {
				if(linhaCompleta(cartelaDados[i])) {
					return true;
				}
			}
			
			return false;
		}
		else if(tipoJogo == JogoTiposEnum.COLUNA) {
			return colunaCompleta();
		}
		else if(tipoJogo == JogoTiposEnum.CHEIA) {
			for(int i = 0; i < cartelaDados.length; i++) {
				if(!linhaCompleta(cartelaDados[i])) {
					return false;
				}
			}
			
			return true;
		}
		else if(tipoJogo == JogoTiposEnum.JANELA){
			int[] colunaFirst = getColuna(0);
			int[] colunaLast = getColuna(TAMANHO_CARTELA-1);
			int[] linhaFirst = cartelaDados[0];
			int[] linhaLast = cartelaDados[TAMANHO_CARTELA-1];
			
			return ( linhaCompleta(colunaFirst) && linhaCompleta(colunaLast) && linhaCompleta(linhaFirst) && linhaCompleta(linhaLast));
			
		}
		
		
		return false;
	}
	
	private int getAcertosDeLinha(int[] linha) {		
		int acertosLinha = 0;
		for(int i = 0; i < linha.length; i++) {
			if(ArrayUtils.includes(jogo.getGlobo().getNumerosSorteados(), linha[i])) {
				acertosLinha++;
			}
		}
		
		return acertosLinha;
		
	}
	private boolean linhaCompleta(int[] linha) {
		int total = linha.length;
		return (getAcertosDeLinha(linha) == total);
	}
	
	public int getPorcentagemCompleta(){
		return porcentagemCompleta;
	}
	
	
	public int[] getColuna(int index) {
		int[] coluna = new int[TAMANHO_CARTELA];
		int indexArray = 0;
		
		for(int i = 0; i < cartelaDados.length; i++) {
			for(int j = 0; j < cartelaDados[i].length; j++) {				
				if(j == index) {					
					coluna[indexArray] = cartelaDados[i][j];
					indexArray++;
				}
			}
		}
		
		
		return coluna;
	}
	
	private boolean colunaCompleta() {
		int[] coluna;
		int arrayIndex = 0;
		
		for(int i = 0; i < cartelaDados.length; i++) {		
			coluna = new int[TAMANHO_CARTELA];
			arrayIndex = 0;
			for(int j = 0; j < cartelaDados[i].length; j++) {
				coluna[arrayIndex] = cartelaDados[j][i];
				arrayIndex++;
			}
			
			if(linhaCompleta(coluna)) {
				return true;
			}
			
		}
		
		return false;
	}
	
	
	@Override
	public String toString() {
		String view = "B    I    N    G    O\n";
		
		for(int i = 0; i < cartelaDados.length; i++) {
			for(int j = 0; j < cartelaDados[i].length; j++) {
				// TODO: Mostrar em 2 digitos
				int celulaInt = cartelaDados[i][j];
				String celulaFormatada = (celulaInt > 0 && ArrayUtils.includes(jogo.getGlobo().getNumerosSorteados(), celulaInt))
													?String.format("|%02d| ", celulaInt):
													String.format("%02d   ", celulaInt);
				String celulaString = (celulaInt > 0)?celulaFormatada : "XX   ";
				view = view.concat(celulaString);
			}
			
			view = view.concat("\n");
		}
		
		return view;
	}
}
