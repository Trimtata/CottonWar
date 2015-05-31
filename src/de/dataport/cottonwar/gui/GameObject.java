package de.dataport.cottonwar.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameObject {

	Image i = null;
	int x = 100;
	int y = 100;

	public Image getImage() {
		return i;
	}
	
	public GameObject() {

		try {
			i = ImageIO.read(new File("ant.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paintPlayer(Graphics g) {
		g.drawImage(i, 100, 100, this.x, this.y, null);
	}

	public void move(int dX) {

		this.x = this.x + dX;

	}
	
	public void moveB (int dX) {
		this.x = this.x - dX;
	}



}
