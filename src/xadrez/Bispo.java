package xadrez;

public class Bispo extends Peca{
	
	public Bispo(int cor) {
		super(cor);
	}
	
	public String representa(int cor) {
		if(cor == 1) {
			return "B";
		}else {
			return "b";
		}
	}
	
	public void andar() {
		
	}
}
