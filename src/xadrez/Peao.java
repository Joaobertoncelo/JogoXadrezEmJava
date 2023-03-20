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
	
	public void andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Tabuleiro tab) {
		if(this.conferePos(colunaFim, linhaFim)) {
			Peca pec = tab.getPeca(linhaFim, colunaFim);
			int linha = linhaFim - linhaIni;
			int coluna = colunaFim - colunaIni;
			try {
				if (pec == null) {
					if(linha <= 1 && coluna <=1) {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
					}else {
						//Criar classe de exceção
					}
				}else if ((pec != null) && (linha == coluna)&&(linha == 1)) {
					tab.setPeca(linhaFim, colunaFim, null);
					tab.setPeca(linhaFim, colunaFim, this);
					tab.setPeca(linhaIni, colunaIni, null);
				}
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e);
				System.out.println("A peça não pode ser movimentada nessa casa");
			}
		} else {
			//exceção
		}
	}
}
