package de.dataport.cottonwar.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WorldHandler extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853228346248816103L;

	public WorldHandler() {
		
		JFrame worldhander = new JFrame();
		worldhander.setSize(800, 600);
		worldhander.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldhander.setVisible(true);
		
		
		
		
		World w = new World(worldhander);
		worldhander.setContentPane(w);
		
		
		JButton button = new JButton("Test");
		button.setBounds(10,10,100,200);
		button.setVisible(true);
		worldhander.add(button);
	}
}
