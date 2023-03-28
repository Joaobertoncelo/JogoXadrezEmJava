package xadrez;

public class Peao extends Peca{
	private Boolean primMov = true;
	
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
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		if(this.conferePos(colunaFim, linhaFim)) {
			Peca pec = tab.getPeca(linhaFim, colunaFim);
			int linha = linhaFim - linhaIni;
			int coluna = colunaFim - colunaIni;
			if (pec == null) {
				try {
					if(Math.abs(linha) == 1 && Math.abs(coluna) == 0) {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						this.primMov = false;
					}
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println(e);
					System.out.println("A peça não pode ser movimentada nessa casa");
				}
			}else if ((pec != null) && ((Math.abs(coluna) == 1))&&(Math.abs(linha) == 1)) {
				try {
					tab.setPeca(linhaFim, colunaFim, null);
					tab.setPeca(linhaFim, colunaFim, this);
					tab.setPeca(linhaIni, colunaIni, null);
					this.primMov = false;
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println(e);
					System.out.println("A peça não pode ser movimentada nessa casa");
				}
			}
			if((this.primMov == true) && (Math.abs(coluna)==0 && Math.abs(linha)==2)) {
				tab.setPeca(linhaFim, colunaFim, this);
				tab.setPeca(linhaIni, colunaIni, null);
				this.primMov = false;
			}
		}
	} 
}

