package xadrez;

import java.lang.ArrayIndexOutOfBoundsException;

public class Rei extends Peca{
	private Boolean primMov = true;
	
	//Construtor
	public Rei(int cor){
		super(cor);
	}
    
	public String toString() {
		if(cor == 1) {
			return "R";
		}else {
			return "r";
		}
	}
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {	
		try {
			//Andar normal
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				int linha = linhaFim - linhaIni;
				int coluna = colunaFim - colunaIni;
				if (pec == null||(this.cor != pec.cor)) {
					if(Math.abs(linha) <= 1 && Math.abs(coluna) <=1) {
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
							this.primMov = false;
					}			
				}
				//roque
				if ((this.primMov) && (Math.abs(coluna) == 0 && Math.abs(linha) == 2)) {
					Peca torre;
					if((tab.getPeca(colunaIni+1, linhaIni) == null)&&(tab.getPeca(colunaIni+2, linhaIni) == null)) {
						torre = tab.getPeca(colunaIni+3, linhaIni);
						if(torre != null) {
							
						}
					}else if((tab.getPeca(colunaIni-1, linhaIni) == null)&&((tab.getPeca(colunaIni-2, linhaIni) == null)&&(tab.getPeca(colunaIni-3, linhaIni) == null))) {
						
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
	}
}