package legacy;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import core.AudioPlayer;

public class RecWin implements ActionListener {
	
	String songTitle;
	String songPath;
	
	boolean isPlaying = false;
	boolean isRewinding = false;
	
	JFrame recFrame = new JFrame("RecordPlayer");
	
	JLayeredPane layeredPane = new JLayeredPane();
	
	JPanel buttonsPanel = new JPanel(); // put buttons here
	JPanel returnButtonPanel = new JPanel(); // put buttons here
	JPanel recordPanel = new JPanel(); // put record player and spinning record here (for now put picture of album)
	JPanel titlePanel = new JPanel(); // put title of song here
	JPanel backgroundPanel = new JPanel(); // background
	
	JButton playButton = new JButton();
	JButton rrButton = new JButton();
	JButton ffButton = new JButton();
	JButton nextButton = new JButton();
	JButton prevButton = new JButton();
	JButton returnButton = new JButton();
	
	JLabel titleLabel = new JLabel();
	JLabel recordLabel = new JLabel();

/*
	ImageIcon prevButtonIcon = new ImageIcon(getClass().getResource("/images/PrevButton.png"));
	ImageIcon rrButtonIcon = new ImageIcon(getClass().getResource("/images/rrButton.png"));
	ImageIcon playButtonIcon = new ImageIcon(getClass().getResource("/images/PlayButton.png"));
	ImageIcon ffButtonIcon = new ImageIcon(getClass().getResource("/images/ffButton.png"));
	ImageIcon nextButtonIcon = new ImageIcon(getClass().getResource("/images/NextButton.png"));
	ImageIcon recordIcon = new ImageIcon(getClass().getResource("/images/Record.png"));
*/	
	
