package xadrez;

import java.lang.ArrayIndexOutOfBoundsException;

public class Rei extends Peca{
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
		if(this.conferePos(colunaFim, linhaFim)) {
			Peca pec = tab.getPeca(linhaFim, colunaFim);
			if (pec == null||(this.cor != pec.cor)) {
				int linha = linhaFim - linhaIni;
				int coluna = colunaFim - colunaIni;
				if(Math.abs(linha) <= 1 && Math.abs(coluna) <=1) {
					try {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println(e);
						System.out.println("A peça não pode ser movimentada nessa casa");
					}
				}			
			}
		}
	}
}