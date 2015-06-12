package de.dataport.cottonwar.gui;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import de.dataport.cottonwar.objekte.Spielfeld;

public class Hauptmenue extends JFrame implements ActionListener {

	JButton schliessen = new JButton();
	JButton info = new JButton();
	JButton ende = new JButton();
	JButton spielladen = new JButton();
	JButton story = new JButton();
	JButton einheiten = new JButton();
	

	public static void main(String[] args) throws Exception {
		Hauptmenue menue = new Hauptmenue("Menü");
		menue.setDefaultCloseOperation(EXIT_ON_CLOSE);
		menue.setSize(400, 600);
		menue.setLayout(null);
		menue.setLocationRelativeTo(null);
		menue.setVisible(true);
	}

	public Hauptmenue(String title) {
		super(title);
		Haupthint haupt = new Haupthint();
		haupt.setBounds(0, 0, 400, 600);
		setContentPane(haupt);
		schliessen = new JButton("Neues Spiel");
		schliessen.setBounds(35, 50, 150, 40);
		schliessen.addActionListener(this);
		haupt.add(schliessen);
		
		einheiten = new JButton("Einheiteninfos");
		einheiten.setBounds(115, 210, 150, 40);
		einheiten.addActionListener(this);
		haupt.add(einheiten);

		info = new JButton("Tastenbelegung");
		info.setBounds(115, 130, 150, 40);
		info.addActionListener(this);
		haupt.add(info);

		spielladen = new JButton("Spiel laden");
		spielladen.setBounds(205, 50, 150, 40);
		spielladen.addActionListener(this);
		haupt.add(spielladen);
		
		story = new JButton("Story");
		story.setBounds(115, 290, 150, 40);
		story.addActionListener(this);
		haupt.add(story);

		ende = new JButton("Ende");
		ende.setBounds(115, 430, 150, 40);
		ende.addActionListener(this);
		haupt.add(ende);

		JLabel label = new JLabel("Made by L. Graner & J. Heeschen");
		label.setBounds(190, 540, 300, 20);
		haupt.add(label);
		haupt.setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == schliessen) {
			fenster();
			this.dispose();
		}

		if (e.getSource() == spielladen) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "Hier werden später Spiele geladen", "Laden...", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}

		if (e.getSource() == einheiten) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "Krieger: LP   \tAp \t Gold \n \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t100 \t12 \t15", "Information", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		}
		
		if (e.getSource() == story) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "Nachdem ein riesiger Meteorit die Menschheit im Jahr 3056 vernichtete, \nwurde die Erde zu einem kalten und düsteren Ort. Nach etwa 4 Millionen Jahren der Einöde brachte das Wunder der Evolution erneut die Menschen hervor. \nDiese kämpften in der harschen Natur ums Überleben und schlossen sich zur besseren Verteidigung in Gruppen zusammen. \nZwei dieser Gruppen kämpften immer wieder um ihr Territorium, bis sich der Konflikt letztlich in einem 4 Jährigen Krieg zuspitzte, dem Cotton War. \n"
					+ "Führen sie ihre Fraktion zum Sieg und beherrschen sie die Welt in diesem actiongeladenen Indie-Titel.", "Story", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		}
		
		if (e.getSource() == info) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null, "", "Tastaturbelegungl", JOptionPane.DEFAULT_OPTION,
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
