package de.dataport.cottonwar.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import de.dataport.cottonwar.objekte.Einheit;

public class GameObject implements Runnable{

	Image i, j = null;
	Image Hintergrund = null;
	static Image h = null;
	int x = 100;
	int y = 100;

	public Image getImage() {
//		return i;
		return j;
	}
	
	public GameObject() {

		try {
			Hintergrund = ImageIO.read(new File("Hintergrund 2.jpg"));
			i = ImageIO.read(new File("ant.png"));
			j = ImageIO.read(new File("test.gif"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	

	public void paintPlayer(Graphics g) {
		g.drawImage(j, 100, 100, this.x, this.y, null);
	}

	public void move(int dX) {

		this.x = this.x + dX;

	}
	
	public void moveB (int dX) {
		this.x = this.x - dX;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}



}
