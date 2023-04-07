package model;

public class Queen extends Piece{
    
	
	//Construtor
    public Queen(int cor){
        super(cor);
    }
    
	public String toString() {
		if(cor == 1) {
			return "D";
		}else {
			return "d";
		}
	}
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Board tab) {
		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Piece pec = tab.getPeca(linhaFim, colunaFim);
				if (pec == null||(this.cor != pec.cor)) {
					int i,j;
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
					//Andar na diagonal
					}else if(Math.abs(linha) == Math.abs(coluna)) {
						if(linhaFim > linhaIni && colunaFim > colunaIni) {
							j=colunaIni+1;
							for(i=linhaIni+1; i<linhaFim; i++) {
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j++;
							}
						}else if(linhaFim < linhaIni && colunaFim < colunaIni){
							j=colunaIni-1;
							for(i=linhaIni-1; i>linhaFim; i--) {
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j--;
							}
						}else if(linhaFim < linhaIni && colunaFim > colunaIni) {
							j=colunaIni+1;
							for(i=linhaIni-1; i>linhaFim; i--) {
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j++;
							}
						}else if(linhaFim > linhaIni && colunaFim < colunaIni){
							j=colunaIni-1;
							for(i=linhaIni+1; i<linhaFim; i++) {
								if(tab.getPeca(i, j) != null) {
									return false;
								}
								j--;
							}
						}
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
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

