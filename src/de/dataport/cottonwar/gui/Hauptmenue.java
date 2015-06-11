package de.dataport.cottonwar.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Hauptmenue extends JFrame implements ActionListener {

	JButton schliessen = new JButton();
	JButton info = new JButton();
	JButton ende = new JButton();
	JButton spielladen = new JButton();
	

	public static void main(String[] args) throws Exception {
		Hauptmenue menue = new Hauptmenue("Menü");
		menue.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menue.setSize(400, 400);
		menue.setLayout(null);
		menue.setVisible(true);
	}

	public Hauptmenue(String title) {
		super(title);

		schliessen = new JButton("Spiel starten");
		schliessen.setBounds(130, 40, 150, 40);
		schliessen.addActionListener(this);
		add(schliessen);

		info = new JButton("Information");
		info.setBounds(130, 100, 150, 40);
		info.addActionListener(this);
		add(info);

		spielladen = new JButton("Spiel laden");
		spielladen.setBounds(130, 160, 150, 40);
		spielladen.addActionListener(this);
		add(spielladen);

		ende = new JButton("Ende");
		ende.setBounds(130, 270, 150, 40);
		ende.addActionListener(this);
		add(ende);

		JLabel label = new JLabel("Made by L. Graner & J. Heeschen");
		label.setBounds(190, 340, 300, 20);
		add(label);

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == schliessen) {
			fenster();
		}

		if (e.getSource() == spielladen) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "Hier werden später Spiele geladen", "Laden...", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}

		if (e.getSource() == info) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "Programmiert von Leon Graner und Jonas Heeschen im Rahmen des Moduls für Entwicklung- und Management", "Information", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		}

		if (e.getSource() == ende) {
			System.exit(0);
			;

		}

	}

	public static void fenster() {
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
