package xadrez;

public class Torre extends Peca{
	public String representa(int cor) {
		if(cor == 1) {
			return "T";
		}else {
			return "t";
		}
	}
	
	public void andar() {
		
	}
}
