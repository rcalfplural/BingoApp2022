package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ScreenBackground extends JPanel {
	private BufferedImage image;
	public ScreenBackground(BufferedImage image) {
		super();
		setBackground(Color.BLACK);
		setOpaque(false);
		this.image = image;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
	public void setImage(BufferedImage img) {
		this.image = img;
		this.repaint();
	}
}
