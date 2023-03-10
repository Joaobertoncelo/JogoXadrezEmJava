package xadrez;

public class Cavalo extends Peca{
	
	
	//Construtor
	public Cavalo(int cor) {
		super(cor);
	}
	
	public String representa(int cor) {
		if(cor == 1) {
			return "C";
		}else {
			return "c";
		}
	}
	
	public void andar() {
		
	}
}
