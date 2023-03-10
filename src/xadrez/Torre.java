package xadrez;

public class Torre extends Peca{
	
	
	//Construtor
	public Torre(int cor){
	    super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "T";
		}else {
			return "t";
		}
	}
	
	public void andar() {
		
	}
}
