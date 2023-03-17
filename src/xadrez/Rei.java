package xadrez;

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
		Peca pec = tab.getPeca(linhaFim, colunaFim);
		if (pec == null) {
			int linha = linhaFim;
			int coluna = colunaFim;
			if(Math.abs(linha) <= 1 && Math.abs(coluna) <=1) {
				tab.setPeca(linhaFim, colunaFim, this);
				tab.setPeca(linhaIni, colunaIni, null);
			}else {
				//Criar classe de excessão
			}
		}
	}
}