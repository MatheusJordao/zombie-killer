package jogo;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;

import jplay.Scene;
import jplay.TileInfo;
import jplay.URL;
import jplay.Window;

public class Zumbi extends Personagem {
	private double ataque = 1;
	Random gerador = new Random();
	int kills;
	public Zumbi(double d, double e) {
		super(URL.sprite("zumbi.png"), 16);
		this.x = d;
		this.y = e;
		this.setTotalDuration(2000);
		this.velocidade = 0.2;
	}
	public void perseguir(double x, double y) {
		if(Math.abs(x - this.x) <= 400 && Math.abs(y - this.y) <= 400) {
			if(this.x > x && this.y <= y + 50 && this.y >= y - 50) {
				moveTo(x, y, velocidade);
				if(direcao != 1) {
					setSequence(5, 8);
					direcao = 1;
				}
				movendo = true;
			}		
			else if(this.x < x &&  this.y <= y + 50 && this.y >= y - 50) {
				moveTo(x, y, velocidade);
				if(direcao!= 2) {
					setSequence(9, 12);
					direcao = 2;
				}
				movendo = true;
			}		
			else if(this.y > y) {
				moveTo(x, y, velocidade);
				if(direcao != 4) {
					setSequence(12, 16);
					direcao = 4;
				}
				movendo = true;
			}
			else if(this.y < y) {
				moveTo(x, y, velocidade);
				if(direcao != 5) {
					setSequence(1, 4);
					direcao = 5;
				}
				movendo = true;
			}		
			if(movendo) {
				update();
				movendo = false;
			}
		}
	}
	public void morrer(Window janela, Scene cena) {
		if(this.energia <= 0) {
			this.x = gerador.nextInt(800);
			this.y = gerador.nextInt(600);
			this.energia = 1000;
			Point min = new Point((int) this.x, (int) this.y);
			Point max = new Point((int) this.x + this.width, (int) this.y + this.height);
			
			Vector<?>tiles = cena.getTilesFromPosition(min, max);
			
			for(int i=0; i<tiles.size(); i++) {
				TileInfo tile = (TileInfo) tiles.elementAt(i);
				if(controle.colisao(this, tile)==true) {
					this.x = 500;
					this.y = 500;
				}
			}
		}
	}
	public int contadorKills() {
		if(this.energia <= 0) {
			return 1;
		}
		return 0;
	}

	public void atacar(Jogador jogador, Window janela) {
		if(this.collided(jogador)) {
			Jogador.energia -= this.ataque;
		}
	}
}