	RecWin(String songTitle, String songPath) {
				
		this.songTitle = songTitle;
		this.songPath = songPath;
		
		//--------IMAGE_ICONS-------
		/*
		Image bufferedPrevButtonIcon = prevButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		prevButtonIcon = new ImageIcon(bufferedPrevButtonIcon);
		Image bufferedRRButtonIcon = rrButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		rrButtonIcon = new ImageIcon(bufferedRRButtonIcon);
		Image bufferedPlayButtonIcon = playButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		playButtonIcon = new ImageIcon(bufferedPlayButtonIcon);
		Image bufferedFFButtonIcon = ffButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ffButtonIcon = new ImageIcon(bufferedFFButtonIcon);
		Image bufferedNextButtonIcon = nextButtonIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		nextButtonIcon = new ImageIcon(bufferedNextButtonIcon);
		
		Image bufferedRecordIcon = recordIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		recordIcon = new ImageIcon(bufferedRecordIcon);
		*/
		
		//----------BUTTONS---------
		
		//prevButton.setIcon(prevButtonIcon);
		prevButton.addActionListener(this);
		prevButton.setFocusable(false);
		prevButton.setBorder(BorderFactory.createEtchedBorder());
		prevButton.setBackground(Color.gray);
		prevButton.setForeground(Color.black);
		
		//rrButton.setIcon(rrButtonIcon); rrButton.addActionListener(this);
		rrButton.setFocusable(false);
		rrButton.setBorder(BorderFactory.createEtchedBorder());
		rrButton.setBackground(Color.gray);
		rrButton.setForeground(Color.black);
		
		//playButton.setIcon(playButtonIcon);
		playButton.addActionListener(this);
		playButton.setFocusable(false);
		playButton.setBorder(BorderFactory.createEtchedBorder());
		playButton.setBackground(Color.gray);
		playButton.setForeground(Color.black);
		
		//ffButton.setIcon(ffButtonIcon);
		ffButton.addActionListener(this);
		ffButton.setFocusable(false);
		ffButton.setBorder(BorderFactory.createEtchedBorder());
		ffButton.setBackground(Color.gray);
		ffButton.setForeground(Color.black);
		
		//nextButton.setIcon(nextButtonIcon);
		nextButton.addActionListener(this);
		nextButton.setFocusable(false);
		nextButton.setBorder(BorderFactory.createEtchedBorder());
		nextButton.setBackground(Color.gray);
		nextButton.setForeground(Color.black);
	
		
		//returnButton.setIcon(nextButtonIcon);
		returnButton.addActionListener(this);
		returnButton.setFocusable(false);
		returnButton.setBorder(BorderFactory.createEtchedBorder());
		returnButton.setBackground(Color.gray);
		returnButton.setForeground(Color.black);
		
		
		//----------LABELS----------
		
		titleLabel.setText(songTitle);
		titleLabel.setOpaque(true);
		titleLabel.setBounds(275,0,100,100);
		titleLabel.setBackground(Color.gray);
		titleLabel.setForeground(Color.white);
		
		recordLabel.setOpaque(true);
		recordLabel.setBounds(103,30,200,200);
		recordLabel.setBackground(Color.darkGray);
		//recordLabel.setIcon(recordIcon);
		recordLabel.setHorizontalAlignment(JLabel.CENTER);
		recordLabel.setVerticalAlignment(JLabel.CENTER);
		
		
		//----------PANELS----------
		
		backgroundPanel.setBackground(Color.darkGray);
		backgroundPanel.setOpaque(true);
		backgroundPanel.setBounds(0,0,720,720);
		backgroundPanel.setLayout(null);
		
		titlePanel.setBackground(Color.gray);
		titlePanel.setOpaque(true);
		titlePanel.setBounds(50,50,600,100);
		titlePanel.setLayout(null);
		titlePanel.add(titleLabel);
		
		recordPanel.setBackground(Color.darkGray);
		recordPanel.setOpaque(true);
		recordPanel.setBounds(150,200,400,250);
		recordPanel.setLayout(null);
		recordPanel.add(recordLabel);
		
		buttonsPanel.setLayout(new GridLayout());
		buttonsPanel.setBackground(Color.gray);
		buttonsPanel.setOpaque(true);
		buttonsPanel.setBounds(50,500,600,100);
		buttonsPanel.add(prevButton);
		buttonsPanel.add(rrButton);
		buttonsPanel.add(playButton);
		buttonsPanel.add(ffButton);
		buttonsPanel.add(nextButton);
		
		returnButtonPanel.setLayout(new GridLayout());
		returnButtonPanel.setBackground(Color.black);
		returnButtonPanel.setOpaque(true);
		returnButtonPanel.setBounds(10,10,35,35);
		returnButtonPanel.add(returnButton);
	
		
		//-------LAYERED_PANES-------
		
		layeredPane.add(backgroundPanel, Integer.valueOf(0));
		layeredPane.add(buttonsPanel, Integer.valueOf(1));
		layeredPane.add(returnButtonPanel, Integer.valueOf(1));
		layeredPane.add(recordPanel, Integer.valueOf(1));
		layeredPane.add(titlePanel, Integer.valueOf(1));
		
		layeredPane.setSize(720,720);
		
		
		//----------FRAME-----------
		recFrame.setResizable(false);
		recFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recFrame.setSize(720,720);
		recFrame.setVisible(true);
		
		recFrame.add(layeredPane);
		
		try {
			AudioPlayer.load(songPath);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == returnButton) {
			AudioPlayer.myClose();
			recFrame.dispose();
			new Menu();
		}
		
		if (e.getSource() == playButton) {
			if (isPlaying == false) {
				try {
					AudioPlayer.play();
				} catch (LineUnavailableException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				isPlaying = true;
			}
			else if (isPlaying == true) {
				AudioPlayer.pause();
				isPlaying = false;
			}
		}
		if (e.getSource() == rrButton) {
			if (isRewinding == false) {
				isRewinding = true;
				isPlaying = !isPlaying;
			}			
			else if (isRewinding == true) {
				isRewinding = false;
				isPlaying = !isPlaying;
			}
			while (isRewinding == true) {
				isRewinding = AudioPlayer.rewind();// wont stop rewinding when other input is put in. bascially,
												   // keeps rewinding until at 0 microseconds.
			}
		}
	}
}
