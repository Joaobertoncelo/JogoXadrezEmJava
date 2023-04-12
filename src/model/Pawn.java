package model;

public class Pawn extends Piece{
	
	
	//Construtor
	public Pawn(int cor){
       super(cor);
	}
	
	public String toString() {
		if(cor == 1) {
			return "White Pawn";
		}else {
			return "Black Pawn";
		}
	}
	
	public Boolean andar(int colunaIni, int linhaIni, int colunaFim, int linhaFim, Board tab) {

		try {
			if(this.conferePos(colunaFim, linhaFim)) {
				Piece pec = tab.getPeca(linhaFim, colunaFim);
				int linha = linhaFim - linhaIni;
				int coluna = colunaFim - colunaIni;
				if(Math.abs(linha) == 1 && Math.abs(coluna) == 0 && pec == null) {
					if(cor == 1 && (linhaFim > linhaIni)) {
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						this.primMov = false;
						return true;
					}else if(cor == 2 && (linhaFim < linhaIni)){
						tab.setPeca(linhaFim, colunaFim, this);
						tab.setPeca(linhaIni, colunaIni, null);
						this.primMov = false;
						return true;
					}else {
						return false;
					}
				}
				if (((Math.abs(coluna) == 1))&&(Math.abs(linha) == 1)) {
					//en Passant
					if((colunaIni+1)<8 || (colunaIni-1)>8) {
						int lPawn = colunaIni-1;
						Piece left = tab.getPeca(linhaIni, lPawn);
						int rPawn = colunaIni+1;
						Piece right = tab.getPeca(linhaIni, rPawn);
						if(cor == 1) {
							if((left instanceof Pawn)&&(tab.getBEnPassant())) {
								tab.setPeca(linhaIni, colunaIni-1, null);
								tab.setPeca(linhaFim, colunaFim, null);
								tab.setPeca(linhaFim, colunaFim, this);
								tab.setPeca(linhaIni, colunaIni, null);
								this.primMov = false;
								return true;
							}else if((right instanceof Pawn)&&(tab.getBEnPassant())) {
								tab.setPeca(linhaIni, colunaIni+1, null);
								tab.setPeca(linhaFim, colunaFim, null);
								tab.setPeca(linhaFim, colunaFim, this);
								tab.setPeca(linhaIni, colunaIni, null);
								this.primMov = false;
								return true;
							}
						}else if (cor == 2) {
							if((left instanceof Pawn)&&(tab.getWEnPassant())) {
								tab.setPeca(linhaIni, colunaIni-1, null);
								tab.setPeca(linhaFim, colunaFim, null);
								tab.setPeca(linhaFim, colunaFim, this);
								tab.setPeca(linhaIni, colunaIni, null);
								this.primMov = false;
								return true;
							}else if((right instanceof Pawn)&&(tab.getWEnPassant())) {
								tab.setPeca(linhaIni, colunaIni+1, null);
								tab.setPeca(linhaFim, colunaFim, null);
								tab.setPeca(linhaFim, colunaFim, this);
								tab.setPeca(linhaIni, colunaIni, null);
								this.primMov = false;
								return true;
							}
						}
					}
					//Captura Peça
					if(pec != null) {
						if(cor == 1 && linha > 0) {
							tab.setPeca(linhaFim, colunaFim, null);
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
							this.primMov = false;
							return true;
						}else if(cor == 2 && linha < 0){
							tab.setPeca(linhaFim, colunaFim, null);
							tab.setPeca(linhaFim, colunaFim, this);
							tab.setPeca(linhaIni, colunaIni, null);
							this.primMov = false;
							return true;
						}else {
							return false;
						}
					}
				}
				//Primeiro movimento pode andar duas casas
				if((this.primMov == true) && (Math.abs(coluna) == 0 && Math.abs(linha) == 2)) {
					tab.setPeca(linhaFim, colunaFim, this);
					tab.setPeca(linhaIni, colunaIni, null);
					this.primMov = false;
					if(cor == 1) {
						tab.setWEnPassant(true);
					}else if(cor ==2) {
						tab.setBEnPassant(true);
					}
					return true;
				}
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
			System.out.println("A peça não pode ser movimentada nessa casa");
		}
		return false;
	} 
	
	public void promover(String peca, int linha, int coluna, int cor) {
		Board board = new Board();
		if(peca == "Dama") {
			Piece dama = new Queen(cor);
	        board.setPeca(linha, coluna, dama);
		}else if(peca == "Bispo") {
			Piece bispo = new Bishop(cor);
	        board.setPeca(linha, coluna, bispo);
		}else if(peca == "Cavalo") {
			Piece cavalo = new Horse(cor);
	        board.setPeca(linha, coluna, cavalo);
		}else if(peca == "Torre") {
			Piece torre = new Rook(cor);
	        board.setPeca(linha, coluna, torre);
		}
	}
	
}

