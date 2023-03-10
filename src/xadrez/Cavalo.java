package xadrez;

public class Cavalo extends Peca{
	
	
	//Construtor
	public Cavalo(int cor) {
		super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "C";
		}else {
			return "c";
		}
	}
	
	public void andar() {
		
	}
}
