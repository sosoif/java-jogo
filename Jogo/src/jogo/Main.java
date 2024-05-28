package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Main {

    public static void main(String[] args) {
        // Cria uma janela com dimensões 800x600 pixels
        Window janela = new Window(800, 600);
        
        // Carrega uma imagem de fundo para a janela
        GameImage plano = new GameImage(URL.sprite("menu.png"));
        
        // Obtém o teclado associado à janela
        Keyboard teclado = janela.getKeyboard();

        // Loop principal do jogo
        while (true) {
            // Desenha a imagem de fundo na janela
            plano.draw();
            
            // Atualiza a janela
            janela.update();

            // Verifica se a tecla ENTER foi pressionada
            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                // Inicia o primeiro cenário do jogo
                new Cenario1(janela);
            }
            
            // Verifica se a tecla ESCAPE foi pressionada
            if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
                // Fecha a janela e encerra o jogo
                janela.exit();
            }
        }
    }
}
