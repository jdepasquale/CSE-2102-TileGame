package mainpackage.tilegame.Audio;

import java.applet.AudioClip;

public class AudioClips {

	public static AudioClip gamOver;
	public static AudioClip mainTheme;
	public static AudioClip traveling;
	public static AudioClip healthDrop;
	public static AudioClip itemGet;
	
	public static void init(){
		mainTheme = AudioClipLoader.loadAudioClip("/audioFiles/Traveling.wav");
		traveling = AudioClipLoader.loadAudioClip("/audioFiles/MainTheme.wav");
		gamOver = AudioClipLoader.loadAudioClip("/audioFiles/GameOver.wav");
		healthDrop = AudioClipLoader.loadAudioClip("/audioFiles/HealthDrop.wav");
		itemGet = AudioClipLoader.loadAudioClip("/audioFiles/ItemGet.wav");
	}
}
