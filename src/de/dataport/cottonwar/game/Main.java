package de.dataport.cottonwar.game;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import de.dataport.cottonwar.gui.World;
import de.dataport.cottonwar.gui.WorldHandler;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldHandler window = new WorldHandler();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
