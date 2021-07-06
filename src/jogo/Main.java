package jogo;
import jplay.Window;

public class Main {
	
	public static void main(String[] args) {
		
		Window janela = new  Window(800, 600);
		while(true) {
			new Menu(janela);
			new Cenario(janela);
			new GameOver(janela);
		}
	}
}