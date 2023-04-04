package xadrez;

public class Torre extends Peca{
	
	//Construtor
	public Torre(int cor){
	    super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "T";
		}else {
			return "t";
		}
	}
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				if ((pec == null)||(this.cor != pec.cor)) {
					int i;
					int linha = linhaFim - linhaIni;
					int coluna = colunaFim - colunaIni;
					//Andar na horizontal
					if((Math.abs(linha) == 0 && Math.abs(coluna) != 0)) {
						if(colunaFim > colunaIni) {
							for(i=colunaIni+1; i<colunaFim; i++) {
								if(tab.getPeca(linhaIni, i) != null) {
									return false;
								}
							}
						}else {
							for(i=colunaIni-1; i>colunaFim; i--) {
								if(tab.getPeca(linhaIni, i) != null) {
									return false;
								}
							}
						}
						tab.setPeca(linhaFim, colunaFim, null);
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						this.primMov = false;
					//Andar na vertical
					}else if((Math.abs(linha) != 0 && Math.abs(coluna) == 0)){
						if(linhaFim > linhaIni) {
							for(i=linhaIni+1; i<linhaFim; i++) {
								if(tab.getPeca(i, colunaIni) != null) {
									return false;
								}
							}
						}else {
							for(i=linhaIni-1; i>linhaFim; i--) {
								if(tab.getPeca(i, colunaIni) != null) {
									return false;
								}
							}
						}
						tab.setPeca(linhaFim, colunaFim, null);
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						this.primMov = false;
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
		return true;
	}
}

