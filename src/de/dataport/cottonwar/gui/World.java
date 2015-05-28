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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class World extends JPanel implements KeyListener{

	public static JPanel panel;
	public JFrame frame;
	GameObject a = new GameObject();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		a.paintPlayer(g);
	}
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					World window = new World();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public World() {
		//initialize();
		this.addKeyListener(this);
		this.setFocusable(true);
		setLayout(null);
		
		JButton btnSch = new JButton("Sch");
		btnSch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSch.setAction(action);
		btnSch.setBounds(10, 11, 45, 23);
		add(btnSch);
		
		

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
		panel.setLayout(null);
		
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


//	@Override
//	public void keyPressed(KeyEvent arg0) {
//		// TODO Auto-generated method stub
//		
//		if(arg0.getKeyCode()==KeyEvent.VK_UP){
//			a.move(0, -5);
//			this.repaint();
//		}
//		if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
//			a.move(0, 5);
//			this.repaint();
//		}
//		if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
//			a.move(-5, 0);
//			this.repaint();
//		}
//		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
//			a.move(5, 0);
//			this.repaint();
//		}
//		
//	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
