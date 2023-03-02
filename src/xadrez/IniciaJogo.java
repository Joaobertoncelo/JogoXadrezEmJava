package xadrez;

public class IniciaJogo {
	public static void iniciaJogo() {
		
		Peca rei = new Rei();
		Peca tor = new Torre();
		Peca bis = new Bispo();
		Peca cav = new Cavalo();
		Peca dam = new Dama();
		Peca pea = new Peao();
		
		String[][] tabuleiro = {
				{"8",tor.representa(2),cav.representa(2),bis.representa(2),dam.representa(2),rei.representa(2),bis.representa(2),cav.representa(2),tor.representa(2)},
				{"7",pea.representa(2),pea.representa(2),pea.representa(2),pea.representa(2),pea.representa(2),pea.representa(2),pea.representa(2),pea.representa(2)},
				{"6","-","-","-","-","-","-","-","-"},
				{"5","-","-","-","-","-","-","-","-"},
				{"4","-","-","-","-","-","-","-","-"},
				{"3","-","-","-","-","-","-","-","-"},
				{"2",pea.representa(1),pea.representa(1),pea.representa(1),pea.representa(1),pea.representa(1),pea.representa(1),pea.representa(1),pea.representa(1)},
				{"1",tor.representa(1),cav.representa(1),bis.representa(1),dam.representa(1),rei.representa(1),bis.representa(1),cav.representa(1),tor.representa(1)},
				{" ","A","B","C","D","E","F","G","H"}
		};
		
		System.out.println("Maiúsculas são brancas e minúsculas são pretas \nQue os jogos comecem: \n");
		for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
	}
}
