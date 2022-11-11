package gui.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gui.Janela;
import gui.JogoTelas;

public class SensorTecladoJanela implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Janela janela = (Janela)e.getComponent();
		
		if(janela == null) return;
		
		System.out.println("AIDS");
		
		janela.setTelaAtual(JogoTelas.JOGO);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
