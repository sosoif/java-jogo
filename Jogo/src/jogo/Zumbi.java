package jogo;

import jplay.URL;

public class Zumbi extends Ator {

    // Construtor da classe Zumbi
    public Zumbi(int x, int y) {
        // Chama o construtor da classe pai (Ator) e define a imagem do zumbi e o número de frames
        super(URL.sprite("zumbi00.png"), 16);
        // Define a posição inicial do zumbi
        this.x = x;
        this.y = y;
        // Define a duração total da animação do zumbi
        this.setTotalDuration(2000);
        // Define a velocidade de movimento do zumbi
        this.velocidade = 0.3;
    }
    
    // Método para fazer o zumbi perseguir o jogador
    public void perseguir(double x, double y) {
        // Verifica a posição do jogador e move o zumbi em sua direção
        if (this.x > x && this.y <= y + 50 && this.y >= y - 50) {
            moveTo(x, y, velocidade);
            if (direcao != 1) {
                setSequence(5, 8);
                direcao = 1;
            }
            movendo = true;
        } else if (this.x < x && this.y <= y + 50 && this.y >= -50) {
            moveTo(x, y, velocidade);
            if (direcao != 2) {
                setSequence(9, 12);
                direcao = 2;
            }
            movendo = true;
        } else if (this.y < y) {
            moveTo(x, y, velocidade);
            if (direcao != 4) {
                setSequence(12, 16);
                direcao = 4;
            }
            movendo = true;
        } else if (this.y < y) { 
            moveTo(x, y, velocidade);
            if (direcao != 5) {
                setSequence(1, 4);
                direcao = 5;
            }
            movendo = true;
        }
        
        if (movendo) {
            update();
            movendo = false;
        }
    }

    // Método para fazer o zumbi morrer
    public void morrer() {
        // Verifica se a energia do zumbi é menor ou igual a zero (assumindo que energia é a vida do zumbi)
        if (this.energia <= 0) {
            // Se a energia for menor ou igual a zero, o zumbi morre
            this.velocidade = 0; // Define a velocidade do zumbi como zero, parando seu movimento
            this.direcao = 0; // Define a direção do zumbi como zero
            this.movendo = false; // Define que o zumbi não está mais se movendo
            this.x = 1_000_000; // Move o zumbi para uma posição muito distante, efetivamente removendo-o da tela
        }
    }
}
