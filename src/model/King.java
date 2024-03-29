package model;

import java.lang.ArrayIndexOutOfBoundsException;

public class King extends Piece{
	
	//Construtor
	public King(int cor){
		super(cor);
	}
    
	public String toString() {
		if(cor == 1) {
			return "White King";
		}else {
			return "Black King";
		}
	}
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Board tab) {	
		try {
			//Andar normal
			if(this.conferePos(colunaFim, linhaFim)) {
				Piece pec = tab.getPeca(linhaFim, colunaFim);
				int linha = linhaFim - linhaIni;
				int coluna = colunaFim - colunaIni;
				if (pec == null||(this.cor != pec.cor)) {
					if(Math.abs(linha) <= 1 && Math.abs(coluna) <=1) {
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
							this.primMov = false;
							return true;
					}			
				}
				//roque
				//confere se é o primeiro movimento
				if ((this.primMov)) {
					Piece rook;
					rook = tab.getPeca(linhaFim, colunaFim);
					//confere se a peça no canto é torre
					if(rook instanceof Rook) {
						if(rook.cor == this.cor) {
							//confere se é o primeiro movimento da torre
							if(rook.primMov) {
								//direita vazia 
								if(coluna>0 
										&&(tab.getPeca(linhaIni,colunaIni+1) == null)
										&&(tab.getPeca(linhaIni,colunaIni+2) == null)) {
									System.out.println(rook);
									tab.setPeca(linhaIni, colunaIni+2, this);
									tab.setPeca(linhaIni, colunaIni, null);
									tab.setPeca(linhaIni, colunaIni+1, rook);
									tab.setPeca(linhaFim, colunaFim, null);
									this.primMov = false;
									return true;
								//Esquerda vazia
								}else if(coluna<0 
										&& (tab.getPeca(linhaIni, colunaIni-1) == null)
										&&((tab.getPeca(linhaIni, colunaIni-2) == null)
										&&(tab.getPeca(linhaIni, colunaIni-3) == null))) {
									tab.setPeca(linhaIni, colunaIni-2, this);
									tab.setPeca(linhaIni, colunaIni, null);
									tab.setPeca(linhaIni, colunaIni-1, rook);
									tab.setPeca(linhaFim, colunaFim, null);
									this.primMov = false;
									return true;
								}
							}
						}
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa \n");
		}
		return false;
	}
}