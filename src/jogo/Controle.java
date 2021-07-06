package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {

	public boolean colisao(GameObject obj, TileInfo tile) {
		if((tile.id>=40) && obj.collided(tile)) {
			return true;
		}
		else
			return false;
	}
}