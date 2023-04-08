package model;

public abstract class Piece{
	int cor;
	Boolean primMov = true;
        
	//Construtor
    public Piece(int cor){
        this.cor = cor;
    }
        
	public String toString() {
		if(cor == 1) {
			return "Peca";
		}else {
			return "peca";
		}
	}
	//confere se a peca está no tabuleiro
    public boolean conferePos(int x,int y){
        if(x<= 8 && y <= 8 && x >=0 && y >= 0){
            return true;
        }else{
            return false;
        }
    }
        
	public abstract Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Board tab);
	
	public int getCor(){
    	return cor;
    }
}
