package xadrez;

public class Dama extends Peca{
    
	
	//Construtor
    public Dama(int cor){
        super(cor);
    }
    
	public String toString() {
		if(cor == 1) {
			return "D";
		}else {
			return "d";
		}
	}
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				if (pec == null) {
					Boolean camLivre = true;
					int linha = linhaFim - linhaIni;
					int coluna = colunaFim - colunaIni;
					if((Math.abs(linha) == 0 && Math.abs(coluna) != 0)) {
						for(int i=colunaIni; i<colunaFim; i++) {
							if(tab.getPeca(linhaIni, i) != null) {
								camLivre = false;
							}
						}
						if (camLivre) {
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
						}else {
							//exceção
						}
					}else if((Math.abs(linha) != 0 && Math.abs(coluna) == 0)){
						for(int i=linhaIni; i<linhaFim; i++) {
							if(tab.getPeca(i, colunaIni) != null) {
								camLivre = false;
							}
						}
						if (camLivre) {
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
						}else {
							//exceção
						}
					}else if(Math.abs(linha) == Math.abs(coluna)) {
						
						for(int i=linhaIni; i<linhaFim; i++) {
							int j = colunaIni;
							if(tab.getPeca(i, j) != null) {
								camLivre = false;
							}
							j++;
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

