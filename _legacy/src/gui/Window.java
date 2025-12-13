package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Window class that is built with a BorderLayout in mind.
 * 
 * @author Caleb Furley
 * @version 0.1
 */
public class Window extends JFrame {
	private static final long serialVersionUID = -2942795671868336730L;
	
	// Screen size variables //
	private static int screenWidth = 1920;
	private static int screenHeight = 1080;
	private static int windowWidth = 1280;
	private static int windowHeight = 720;
	private static int windowPosX = screenWidth/2 - windowWidth/2;
	private static int windowPosY = screenHeight/2 - windowHeight/2;
	
	
	private ArrayList<JComponent> components = new ArrayList<JComponent>();
	
	/**
	 * Constructor for the window class, builds a window
	 * with the given windowName and using a BorderLayout/
	 * 
	 * @param windowName the title of the window.
	 */
	public Window(String windowName) {
		// setup 
		this.setTitle(windowName);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(windowPosX, windowPosY, 1280, 720);
		this.setVisible(true);
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		
		
		// here we up set the panels
		JPanel northPanel = new JPanel();
		northPanel.setBackground(Color.BLACK);
		northPanel.setPreferredSize(new Dimension(69,69));
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.BLACK);
		southPanel.setPreferredSize(new Dimension(69,69));
	
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.DARK_GRAY);
		// no need to set preferred size for center
		
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.BLACK);
		westPanel.setPreferredSize(new Dimension(69,69));
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.BLACK);
		eastPanel.setPreferredSize(new Dimension(69,69));
		
		
		// here we add panels to frame but add another param
		// that includes the BorderLayout.LOCATION
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		
	}
	
	/**
	 * Getter method to retrieve the components the window frame
	 * contains.
	 * 
	 * @return a copy of the ArrayList holding the components
	 * 			of the frame.
	 */
	public ArrayList<JComponent> getComponentsArray() {
		return new ArrayList<JComponent>(this.components);
	}
	
	/**
	 * Used to tweak one of the components the window
	 * contains.
	 * 
	 * @param idx the index of the component to tweak.
	 * @return the component to tweak.
	 */
	public JComponent tweakComponent(int idx) {
		return this.components.get(idx);
	}
	
	
	/**
	 * Method to add components to the window frame, as well
	 * as store them in the components array.
	 * 
	 * @param component the JComponent to add to the frame.
	 */
	public void addComponent(JComponent component) {
		this.add(component, BorderLayout.CENTER);
		this.components.add(component);
	}
	
	
}
