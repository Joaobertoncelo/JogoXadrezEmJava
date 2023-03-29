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
			try {
				do {
					//Escanear qual a movimentação do jogador
					System.out.println("Onde está sua peca? (linha/coluna)" + cor); 
					linhaIni = scanner.nextInt();
					linhaIni --;
					colunaIni = scanner.nextInt();
					colunaIni --;
					//Pega a peca desejada pelo usuário
					p=tab.getPeca(linhaIni, colunaIni);
					//confere se a peca é dele
					if(p != null &&(p.cor == cor)) {
						System.out.println("Para onde deseja movimentar? (linha/coluna)" + cor);
						linhaFim = scanner.nextInt();
						linhaFim --;
						colunaFim = scanner.nextInt();
						colunaFim --;
						p.andar(colunaIni, linhaIni, colunaFim, linhaFim, tab);
						System.out.println(tab);
						break;
					}else if(p == null){
						System.out.println("Não há peça aí! Escolha outra");
					}else {
						System.out.println("Essa peca nao eh sua! Selecione outra por favor");
					}
				}while(true);
			}catch(NullPointerException e) {
				System.out.println(e);
				System.out.println("A peça não pode ser movimentada aí");
			}
			branca = !branca;
		}while(!chequeMate);
	}
}
