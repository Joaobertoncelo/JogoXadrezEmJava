package xadrez;

public class Rei extends Peca{
    
	
	//Construtor
	public Rei(int cor){
		super(cor);
	}
    
	public String representa(int cor) {
		if(cor == 1) {
			return "R";
		}else {
			return "r";
		}
	}
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim) {
		
	}
}