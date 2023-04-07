package model;

public class Board {
    
    private Piece[][] tabuleiro;
    
    
  //Construtor
    public Board() {
        this.tabuleiro = new Piece[8][8];
        
        //Cria Rei
        Piece rei = new King(1);
        tabuleiro[0][4] = rei;
        rei = new King(2);
        tabuleiro[7][4] = rei;
        
        //Cria Dama
        Piece dama = new Queen(1);
        tabuleiro[0][3] = dama;
        dama = new Queen(2);
        tabuleiro[7][3] = dama;
        
        //Cria Bispo
        Piece bispo = new Bishop(1);
        tabuleiro[0][2] = bispo;
        bispo = new Bishop(1);
        tabuleiro[0][5] = bispo;
        bispo = new Bishop(2);
        tabuleiro[7][2] = bispo;
        bispo = new Bishop(2);
        tabuleiro[7][5] = bispo;
        
        //Cria Cavalo
        Piece cavalo = new Horse(1);
        tabuleiro[0][1] = cavalo;
        cavalo = new Horse(1);
        tabuleiro[0][6] = cavalo;
        cavalo = new Horse(2);
        tabuleiro[7][1] = cavalo;
        cavalo = new Horse(2);
        tabuleiro[7][6] = cavalo;
        
        //Cria Torre
        Piece torre = new Rook(1);
        tabuleiro[0][0] = torre;
        torre = new Rook(1);
        tabuleiro[0][7] = torre;
        torre = new Rook(2);
        tabuleiro[7][0] = torre;
        torre = new Rook(2);
        tabuleiro[7][7] = torre;
        
        //Cria Peão
        Piece peao = new Pawn(1);
        tabuleiro[1][0] = peao;
        peao = new Pawn(1);
        tabuleiro[1][1] = peao;
        peao = new Pawn(1);
        tabuleiro[1][2] = peao;
        peao = new Pawn(1);
        tabuleiro[1][3] = peao;
        peao = new Pawn(1);
        tabuleiro[1][4] = peao;
        peao = new Pawn(1);
        tabuleiro[1][5] = peao;
        peao = new Pawn(1);
        tabuleiro[1][6] = peao;
        peao = new Pawn(1);
        tabuleiro[1][7] = peao;
        
        peao = new Pawn(2);
        tabuleiro[6][0] = peao;
        peao = new Pawn(2);
        tabuleiro[6][1] = peao;
        peao = new Pawn(2);
        tabuleiro[6][2] = peao;
        peao = new Pawn(2);
        tabuleiro[6][3] = peao;
        peao = new Pawn(2);
        tabuleiro[6][4] = peao;
        peao = new Pawn(2);
        tabuleiro[6][5] = peao;
        peao = new Pawn(2);
        tabuleiro[6][6] = peao;
        peao = new Pawn(2);
        tabuleiro[6][7] = peao;
        
        
        
    }
    public String toString(){
    	String string = new String();
    	for(int i=0; i<8;i++) {
    		for(int j=0; j<8;j++) {
    			Piece p = tabuleiro[i][j];
    			if (p != null) {
    				System.out.print(p.toString() + " ");
    			}else {
    				System.out.print("- ");
    			}
    		}
    		System.out.println();
    	}
    	return string;
    }
    
    public Piece getPeca(int linha, int coluna){
    	return tabuleiro[linha][coluna];
    }
    
    public void setPeca(int linha, int coluna, Piece p) {
    	tabuleiro[linha][coluna] = p;
    }
    
}
