package model;

public class Horse extends Piece{
	
	
	//Construtor
	public Horse(int cor) {
		super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "White Horse";
		}else {
			return "Black Horse";
		}
	}
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Board tab) {
		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Piece pec = tab.getPeca(linhaFim, colunaFim);
				if (pec == null||(this.cor != pec.cor)) {
					int linha = linhaFim - linhaIni;
					int coluna = colunaFim - colunaIni;
					if((Math.abs(linha) ==1 && Math.abs(coluna) ==2) || (Math.abs(linha) ==2 && Math.abs(coluna) ==1)) {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						return true;
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
		return false;
	}
}
