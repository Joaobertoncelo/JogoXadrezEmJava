package xadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Tabuleiro tab = new Tabuleiro();
		System.out.println(tab);
		Peca pIni, pFim;
		Boolean chequeMate = false, cheque = false;
		Boolean branca = true;
		Boolean camLivre = true;
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
			do {
				try {
					//Escanear qual a movimentação do jogador
					System.out.println("Onde está sua peca? (linha/coluna)" + cor); 
					linhaIni = scanner.nextInt();
					linhaIni --;
					colunaIni = scanner.nextInt();
					colunaIni --;
					//Pega a peca desejada pelo usuário
					pIni=tab.getPeca(linhaIni, colunaIni);
					//confere se a peca é dele
					if(pIni != null && (pIni.cor == cor)) {
						System.out.println("Para onde deseja movimentar? (linha/coluna)" + cor);
						linhaFim = scanner.nextInt();
						linhaFim --;
						colunaFim = scanner.nextInt();
						colunaFim --;
						//Confere o destino da peça
						pFim=tab.getPeca(linhaFim, colunaFim);
						if(pFim == null || pFim.cor != cor) {
							camLivre = pIni.andar(colunaIni, linhaIni, colunaFim, linhaFim, tab);
							System.out.println(tab);
							if(camLivre) {
								break;
							}
						}else {
							System.out.println("A peca não pode ser movimentada aí");
						}
					}else if(pIni == null){
						System.out.println("Não há peça aí! Escolha outra");
					}else {
						System.out.println("Essa peca nao eh sua! Selecione outra por favor");
					}
				}catch(NullPointerException e) {
					System.out.println(e);
					System.out.println("Digite um valor válido");
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println(e);
					System.out.println("A peça não pode ser movimentada aí");
				}catch(InputMismatchException e) {
					System.out.println(e);
					System.out.println("Por favor, digite um número");
					scanner.reset();
				}
			}while(true);
			branca = !branca;
		}while(!chequeMate);
	}
}
