package xadrez;

public class Bispo extends Peca{
	
	
	//Construtor
	public Bispo(int cor) {
		super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "B";
		}else {
			return "b";
		}
	}
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		try{
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				if (pec == null||(this.cor != pec.cor)) {
					int linha = linhaFim - linhaIni;
					int coluna = colunaFim - colunaIni;
					if(Math.abs(linha) == Math.abs(coluna)) {
						Boolean camLivre = true;
						if(linhaFim > linhaIni) {
							for(int i=linhaIni+1; i<linhaFim; i++) {
								int j=colunaIni+1;
								if(tab.getPeca(i, j) != null) {
									System.out.println("Caminho não livre");
									camLivre = false;
								}
								j++;
							}
						}else {
							for(int i=linhaIni-1; i>linhaFim; i--) {
								int j=colunaIni-1;
								if(tab.getPeca(i, j) != null) {
									System.out.println("Caminho não livre");
									camLivre = false;
								}
								j--;
							}
						}
						if (camLivre) {
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
						}
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
	}
}
