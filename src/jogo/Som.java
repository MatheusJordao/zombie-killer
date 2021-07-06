package jogo;

import jplay.Sound;
import jplay.URL;

public class Som {

	private static Sound musica;
	
	public static void play(String audio) {
		musica = new Sound(URL.audio(audio));
		Som.musica.play();
		Som.musica.setRepeat(true);
	}
	
	public static void stop() {
		if(Som.musica != null) {
			musica.stop();
		}	
	}
	public static void pause() {
		if(Som.musica != null) {
			musica.pause();
		}
	}
}