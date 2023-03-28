package xadrez;

public class Cavalo extends Peca{
	
	
	//Construtor
	public Cavalo(int cor) {
		super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "C";
		}else {
			return "c";
		}
	}
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Peca pec = tab.getPeca(linhaFim, colunaFim);
				if (pec == null||(this.cor != pec.cor)) {
					int linha = linhaFim - linhaIni;
					int coluna = colunaFim - colunaIni;
					if((Math.abs(linha) ==1 && Math.abs(coluna) ==2) || (Math.abs(linha) ==2 && Math.abs(coluna) ==1)) {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
	}
}
