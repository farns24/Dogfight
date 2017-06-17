package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
  private void playSound(String file)
  {
	    try {
	         // Open an audio input stream.           
	          File soundFile = new File(file); //you could also get the sound file with an URL
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
  }
  
  public void fireGuns()
  {
	  playSound("/users/guest/f/farns24/workspace/DogFight/guns.wav");
	  playSound("/users/guest/f/farns24/workspace/DogFight/guns.wav");
	  playSound("/users/guest/f/farns24/workspace/DogFight/guns.wav");
  }
  
  public void fly()
  {
	  playSound("/users/guest/f/farns24/Desktop/Your turn.wav");
  }
}
