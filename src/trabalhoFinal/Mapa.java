package trabalhoFinal;

import java.util.Iterator;

public class Mapa {
	
	private char[][] mapa = new char[3][3];
	
	public int sortear(int inicio, int fim) {
		return (int) ((Math.random() * fim) - inicio);
	}
	
	public void limpar() {
		for (int linha = 0; linha < this.mapa.length; linha++) {
			for (int coluna = 0; coluna < this.mapa[linha].length; coluna++) {
				this.mapa[linha][coluna] = ' ';
			}
		}
	}
	
	public void desenhar(int jogada) {
		System.out.println("---------- .. Jogada: " + jogada + " .. ----------");
		
		for (int linha = 0; linha < this.mapa.length; linha++) {
			System.out.print("| ");
			for (int coluna = 0; coluna < this.mapa[linha].length; coluna++) {
				System.out.print(this.mapa[linha][coluna] + " | ");
			}
			System.out.println("");
		}
		
		System.out.println("-----------------------------------------");
	}
	
	public boolean jogar(int linha, int coluna, char jogador) {
		if (this.mapa[linha][coluna] == ' ') {
			this.mapa[linha][coluna] = jogador;
			return true;
		}
		
		return false;
	}
	
	public boolean verificarGanhador(char jogador) { 
		
		// Verificando as linhas
		for (int linha = 0; linha < this.mapa.length; linha++) {
			if (this.mapa[linha][0] == jogador && 
				this.mapa[linha][1] == jogador && 
				this.mapa[linha][2] == jogador) {
				return true;
			}
		}
		
		// Verificando as colunas
		for (int coluna = 0; coluna < this.mapa.length; coluna++) {
			if (this.mapa[0][coluna] == jogador &&
				this.mapa[1][coluna] == jogador &&
				this.mapa[2][coluna] == jogador) {
				return true;
			}
		}
		
		// Verificando diagonais
		if (this.mapa[0][0] == jogador &&
			this.mapa[1][1] == jogador &&
			this.mapa[2][2] == jogador) {
			return true;
		}
		
		if (this.mapa[0][2] == jogador &&
			this.mapa[1][1] == jogador &&
			this.mapa[2][0] == jogador) {
			return true;
		}
		
		return false;
	}

}
