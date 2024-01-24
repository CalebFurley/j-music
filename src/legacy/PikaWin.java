package legacy;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import core.AudioPlayer;

public class PikaWin implements ActionListener{
	
	JFrame frame = new JFrame("PokePlayer");
	
	JLayeredPane layeredPane = new JLayeredPane();
	
	ImageIcon pikaIcon = new ImageIcon(getClass().getResource("/images/PikaIcon.png"));
	ImageIcon pokeLogo = new ImageIcon(getClass().getResource("/images/PokemonLogo.png"));
	
	JButton loadButton = new JButton("LOAD");
	JButton playButton = new JButton("PLAY");
	JButton pauseButton = new JButton("PAUSE");
	JButton resetButton = new JButton("RESET");
	JButton ejectButton = new JButton("EJECT");
	
	JPanel buttonsPanel = new JPanel();
	JPanel logoPanel = new JPanel();
	JPanel basePanel = new JPanel();
	JPanel southPanel = new JPanel();
	JPanel northPanel = new JPanel();
	
	JLabel logoLabel = new JLabel();
	JLabel titleLabel = new JLabel("PokePlayer");

	
	PikaWin() {
		
		//-------imageIcons-----------
		Image tempPokeLogo = pokeLogo.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		pokeLogo = new ImageIcon(tempPokeLogo);
		
		//---------labels-------------
		logoLabel.setIcon(pokeLogo);
		logoLabel.setBounds(45,0,500,250);
		logoLabel.setOpaque(true);
		logoLabel.setBackground(Color.blue);
		
		titleLabel.setBounds(250,10,200,50);
		titleLabel.setOpaque(true);
		titleLabel.setBackground(Color.gray);
		titleLabel.setForeground(Color.yellow);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
	
		
		//---------buttons------------
		
		// button settings
		loadButton.setBounds(20, 10, 50, 50);
		loadButton.addActionListener(this);
		loadButton.setFocusable(false);
		loadButton.setBorder(BorderFactory.createEtchedBorder());
		loadButton.setBackground(new Color(200,200,0));
		loadButton.setForeground(Color.black);
		loadButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		playButton.addActionListener(this);
		playButton.setFocusable(false);
		playButton.setBorder(BorderFactory.createEtchedBorder());
		playButton.setBackground(new Color(200,200,0));
		playButton.setForeground(Color.black);
		playButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		pauseButton.addActionListener(this);
		pauseButton.setFocusable(false);
		pauseButton.setBorder(BorderFactory.createEtchedBorder());
		pauseButton.setBackground(new Color(200,200,0));
		pauseButton.setForeground(Color.black);
		pauseButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		resetButton.setBorder(BorderFactory.createEtchedBorder());
		resetButton.setBackground(new Color(200,200,0));
		resetButton.setForeground(Color.black);
		resetButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		ejectButton.addActionListener(this);
		ejectButton.setFocusable(false);
		ejectButton.setBorder(BorderFactory.createEtchedBorder());
		ejectButton.setBackground(new Color(200,200,0));
		ejectButton.setForeground(Color.black);
		ejectButton.setFont(new Font("Arial", Font.BOLD, 15));
		
		
		//----------panels------------
		
		// add components to panels
		buttonsPanel.add(playButton);
		buttonsPanel.add(pauseButton);
		buttonsPanel.add(resetButton);	
		buttonsPanel.add(ejectButton);
		
		logoPanel.add(logoLabel);
		
		northPanel.add(titleLabel);
		northPanel.add(loadButton);
		
		// panel settings
		basePanel.setLayout(null);
		basePanel.setBounds(0,0,720,720);
		basePanel.setOpaque(true);
		basePanel.setBackground(Color.darkGray);
		
		logoPanel.setLayout(null);
		logoPanel.setBounds(97,175,500,250);
		logoPanel.setBackground(Color.blue);
		logoPanel.setOpaque(true);
		
		buttonsPanel.setLayout(new GridLayout(1,4,10,10));
		buttonsPanel.setBounds(10,500,685,75);
		buttonsPanel.setOpaque(true);
		buttonsPanel.setBackground(Color.darkGray);
		
		southPanel.setLayout(null);
		southPanel.setBounds(10,590,685,75);
		southPanel.setOpaque(true);
		southPanel.setBackground(Color.gray);
		
		northPanel.setLayout(null);
		northPanel.setBounds(10,18,685,75);
		northPanel.setOpaque(true);
		northPanel.setBackground(Color.gray);
		
		
		//--------layeredPane----------
		
		// add panels to layers
		layeredPane.add(basePanel, Integer.valueOf(0));
		layeredPane.add(buttonsPanel, Integer.valueOf(1));
		layeredPane.add(southPanel, Integer.valueOf(1));
		layeredPane.add(northPanel, Integer.valueOf(1));
		layeredPane.add(logoPanel, Integer.valueOf(1));
		
		// layer settings
		layeredPane.setBounds(0,0,720,720);
		
		
		//----------frame--------------
		
		// add layeredPane to frame
		frame.add(layeredPane);
		
		// frame settings
		frame.setBackground(Color.darkGray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setIconImage(pikaIcon.getImage());
		frame.setSize(720,720);
		frame.setBackground(Color.darkGray);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == loadButton) {
			try {
				try {
					AudioPlayer.load("C://Users/caleb/Code/Java/AudioPlayer/res/audio/PokeSong.wav");
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (LineUnavailableException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == playButton) {
			try {
				AudioPlayer.play();
			} catch (LineUnavailableException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
