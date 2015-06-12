package de.dataport.cottonwar.objekte;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Spielfeld extends JPanel {

	public static Image background, backgroundh, backgroundw;
	public static Image ant;
	public static Image base;
	
	static {
		try {
			background = ImageIO.read(new File("Hintergrund 2.jpg"));
			ant = ImageIO.read(new File("ant.png"));
			base = ImageIO.read(new File("Base.png"));
			backgroundw = ImageIO.read(new File("Hintergrund 2.1.png"));
			backgroundh = ImageIO.read(new File("Hintergrundhaupt.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
                              
		List<Einheit> einheiten = new ArrayList<Einheit>();
		einheiten.addAll(Einheit.einheiten);
		einheiten.addAll(Einheit.einheiten2);
      
		for (Einheit e : einheiten) {
			if (e.name == "Basis") {
				g.drawImage(e.image, e.x, e.y, 300, 300, null);
			}else {
			g.drawImage(e.image, e.x, e.y, 128, 128, null);
			}
			
//			g.drawImage(background, 0,0, 1160, 450,null);
			
		}
	}

}
