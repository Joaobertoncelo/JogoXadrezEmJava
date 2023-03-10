package xadrez;

public class Bispo extends Peca{
	
	
	//Construtor
	public Bispo(int cor) {
		super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "B";
		}else {
			return "b";
		}
	}
	
	public void andar() {
		
	}
}
