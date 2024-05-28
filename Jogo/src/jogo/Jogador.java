package jogo;

import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Jogador extends Ator {

    private Keyboard teclado; // Teclado para controlar o jogador

    // Construtor da classe Jogador
    public Jogador(int x, int y, Keyboard teclado) {
        super(URL.sprite("jogador.png"), 20); // Chama o construtor da classe Ator, definindo a imagem e o número de frames
        this.x = x; // Define a posição inicial do jogador no eixo x
        this.y = y; // Define a posição inicial do jogador no eixo y
        this.teclado = teclado; // Inicializa o campo teclado com o teclado passado como parâmetro
        this.setTotalDuration(2000); // Define a duração total da animação do jogador
    }
    
    ControleTiro tiros = new ControleTiro(); // Instância da classe ControleTiro para gerenciar os tiros do jogador
    
    // Método para atirar
    public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
        // Verifica se a tecla A está pressionada
        if (teclado.keyDown(KeyEvent.VK_A)) {
            // Adiciona um tiro na cena na posição atual do jogador e na direção em que ele está
            tiros.adicionaTiro(x, y, direcao, cena);
        }
        // Executa o método para movimentar os tiros e verificar colisões com os inimigos
        tiros.run(inimigo);
    }

    // Método para controlar o movimento do jogador
    public void controle(Window janela) {
        boolean movendo = false; // Variável para indicar se o jogador está se movendo ou não

        // Verifica as teclas pressionadas para controlar o movimento do jogador
        if (teclado.keyDown(Keyboard.LEFT_KEY)) {
            moveLeft(); // Movimenta o jogador para a esquerda
            movendo = true; // Define que o jogador está se movendo
        } else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
            moveRight(janela); // Movimenta o jogador para a direita
            movendo = true; // Define que o jogador está se movendo
        } else if (teclado.keyDown(Keyboard.UP_KEY)) {
            moveUp(); // Movimenta o jogador para cima
            movendo = true; // Define que o jogador está se movendo
        } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
            moveDown(janela); // Movimenta o jogador para baixo
            movendo = true; // Define que o jogador está se movendo
        }

        // Se o jogador estiver se movendo, atualiza a animação dele
        if (movendo) {
            update();
            movendo = false;
        }
    }

    // Método para movimentar o jogador para a esquerda
    private void moveLeft() {
        if (this.x > 0) {
            this.x -= velocidade; // Movimenta o jogador para a esquerda
        }
        if (direcao != 1) {
            setSequence(4, 8); // Define a sequência de frames para a esquerda
            direcao = 1; // Define a direção para a esquerda
        }
        movendo = true; // Define que o jogador está se movendo
    }

    // Método para movimentar o jogador para a direita
    private void moveRight(Window janela) {
        if (this.x < janela.getWidth() - 60) {
            this.x += velocidade; // Movimenta o jogador para a direita
        }
        if (direcao != 2) {
            setSequence(8, 12); // Define a sequência de frames para a direita
            direcao = 2; // Define a direção para a direita
        }
        movendo = true; // Define que o jogador está se movendo
    }

    // Método para movimentar o jogador para cima
    private void moveUp() {
        if (this.y > 0) {
            this.y -= velocidade; // Movimenta o jogador para cima
        }
        if (direcao != 4) {
            setSequence(12, 16); // Define a sequência de frames para cima
            direcao = 4; // Define a direção para cima
        }
        movendo = true; // Define que o jogador está se movendo
    }

    // Método para movimentar o jogador para baixo
    private void moveDown(Window janela) {
        if (this.y < janela.getHeight() - 60) {
            this.y += velocidade; // Movimenta o jogador para baixo
        }
        if (direcao != 5) {
            setSequence(0, 4); // Define a sequência de frames para baixo
            direcao = 5; // Define a direção para baixo
        }
        movendo = true; // Define que o jogador está se movendo
    }
}

