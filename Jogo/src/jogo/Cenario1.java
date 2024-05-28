package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {
    
    private Window janela; // Janela do jogo
    private Scene cena; // Cena do jogo
    private Jogador jogador; // Instância do jogador
    private Keyboard teclado; // Teclado do jogo
    private Zumbi zumbi; // Instância do zumbi
    
    // Construtor da classe Cenario1
    public Cenario1(Window window) {
        janela = window; // Inicializa a janela com a janela passada como parâmetro
        cena = new Scene(); // Inicializa a cena
        cena.loadFromFile(URL.scenario("Cenario1.scn")); // Carrega a cena a partir de um arquivo de cenário
        teclado = janela.getKeyboard(); // Inicializa o teclado
        
        // Inicializa o jogador passando a posição inicial e o teclado
        jogador = new Jogador(640, 350, teclado);
        
        // Inicializa o zumbi com uma posição inicial fixa
        zumbi = new Zumbi(300, 300);
        
        // Método principal que executa o jogo
        run();
    }
    
    // Método principal que executa o jogo
    private void run() {
        while (true) { // Loop principal do jogo
            cena.draw(); // Desenha a cena na tela
            jogador.controle(janela); // Controla o jogador com base nas entradas do teclado
            jogador.caminho(cena); // Verifica o caminho do jogador na cena
            zumbi.caminho(cena); // Verifica o caminho do zumbi na cena
            zumbi.perseguir(jogador.x, jogador.y); // Faz o zumbi perseguir o jogador
            
            cena.moveScene(jogador); // Move a cena com base na posição do jogador
            
            // Atualiza as coordenadas do jogador com o deslocamento da cena
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            
            // Método para o jogador atirar nos zumbis
            jogador.atirar(janela, cena, teclado, zumbi);
            
            // Método para verificar se o zumbi morreu e realizar as ações correspondentes
            zumbi.morrer();
            
            // Atualiza as coordenadas do zumbi com o deslocamento da cena
            zumbi.x += cena.getXOffset();
            zumbi.y += cena.getYOffset();
            
            zumbi.draw(); // Desenha o zumbi na tela
            jogador.draw(); // Desenha o jogador na tela
            janela.update(); // Atualiza a janela do jogo
        }
    }
}
