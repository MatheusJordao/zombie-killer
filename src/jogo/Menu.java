package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Menu {

	public Menu(Window janela) {
		GameImage plano = new GameImage(URL.sprite("menu.jpg"));
		Keyboard teclado = janela.getKeyboard();
		Som.play("Thriller.mid");
		boolean jogar = false;
		do {
			plano.draw();
			janela.update();
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				jogar = true;
				Som.stop();				
			}
		} while(jogar == false);
	}
}