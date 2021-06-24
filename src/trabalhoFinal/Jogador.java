package trabalhoFinal;
import java.util.Scanner;

public class Jogador {
	
	private Mapa mapa;
	private char letra = 'X';
	
	public Jogador(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public boolean jogar(Scanner teclado) {
		while (true) {
			System.out.println("Insira a linha: ");
			int linha = teclado.nextInt();
			
			if (linha < 0 || linha > 2) {
				continue;
			}
			
			System.out.println("Insira a coluna: ");
			int coluna = teclado.nextInt();
			
			if (coluna < 0 || coluna > 2) {
				continue;
			}
			
			if (this.mapa.jogar(linha, coluna, letra)) {
				if (this.mapa.verificarGanhador(letra)) {
					System.out.println(" ... Jogador GANHOU!");
					return true;
				}
				
				break;
			}
		}
		
		return false;
	}
}