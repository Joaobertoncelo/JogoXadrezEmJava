package xadrez;

public class Torre extends Peca{
	
	public Torre(int cor){
	    super(cor);
	}
	
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
