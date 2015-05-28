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
import de.dataport.cottonwar.objekte.Schlaeger;

public class Main {

	public static void main(String[] args) {
		//---------------------------
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorldHandler window = new WorldHandler();
				//	window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		//Eher RMI nehmen statt Sockets (Sockets gehen auch, suckt aber)
		
		Schlaeger schlaeger = new Schlaeger("Schlaeger", 100, 30, 20, 10, 50, 200, 100, 1, 100, 100, 100, 100);
		Schlaeger schlaegerGeg = new Schlaeger("Schlaeger", 100, 30, 20, 10, 50, 200, 100, 2, 500, 600, 100, 100);
		
		List<Object> einheiten = new ArrayList<Object>();
		
		einheiten.add(schlaeger);
		einheiten.add(schlaegerGeg);
		//Die Grafik auch noch auf das Panel bringen und dann regelm‰ﬂig repainten
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
//				Graphics g = World.panel.getGraphics();
//				g.setColor(Color.BLACK);
//				
//				g.fillRect(einheiten.get(0)., schlaeger.getY(), schlaeger.getWidth(), schlaeger.getHeight());
				
				
			}
		});
		//panel.add(btnNewButton);
		//-------------------------

	}

}
