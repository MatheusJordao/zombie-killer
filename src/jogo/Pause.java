package jogo;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;

public class Pause {
	public Pause(jplay.Window janela) {
		Keyboard teclado = janela.getKeyboard();
		
		while(true) {
			GameImage pause = new GameImage(URL.sprite("pause.png"));
			pause.draw();
			janela.update();
			//Som.pause();
			try {
				if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
					//Som.pause();
					break;
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}