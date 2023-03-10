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
	
/*	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim) {
		
		Peca tab[][] = tab.getTabuleiro();
		
		if (tab.tabuleiro[linhaFim][colunaFim] == "-") {
			
		}
	}*/
}