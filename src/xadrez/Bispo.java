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
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		try{
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				if (pec == null||(this.cor != pec.cor)) {
					int i, j;
					int linha = linhaFim - linhaIni;
					int coluna = colunaFim - colunaIni;
					if(Math.abs(linha) == Math.abs(coluna)) {
						if(linhaFim > linhaIni && colunaFim > colunaIni) {
							System.out.println("linha fim > linha ini");
							j=colunaIni+1;
							System.out.println("1");
							for(i=linhaIni+1; i<linhaFim; i++) {
								System.out.printf("peca: " + i + j + "\n");
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j++;
							}
						}else if(linhaFim < linhaIni && colunaFim < colunaIni){
							j=colunaIni-1;
							System.out.println("2");
							for(i=linhaIni-1; i>linhaFim; i--) {
								System.out.printf("peca: " + i + j + "\n");
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j--;
							}
						}else if(linhaFim < linhaIni && colunaFim > colunaIni) {
							j=colunaIni+1;
							System.out.println("3");
							for(i=linhaIni-1; i>linhaFim; i--) {
								System.out.printf("peca: " + i + j + "\n");
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j++;
							}
						}else if(linhaFim > linhaIni && colunaFim < colunaIni){
							j=colunaIni-1;
							System.out.println("4");
							for(i=linhaIni+1; i<linhaFim; i++) {
								System.out.printf("peca: " + i + j + "\n");
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j--;
							}
						}
					}
				}
			}
			System.out.println("caminho livre");
			tab.setPeca(linhaFim, colunaFim, this);
			tab.setPeca(linhaIni, colunaIni, null);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
		return true;
	}
}
