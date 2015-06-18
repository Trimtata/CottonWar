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
import de.dataport.cottonwar.savegame.Main;

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
		menue.setResizable(false);
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

		if (e.getSource() == einheiten) {
			Object[] options = { "OK" };

			JOptionPane
					.showOptionDialog(
							null,
							"Evolutionsstufe primitiv \nKrieger: Lebenspunkte \t \t \tAngriffswert \t \t \tGolddrop \n \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t100 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t20 \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t2 \n \n"
									+ "Ritter: Lebenspunkte \t \t \tAngriffswert \t \t \tGolddrop \n \t \t \t \t \t \t \t \t \t \t \t \t \t \t200 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t15 \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t7 \n \n"
									+ "Reiter: Lebenspunkte \t \t \tAngriffswert \t \t \tGolddrop \n \t \t \t \t \t \t \t \t \t \t \t \t \t160 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t30 \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t12 \n\n\n"
									+ "Evolutionsstufe fortgeschritten \nLord: Lebenspunkte \t \t \tAngriffswert \t \t \tGolddrop \n \t \t \t \t \t \t \t \t \t \t \t \t220 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t50 \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t65 \n \nDrache: Lebenspunkte \t \t \tAngriffswert \t \t \tGolddrop \n \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t250 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t40 \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t60 \n \nHimmelswacht: Lebenspunkte \t \t \tAngriffswert \t \t \tGolddrop \n \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t400 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t85 \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t55 \n \n \n Basen: Lebenspunkte \t \t \tAngriffswert \n \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t1000 \t"
									+ " \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t-", "Information",
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);


		}

		if (e.getSource() == story) {
			Object[] options = { "OK" };
			JOptionPane
					.showOptionDialog(
							null,
							"Nachdem ein riesiger Meteorit die Menschheit im Jahr 3056 vernichtete, \nwurde die Erde zu einem kalten und düsteren Ort. Nach etwa 4 Millionen Jahren der Einöde brachte das Wunder der Evolution erneut die Menschen hervor. \nDiese kämpften in der harschen Natur ums Überleben und schlossen sich zur besseren Verteidigung in Gruppen zusammen. \nZwei dieser Gruppen kämpften immer wieder um ihr Territorium, bis sich der Konflikt letztlich in einem 4 Jährigen Krieg zuspitzte, dem Cotton War. \n"
									+ "Führen sie ihre Fraktion zum Sieg und beherrschen sie die Welt in diesem actiongeladenen Indie-Titel.",

							"Story", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);


		}

		if (e.getSource() == info) {
			Object[] options = { "OK" };

			JOptionPane.showOptionDialog(null, "\t \t \t \t \t \t \t \t\t \t \t \t \t \t \t \t \t \tSpieler 1 \t \t \t \t \tSpieler2 \n"
					+ "Krieger: \tQ \t \t \t \t \t\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \tI \n\n"
					+ "Ritter: \t \t \t \t \tW \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \tO \n\n"
					+ "Reiter: \t \t \t \t \tE \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \tP \n\n"
					+ "Lord: \t \t \t \t \t \t \tA \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \tJ \n\n"
					+ "Drache: \t \tS \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \tK \n\n"
					+ "Himmels- \nwächter: \tD \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \tL", "Tastaturbelegungl",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);


		}

		if (e.getSource() == ende) {
			System.exit(0);
			;

		}

		if (e.getSource() == spielladen) {
			fenster();
			Main.laden();

			this.dispose();
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
