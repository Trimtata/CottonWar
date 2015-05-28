package de.dataport.cottonwar.gui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {
	
	BufferedImage i = null;
	int x = 100;
	int y = 100;
	public GameObject(){
	
	try {
		i = ImageIO.read(new File("/url.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void paintPlayer(Graphics g){
		g.drawImage(i, x,y,100,100,null);
	}
	
	public void move(int dX){
		
		x = x + dX;
		
	}

}
