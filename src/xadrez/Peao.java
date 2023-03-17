package xadrez;

public class Peao extends Peca{
	
	
	//Construtor
	public Peao(int cor){
       super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "P";
		}else {
			return "p";
		}
	}
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		
	}
}
