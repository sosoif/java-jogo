package jogo;

import jplay.Sprite;
import jplay.URL;		

public class Tiro extends Sprite{
	
	// Constantes para definir a direção do tiro
	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
	
	// Velocidade do tiro
	protected static final int VELOCIDADE_TIRO = 1;
	
	// Variáveis para controlar a direção e movimento do tiro
	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = STOP; // Inicialmente o tiro está parado
	
	// Construtor da classe Tiro
	public Tiro(double x, double y, int caminho) {
		// Chama o construtor da classe Sprite, definindo a imagem do tiro e o número de frames
		super(URL.sprite("tiro.png"), 12);
		// Define a direção inicial e a posição inicial do tiro
		this.caminho = caminho;
		this.x = x;
		this.y = y;
	}
	
	// Método para movimentar o tiro
	public void mover() {
		// Verifica a direção do tiro e realiza o movimento correspondente
		if (caminho == LEFT) {
			// Move o tiro para a esquerda
			this.x -= VELOCIDADE_TIRO;
			// Verifica se a direção do tiro mudou e ajusta a sequência de frames
			if (direcao != LEFT) {
				setSequence(3, 6); // Define a sequência de frames para a esquerda
				direcao = LEFT; // Atualiza a direção do tiro
			}
			movendo = true; // Define que o tiro está se movendo
		}
		if (caminho == RIGHT) {
			// Move o tiro para a direita
			this.x += VELOCIDADE_TIRO;
			// Verifica se a direção do tiro mudou e ajusta a sequência de frames
			if (direcao != RIGHT) {
				setSequence(6, 9); // Define a sequência de frames para a direita
				direcao = RIGHT; // Atualiza a direção do tiro
			}
			movendo = true; // Define que o tiro está se movendo
		}
		if (caminho == UP) {
			// Move o tiro para cima
			this.y -= VELOCIDADE_TIRO;
			// Verifica se a direção do tiro mudou e ajusta a sequência de frames
			if (direcao != UP) {
				setSequence(9, 12); // Define a sequência de frames para cima
				direcao = UP; // Atualiza a direção do tiro
			}
			movendo = true; // Define que o tiro está se movendo
		}
		if (caminho == DOWN) {
			// Move o tiro para baixo
			this.y += VELOCIDADE_TIRO;
			// Verifica se a direção do tiro mudou e ajusta a sequência de frames
			if (direcao != DOWN) {
				setSequence(0, 3); // Define a sequência de frames para baixo
				direcao = DOWN; // Atualiza a direção do tiro
			}
			movendo = true; // Define que o tiro está se movendo
		}
	}
}
