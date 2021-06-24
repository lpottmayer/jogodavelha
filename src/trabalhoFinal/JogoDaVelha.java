package trabalhoFinal;
import java.util.Scanner;

public class JogoDaVelha {
	
	private Mapa jogoMapa;
	private Jogador jogoJogador;
	private PC jogoPC;
	
	public JogoDaVelha() {
		Scanner teclado = new Scanner(System.in);
		
		this.jogoMapa = new Mapa();
		this.jogoJogador = new Jogador(this.jogoMapa);
		this.jogoPC = new PC(this.jogoMapa);
		
		char jogarNovamente = 's';
		
		do {
			
			jogar(teclado);
			
			System.out.println("Deseja jogar novamente? ");
			jogarNovamente = teclado.next().charAt(0);
			
		} while (jogarNovamente == 's');
	}
	
	private void jogar(Scanner teclado) {		
		// Limpar mapa
		this.jogoMapa.limpar();
		
		// Define quem joga
		boolean jogaPC = true;
		
		// Sortear primeira jogada
		if (this.jogoMapa.sortear(0, 2) == 0) {
			jogaPC = false;
		}
		
		// Nr de jogadas efetuadas
		int nrJogadas = 0;
		
		// Desenha Jogo da Velha
		this.jogoMapa.desenhar(nrJogadas);
		
		while (nrJogadas < 9) {
			nrJogadas++;
			
			// Joga PC
			if (jogaPC) {
				
				if (this.jogoPC.jogar()) {
					break;
				}
				
				jogaPC = !jogaPC;
				
			} else {
				// Joga Jogador
				
				if (this.jogoJogador.jogar(teclado)) {
					break;
				}
				
				jogaPC = !jogaPC;
			}
			
			this.jogoMapa.desenhar(nrJogadas);
		}
		
		this.jogoMapa.desenhar(nrJogadas);
		
		if (nrJogadas == 9) {
			System.out.println("Empatou");
		}
		
		System.out.println(".......... FIM ..........");
		
	}

	public static void main(String[] args) {
		new JogoDaVelha();
	}

}
