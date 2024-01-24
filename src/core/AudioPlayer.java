package core;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	
	public static Clip clip;
	public static AudioInputStream audioStream;
	
	
	public static void load(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File currentSong = new File(songPath);
		audioStream = AudioSystem.getAudioInputStream(currentSong);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
	}
	
	public static void play() throws LineUnavailableException, IOException {
		clip.start();
	}
	
	public static void pause() {
		clip.stop();
	}
	
	public static boolean rewind() {
		clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 200000);
		if (clip.getMicrosecondPosition() == 0) {
			return false;
		}
		return true;
	}
	
	public static boolean fastForward() {
		clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 200000);
		if (clip.getMicrosecondPosition() == 0) {
			return false;
		}
		return true;
	}
	
	public static void myClose() {
		clip.close();
	}
}
