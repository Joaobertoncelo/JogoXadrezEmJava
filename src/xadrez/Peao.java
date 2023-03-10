package xadrez;

public class Peao extends Peca{
	
	
	//Construtor
	public Peao(int cor){
       super(cor);
	}
	
	public String representa(int cor) {
		if(cor == 1) {
			return "P";
		}else {
			return "p";
		}
	}
	
	public void andar() {
		
	}
}
