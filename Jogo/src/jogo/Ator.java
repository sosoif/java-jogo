package jogo;

import java.awt.Point;
import java.util.Vector;  

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite{
	
	// Variáveis para controlar a direção, velocidade e estado de movimento do ator
	protected int direcao = 3; // Direção padrão (3 é para frente)
	double velocidade = 1; // Velocidade de movimento
	boolean movendo = false; // Indica se o ator está se movendo ou não
	
	Controle controle = new Controle(); // Instância da classe Controle para verificar colisões
	public double energia = 1000; // Energia ou vida do ator, com um valor inicial de 1000
	
	// Construtor da classe Ator
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames); // Chama o construtor da classe Sprite, definindo a imagem e o número de frames
	}
	
	/**
	 * Método para controlar o movimento do ator e evitar colisões com objetos na cena
	 * @param cena A cena onde o ator está
	 */
	public void caminho(Scene cena) {
		Point min = new Point((int)this.x, (int)this.y); // Ponto mínimo do ator
		Point max = new Point((int)this.x, (int)this.y + this.height); // Ponto máximo do ator
		
		Vector<?> tiles = cena.getTilesFromPosition(min, max); // Obtém os tiles próximos ao ator
		
		// Itera sobre os tiles para verificar colisões
		for(int i = 0; i < tiles.size(); i++) {
			TileInfo tile = (TileInfo) tiles.elementAt(i); // Obtém o tile atual
			
			// Verifica se houve colisão com o tile
			if(controle.colisao(this, tile)) {
				// Verifica se houve colisão vertical
				if(colisaoVertical(this, tile)) {
					// Se o ator estiver acima do tile, ajusta sua posição para não ultrapassá-lo por baixo
					if (tile.y + tile.height - 2 < this.y) {
						this.y = tile.y + tile.height;
					}
					// Se o ator estiver abaixo do tile, ajusta sua posição para não ultrapassá-lo por cima
					else if (tile.y > this.y + this.height - 2) {
						this.y = tile.y - this.height; 
					}
				}
				// Verifica se houve colisão horizontal
				if(colisaoHorizontal(this, tile)) {
					// Se o ator estiver à direita do tile, ajusta sua posição para não ultrapassá-lo pela esquerda
					if(tile.x > this.x + this.width - 2) {
						this.x = tile.x - this.width;
					} else { // Se estiver à esquerda, ajusta sua posição para não ultrapassá-lo pela direita
						this.x = tile.x + tile.width;
					}
				}
			}
		}
	}
	
	// Método para verificar colisão vertical entre dois objetos
	private boolean colisaoVertical(GameObject obj, GameObject obj2) {
		// Verifica se não há sobreposição vertical entre os objetos
		if(obj2.x + obj2.width <= obj.x)
			return false;
		if(obj.x + obj.width <= obj2.x)
			return false;
		return true; // Retorna true se houver colisão vertical
	}
	
	// Método para verificar colisão horizontal entre dois objetos
	private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
		// Verifica se não há sobreposição horizontal entre os objetos
		if(obj2.y + obj2.height <= obj.y)
			return false;
		if(obj.y + obj.height <= obj2.y)
			return false;
		return true; // Retorna true se houver colisão horizontal
	}	
}

