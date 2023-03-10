package xadrez;

public class Dama extends Peca{
    
	
	//Construtor
    public Dama(int cor){
        super(cor);
    }
    
	public String toString() {
		if(cor == 1) {
			return "D";
		}else {
			return "d";
		}
	}
	
	public void andar() {
		
	}
}
