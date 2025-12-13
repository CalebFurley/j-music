package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import gui.MainMenuPanel;
import gui.Window;


public class Main {
	
	private static ArrayList<String> userSettings;
	private static Window window;
	private static MainMenuPanel mainMenu;
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		initBackend();
		initFrontend();
		
		window.addComponent(mainMenu);
		window.tweakComponent(0).setVisible(true);
		
		//TODO read in all the songs in the users playlist directory!
		//TODO play some songs via terminal
		//TODO setup the menu gui
		//TODO setup the song gui
		//TODO setup the file selector for loading a song or playlist
	}
	
	
	
	
	/**
	 * Initializes the back end of the application.
	 * 
	 * @throws FileNotFoundException if the settings file is not found.
	 */
	private static void initBackend() throws FileNotFoundException {
		userSettings = loadSettings("res/settings.txt");
	}
	
	/**
	 * Initializes the front end of the application.
	 */
	private static void initFrontend() {
		window = new Window("J-Music");
		mainMenu = new MainMenuPanel();
	}
	
	
	
	/**
	 * Loads the settings for the J-Music application.
	 * 
	 * @return an array containing the settings the user
	 * 			has set for the application.
	 * @throws FileNotFoundException 
	 */
	private static ArrayList<String> loadSettings(String settingsPath) throws FileNotFoundException {
		
		/**
		 * userSettings[0] = users playlist filepath
		 */
		
		ArrayList<String> settingsArray = new ArrayList<String>();
		
		File settingsFile = new File(settingsPath);
		Scanner fileReader = new Scanner(settingsFile);
		
		while (fileReader.hasNext()) {
			String settingLine = fileReader.nextLine();
			String setting = settingLine.split(" = ")[1];
			settingsArray.add(setting);		
		}
		 
		fileReader.close();
		 
		return settingsArray;
	}
	
}