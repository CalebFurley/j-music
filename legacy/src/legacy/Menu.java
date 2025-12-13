package legacy;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Menu implements ActionListener {
	JFrame MenuFrame = new JFrame("RecordPlayer");
	
	JLayeredPane layeredPane = new JLayeredPane();
	
	JPanel buttonsPanel1 = new JPanel(); // put buttons here
	JPanel buttonsPanel2 = new JPanel(); // put buttons here
	JPanel buttonsPanel3 = new JPanel(); // put buttons here
	JPanel titlePanel = new JPanel(); // put title of song here
	JPanel backgroundPanel = new JPanel(); // background
	
	JButton song1 = new JButton();
	JButton song2 = new JButton();
	JButton song3 = new JButton();
	JButton song4 = new JButton();
	JButton song5 = new JButton();
	JButton song6 = new JButton();
	JButton song7 = new JButton();
	JButton song8 = new JButton();
	JButton song9 = new JButton();

	JLabel titleLabel = new JLabel();
	JLabel recordLabel = new JLabel();
	
	public Menu() {
		
		
		//-----------BUTTONS--------------
		
		// song1.setIcon(albumCover);
		song1.setText("Space Song");
		song1.addActionListener(this);
		song1.setFocusable(false);
		song1.setBorder(BorderFactory.createEtchedBorder());
		song1.setBackground(Color.gray);
		song1.setForeground(Color.black);
		
		song2.setText("Nunca Es Sufficiente");
		song2.addActionListener(this);
		song2.setFocusable(false);
		song2.setBorder(BorderFactory.createEtchedBorder());
		song2.setBackground(Color.gray);
		song2.setForeground(Color.black);
		
		song3.setText("Pokemon");
		song3.addActionListener(this);
		song3.setFocusable(false);
		song3.setBorder(BorderFactory.createEtchedBorder());
		song3.setBackground(Color.gray);
		song3.setForeground(Color.black);
		
		song4.setText("Add Song");
		song4.addActionListener(this);
		song4.setFocusable(false);
		song4.setBorder(BorderFactory.createEtchedBorder());
		song4.setBackground(Color.gray);
		song4.setForeground(Color.black);
		
		song5.setText("Add Song");
		song5.addActionListener(this);
		song5.setFocusable(false);
		song5.setBorder(BorderFactory.createEtchedBorder());
		song5.setBackground(Color.gray);
		song5.setForeground(Color.black);
		
		song6.setText("Add Song");
		song6.addActionListener(this);
		song6.setFocusable(false);
		song6.setBorder(BorderFactory.createEtchedBorder());
		song6.setBackground(Color.gray);
		song6.setForeground(Color.black);
		
		song7.setText("Add Song");
		song7.addActionListener(this);
		song7.setFocusable(false);
		song7.setBorder(BorderFactory.createEtchedBorder());
		song7.setBackground(Color.gray);
		song7.setForeground(Color.black);
		
		song8.setText("Add Song");
		song8.addActionListener(this);
		song8.setFocusable(false);
		song8.setBorder(BorderFactory.createEtchedBorder());
		song8.setBackground(Color.gray);
		song8.setForeground(Color.black);
		
		song8.setText("Add Song");
		song9.addActionListener(this);
		song8.setFocusable(false);
		song8.setBorder(BorderFactory.createEtchedBorder());
		song8.setBackground(Color.gray);
		song8.setForeground(Color.black);
	
		song9.setText("Add Song");
		song9.setFocusable(false);
		song9.setBorder(BorderFactory.createEtchedBorder());
		song9.setBackground(Color.gray);
		song9.setForeground(Color.black);
		
		
		
		//----------LABELS----------
		
		titleLabel.setText("Main Menu");
		titleLabel.setOpaque(true);
		titleLabel.setBounds(275,0,100,100);
		titleLabel.setBackground(Color.gray);
		titleLabel.setForeground(Color.white);
		
		
		
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
		
		
		buttonsPanel1.setLayout(new GridLayout());
		buttonsPanel1.setBackground(Color.gray);
		buttonsPanel1.setOpaque(true);
		buttonsPanel1.setBounds(50,175,600,150);
		buttonsPanel1.add(song1);
		buttonsPanel1.add(song2);
		buttonsPanel1.add(song3);
		
		buttonsPanel2.setLayout(new GridLayout());
		buttonsPanel2.setBackground(Color.gray);
		buttonsPanel2.setOpaque(true);
		buttonsPanel2.setBounds(50,325,600,150);
		buttonsPanel2.add(song4);
		buttonsPanel2.add(song5);
		buttonsPanel2.add(song6);
		
		buttonsPanel3.setLayout(new GridLayout());
		buttonsPanel3.setBackground(Color.gray);
		buttonsPanel3.setOpaque(true);
		buttonsPanel3.setBounds(50,475,600,150);
		buttonsPanel3.add(song7);
		buttonsPanel3.add(song8);
		buttonsPanel3.add(song9);
		
		
	
		
		//-------LAYERED_PANES-------
		
		layeredPane.add(backgroundPanel, Integer.valueOf(0));
		layeredPane.add(buttonsPanel1, Integer.valueOf(1));
		layeredPane.add(buttonsPanel2, Integer.valueOf(1));
		layeredPane.add(buttonsPanel3, Integer.valueOf(1));
		layeredPane.add(titlePanel, Integer.valueOf(1));
		
		layeredPane.setSize(720,720);
		
		
		//----------FRAME-----------
		MenuFrame.setResizable(false);
		MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuFrame.setSize(720,720);
		MenuFrame.setVisible(true);
		
		MenuFrame.add(layeredPane);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == song1) {
			new RecWin("Space Song", "C://Users/caleb/Code/Java/record-player/res/playlist/SpaceSong.wav");
			MenuFrame.dispose();
		}	
		
		if (e.getSource() == song2) {
			new RecWin("Nunca Es Suficiente", "C://Users/caleb/Code/Java/record-player/res/playlist/NuncaEsSuficiente.wav");
			MenuFrame.dispose();
		}	
		
		if (e.getSource() == song3) {
			new RecWin("Pokemon", "C://Users/caleb/Code/Java/record-player/res/playlist/PokeSong.wav");
			MenuFrame.dispose();
		}	
	}
	
}
