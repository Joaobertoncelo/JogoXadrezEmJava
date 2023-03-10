package xadrez;

public class Dama extends Peca{
    
    public Dama(int cor){
        super(cor);
    }
    
	public String representa(int cor) {
		if(cor == 1) {
			return "D";
		}else {
			return "d";
		}
	}
	
	public void andar() {
		
	}
}
