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

	public static Image background, backgroundh, backgroundw, Basis, Basis0,
						Krieger, Krieger0, Ritter, Ritter0, Reiter, Reiter0,
						Lord, Lord0, Drache, Drache0, Himmelswacht, Himmelswacht0;
	
	static {
		try {
			background = ImageIO.read(new File("Hintergrund 2.jpg"));
			backgroundw = ImageIO.read(new File("Final.png"));
			backgroundh = ImageIO.read(new File("Hintergrundhaupt.png"));
			Basis= ImageIO.read(new File("Base.png"));
			Basis0= ImageIO.read(new File("Base0.png"));			
			Krieger= ImageIO.read(new File("Krieger.png"));
			Krieger0= ImageIO.read(new File("Krieger0.png"));
			Ritter= ImageIO.read(new File("Ritter.png"));
			Ritter0= ImageIO.read(new File("Ritter0.png"));
			Reiter= ImageIO.read(new File("Reiter.png"));
			Reiter0= ImageIO.read(new File("Reiter0.png"));
			Lord= ImageIO.read(new File("Lord.png"));
			Lord0= ImageIO.read(new File("Lord0.png"));
			Drache= ImageIO.read(new File("Drache.png"));
			Drache0= ImageIO.read(new File("Drache0.png"));
			Himmelswacht= ImageIO.read(new File("Himmelswacht.png"));
			Himmelswacht0= ImageIO.read(new File("Himmelswacht0.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.drawImage(background, 0,0, 1160, 450,null);                      
		List<Einheit> einheiten = new ArrayList<Einheit>();
		einheiten.addAll(Einheit.einheiten);
		einheiten.addAll(Einheit.einheiten2);
      
		for (Einheit e : einheiten) {
			if (e.name == "Basis1" ||e.name == "Basis2") {
				g.drawImage(e.image, e.x, e.y, 250, 250, null);
			}else {
			g.drawImage(e.image, e.x, e.y, 128, 128, null);
			}
			
			
			
		}
	}

}

