package jogo;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario {
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Zumbi zumbi[];
	Random gerador = new Random();
	static int kills = 0;
	boolean sair = true;
	
	public Cenario(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		jogador = new Jogador(300, 350);
		teclado = janela.getKeyboard();
		Som.play("ChildrenGrave.mid");
		zumbi = new Zumbi[10];
		run();
	}
	
	private void run() {
		for (int i = 0; i < zumbi.length; i++) {
			zumbi[i] = new Zumbi(gerador.nextInt(416) + 192, gerador.nextInt(472) + 128);
		}		
		do {
			cena.moveScene(jogador);
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.draw();
			
			for (int i = 0; i < zumbi.length; i++) {
				zumbi[i].caminho(cena);
				zumbi[i].perseguir(jogador.x, jogador.y);
				zumbi[i].x += cena.getXOffset();
				zumbi[i].y += cena.getYOffset();
				kills = kills + zumbi[i].contadorKills();
				zumbi[i].morrer(janela, cena);
				zumbi[i].atacar(jogador, janela);
				zumbi[i].draw();
				jogador.atirar(janela, cena, teclado, zumbi[i]);
			}
			janela.drawText("Kills: " + kills, 600, 30, Color.red, new Font("Arial",3, 20));
			janela.drawText("Energia: " + Math.round(Jogador.energia), 30, 30, Color.green);
			janela.delay(2);
			janela.update();
			
			if(teclado.keyDown(Keyboard.ESCAPE_KEY)) {
				new Pause(janela);
			}
			if(Jogador.energia <= 0) {
				sair = false;
				Som.stop();
			}
		} while (sair != false);
	}
}