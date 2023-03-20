package xadrez;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Tabuleiro tab = new Tabuleiro();
		System.out.println(tab);
		Peca p;
		Boolean chequeMate = false;
		Boolean branca = true;
		int colunaIni = 0, linhaIni = 0, colunaFim = 0, linhaFim = 0;
		int cor = 1;
		Scanner scanner = new Scanner(System.in);
		do {
			//definir de quem é a vez
			if(branca) {
				cor = 1;
			}else {
				cor = 2;
			}
			//Escanear qual a movimentação do jogador
			System.out.println("Onde está sua peca? (coluna/linha)"); 
			linhaIni = scanner.nextInt();
			linhaIni --;
			colunaIni = scanner.nextInt();
			colunaIni --;
			System.out.println("Para onde deseja movimentar? (coluna/linha)");
			linhaFim = scanner.nextInt();
			linhaFim --;
			colunaFim = scanner.nextInt();
			colunaFim --;
			try {
				p=tab.getPeca(linhaIni, colunaIni);
				p.andar(colunaIni, linhaIni, colunaFim, linhaFim, tab);
				System.out.println(tab);
			}catch(NullPointerException e) {
				System.out.println(e);
				System.out.println("A peça não pode ser movimentada aí");
			}
			branca = !branca;
		}while(!chequeMate);
	}
}
