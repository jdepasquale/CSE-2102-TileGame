package mainpackage.tilegame.Audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;

public class AudioClipLoader {
	public static AudioClip loadAudioClip(String path){
		try {
			return Applet.newAudioClip(AudioClipLoader.class.getResource(path));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
