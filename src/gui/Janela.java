package gui;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

import gui.listeners.SensorTecladoJanela;

public class Janela extends JFrame {
	private static BufferedImage mainMenuBackground;
	private static BufferedImage gameplayBackground;
	private static BufferedImage otavio;
	private static ScreenBackground background;
	
	private JogoTelas telaAtual;
	public Janela() {
		
		setTitle("Bingo no asilo do advogado do Lima");
		setSize(640, 480);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			carregarAssets();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		telaAtual = JogoTelas.TELA_INICIAL;
		background = new ScreenBackground(mainMenuBackground);
		
		addKeyListener(new SensorTecladoJanela());
		ScreenBackground bgTest = new ScreenBackground(otavio);
		bgTest.setBackground(null);
		add(background, BorderLayout.CENTER);
		add(bgTest, BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
	}

	private void carregarAssets() throws IOException{
		mainMenuBackground = ImageIO.read(new File("src/gui/assets/main_menu.jpg"));
		gameplayBackground = ImageIO.read(new File("src/gui/assets/point.jpg"));
		otavio = ImageIO.read(new File("src/gui/assets/otavio.png"));
	}
	
	public void setTelaAtual(JogoTelas tela) {
		this.telaAtual = tela;
		
		switch(telaAtual) {
			case TELA_INICIAL:
					background.setImage(mainMenuBackground);
				break;
			case JOGO:
					background.setImage(gameplayBackground);
				break;
			default: break;
		}
		
		repaint();
	}
}
