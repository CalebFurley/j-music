package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainMenuPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 7190206586574118684L;	
	
	// Constructor
	public MainMenuPanel() {
		this.setLayout(new FlowLayout());
		this.setVisible(false);
		this.setBackground(Color.DARK_GRAY);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
