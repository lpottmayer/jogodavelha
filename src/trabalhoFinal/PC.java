package trabalhoFinal;

public class PC {
	
	private Mapa mapa;
	private char letra = 'O';
	
	public PC(Mapa mapa) {
		this.mapa = mapa;
	}
	
	public boolean jogar() {
		
		while (true) {
			int linha = this.mapa.sortear(0, 3);
			int coluna = this.mapa.sortear(0, 3);
			
			if (this.mapa.jogar(linha, coluna, letra)) {
				if (this.mapa.verificarGanhador(letra)) {
					System.out.println(" ... PC GANHOU!");
					return true;
				}
				
				break;
			}
		}
		
		return false;
	}

}
