package jogo;

import java.util.LinkedList;

import jplay.Scene;

public class ControleTiro {
    
    LinkedList<Tiro> tiros = new LinkedList<>(); // Lista encadeada para armazenar os tiros

    // Método para adicionar um tiro à cena
    public void adicionaTiro(double x, double y, int caminho, Scene cena) {
        Tiro tiro = new Tiro(x, y, caminho); // Cria um novo objeto Tiro na posição (x, y) com o caminho especificado
        tiros.addFirst(tiro); // Adiciona o tiro no início da lista de tiros
        cena.addOverlay(tiro); // Adiciona o tiro como uma overlay (sobreposição) na cena
    }
    
    // Método para movimentar os tiros e verificar colisões com um inimigo
    public void run(Ator inimigo) {
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst(); // Remove o primeiro tiro da lista
            tiro.mover(); // Move o tiro
            tiros.addLast(tiro); // Adiciona o tiro no final da lista
            
            // Verifica se houve colisão entre o tiro e o inimigo
            if (tiro.collided(inimigo)) {
                tiro.x = 10_000; // Move o tiro para fora da tela
                inimigo.energia -= 250; // Reduz a energia do inimigo
            }
        }
    }
}
