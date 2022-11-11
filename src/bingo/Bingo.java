package bingo;

import java.io.IOException;

import arquivos.ArquivosUtils;
import utils.ArrayUtils;

public class Bingo {
	private Cartela[] cartelas;
	private JogoTiposEnum tipoJogo;
	private Globo globo;
	
	public Bingo(int nCartelas, JogoTiposEnum tipoJogo) throws Exception {
		this.tipoJogo = tipoJogo;
		this.globo = new Globo();
		this.cartelas = new Cartela[nCartelas];
		inicializarCartelas();
	}
	
	
	private void inicializarCartelas() throws IOException {
		for(int i = 0; i < cartelas.length; i++) {
			cartelas[i] = new Cartela(this);
			ArquivosUtils.escreveArquivo("Cartella-"+(i+1)+".txt", cartelas[i].toString(), true);
		}
	}

	public Cartela temosVencedor() {
		for(Cartela c:cartelas) {
			if(c.checarVenceu(tipoJogo)) {
				return c;
			}
		}
		
		return null;
	}
	
	public Cartela[] getCartelas() {
		return cartelas;
	}

	public void setCartelas(Cartela[] cartelas) {
		this.cartelas = cartelas;
	}

	public JogoTiposEnum getTipoJogo() {
		return tipoJogo;
	}

	public void setTipoJogo(JogoTiposEnum tipoJogo) {
		this.tipoJogo = tipoJogo;
	}

	public Globo getGlobo() {
		return globo;
	}

	public void setGlobo(Globo globo) {
		this.globo = globo;
	}
}
