package mainpackage.tilegame.Audio;

import java.applet.AudioClip;

public class AudioClips {

	public static AudioClip fg;
	public static AudioClip mT;
	
	public static void init(){
		fg = AudioClipLoader.loadAudioClip("/audioFiles/Feelin'Good.wav");
		mT = AudioClipLoader.loadAudioClip("/audioFiles/MainTheme.wav");
	}
}
