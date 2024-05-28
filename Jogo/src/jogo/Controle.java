package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {
    
    // Método para verificar colisão entre um objeto e um tile
    public boolean colisao(GameObject obj, TileInfo tile) {
        // Verifica se o ID do tile é maior ou igual a 7 (representando tiles sólidos) e se há colisão entre o objeto e o tile
        if ((tile.id >= 7) && obj.collided(tile)) {
            return true; // Retorna verdadeiro se houver colisão
        }
        return false; // Retorna falso se não houver colisão
    }
}
