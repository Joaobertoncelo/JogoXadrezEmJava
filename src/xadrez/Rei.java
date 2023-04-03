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
				if ((this.primMov)) {
					System.out.println("é o primeiro movimento");
					Peca torre;
					torre = tab.getPeca(colunaFim, linhaFim);
					if(torre instanceof Torre) {
						System.out.println("é Torre");
						if(torre.primMov) {
							System.out.println("é o primeiro movimento da torre");
							if(coluna>0 
									&&(tab.getPeca(linhaIni,colunaIni+1) == null)
									&&(tab.getPeca(linhaIni,colunaIni+2) == null)) {
								System.out.println("direita vazia");
								tab.setPeca(linhaIni, colunaIni+2, this);
								tab.setPeca(linhaIni, colunaIni, null);
								tab.setPeca(linhaIni, colunaIni+1, torre);
								tab.setPeca(linhaFim, colunaFim, null);
								this.primMov = false;
							}else if(coluna<0 
									&& (tab.getPeca(linhaIni, colunaIni-1) == null)
									&&((tab.getPeca(linhaIni, colunaIni-2) == null)
									&&(tab.getPeca(linhaIni, colunaIni-3) == null))) {
								System.out.println("Esquerda Vazia");
								tab.setPeca(linhaIni, colunaIni-2, this);
								tab.setPeca(linhaIni, colunaIni, null);
								tab.setPeca(linhaIni, colunaIni-1, torre);
								tab.setPeca(linhaFim, colunaFim, null);
								this.primMov = false;								
							}
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