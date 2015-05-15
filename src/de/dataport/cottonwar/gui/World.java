package de.dataport.cottonwar.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import de.dataport.cottonwar.objekte.Einheit;
import de.dataport.cottonwar.objekte.Schlaeger;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class World {

	JPanel panel;
	public JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					World window = new World();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public World() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 800, 1200);
		frame.getContentPane().add(panel);
		/*
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Graphics g = panel.getGraphics();
				g.setColor(Color.BLACK);
				Schlaeger schlaeger = new Schlaeger("schlaeger", 10000, 1, 1, 1, 0, 0, 13, true);
				schlaeger.setX(0);
				schlaeger.setY(20);
				schlaeger.setHeight(20);
				schlaeger.setWidth(20);
				g.fillRect(schlaeger.getX(), schlaeger.getY(), schlaeger.getWidth(), schlaeger.getHeight());
				
				schlaeger.move();
				
				
				
			}
		});
		panel.add(btnNewButton);
		*/


		
	}

}
