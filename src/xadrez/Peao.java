package xadrez;

public class Peao extends Peca{
	
	//Construtor
	public Peao(int cor){
       super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "P";
		}else {
			return "p";
		}
	}
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				int linha = linhaFim - linhaIni;
				int coluna = colunaFim - colunaIni;
				if (pec == null) {
					if(Math.abs(linha) == 1 && Math.abs(coluna) == 0) {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						this.primMov = false;
					}
				}else if ((pec != null) && ((Math.abs(coluna) == 1))&&(Math.abs(linha) == 1)) {
					tab.setPeca(linhaFim, colunaFim, null);
					tab.setPeca(linhaFim, colunaFim, this);
					tab.setPeca(linhaIni, colunaIni, null);
					this.primMov = false;
				}
				//Primeiro movimento pode andar duas casas
				if((this.primMov == true) && (Math.abs(coluna) == 0 && Math.abs(linha) == 2)) {
					tab.setPeca(linhaFim, colunaFim, this);
					tab.setPeca(linhaIni, colunaIni, null);
					this.primMov = false;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
		return true;
	} 
}

