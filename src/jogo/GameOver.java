package jogo;

import java.awt.Color;
import java.awt.Font;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class GameOver {
	
	public GameOver(Window janela) {
		Keyboard teclado = janela.getKeyboard();
		Som.play("gameover.mid");
		GameImage gameover = new GameImage(URL.sprite("game-over.png"));
		gameover.draw();
		boolean restart = false;
		int kills = Cenario.kills;
		janela.drawText("Você matou " + kills + " zumbis!!!", 500, 500, Color.red, new Font("Arial",3, 20));
		janela.update();
		Cenario.kills = 0;
		do {
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				restart = true;
				Jogador.energia = 2000;
				Som.stop();
			}
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				System.exit(0);
			}
		} while(restart == false);
	}
}