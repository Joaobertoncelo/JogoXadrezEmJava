package xadrez;

public class Tabuleiro {
    
    private Peca[][] tabuleiro;
    
    public Tabuleiro() {
        tabuleiro = new Peca[8][8];
        
        //Cria Rei
        Peca rei = new Rei(1);
        tabuleiro[0][4] = rei;
        rei = new Rei(2);
        tabuleiro[7][4] = rei;
        
        //Cria Dama
        Peca dama = new Dama(1);
        tabuleiro[0][3] = dama;
        dama = new Dama(2);
        tabuleiro[7][3] = dama;
        
        //Cria Bispo
        Peca bispo = new Bispo(1);
        tabuleiro[0][2] = bispo;
        bispo = new Bispo(1);
        tabuleiro[0][5] = bispo;
        bispo = new Bispo(2);
        tabuleiro[7][2] = bispo;
        bispo = new Bispo(2);
        tabuleiro[7][5] = bispo;
        
        //Cria Cavalo
        Peca cavalo = new Cavalo(1);
        tabuleiro[0][1] = cavalo;
        cavalo = new Cavalo(1);
        tabuleiro[0][6] = cavalo;
        cavalo = new Cavalo(2);
        tabuleiro[7][1] = cavalo;
        cavalo = new Cavalo(2);
        tabuleiro[7][6] = cavalo;
        
        //Cria Torre
        Peca torre = new Torre(1);
        tabuleiro[0][0] = torre;
        torre = new Torre(1);
        tabuleiro[0][7] = torre;
        torre = new Torre(2);
        tabuleiro[7][0] = torre;
        torre = new Torre(2);
        tabuleiro[7][7] = torre;
        
        //Cria Peão
        Peca peao = new Peao(1);
        tabuleiro[1][0] = peao;
        peao = new Peao(1);
        tabuleiro[1][1] = peao;
        peao = new Peao(1);
        tabuleiro[1][2] = peao;
        peao = new Peao(1);
        tabuleiro[1][3] = peao;
        peao = new Peao(1);
        tabuleiro[1][4] = peao;
        peao = new Peao(1);
        tabuleiro[1][5] = peao;
        peao = new Peao(1);
        tabuleiro[1][6] = peao;
        peao = new Peao(1);
        tabuleiro[1][7] = peao;
        
        peao = new Peao(2);
        tabuleiro[6][0] = peao;
        peao = new Peao(2);
        tabuleiro[6][1] = peao;
        peao = new Peao(2);
        tabuleiro[6][2] = peao;
        peao = new Peao(2);
        tabuleiro[6][3] = peao;
        peao = new Peao(2);
        tabuleiro[6][4] = peao;
        peao = new Peao(2);
        tabuleiro[6][5] = peao;
        peao = new Peao(2);
        tabuleiro[6][6] = peao;
        peao = new Peao(2);
        tabuleiro[6][7] = peao;
        
        
    }
    public String toString(){
    	String string = new String();
    	for(int i=0; i<8;i++) {
    		for(int j=0; j<8;j++) {
    			string = tabuleiro[i][j].toString(); 
    		}
    	}
    	return string; 
    }
    
    public static void iniciaJogo() {
    	String tabuleiroString = tabuleiro.toString();
    	System.out.println(tabuleiroString);
    }
}
