package xadrez;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Tabuleiro.iniciaJogo();
		Boolean chequeMate = false;
		Scanner scanner = new Scanner(System.in);
		do {
			//Escanear qual a movimentação do jogador
			System.out.println("Insira a peça que deseja movimentar: ");
			String peca = scanner.next();
			System.out.println("Para onde deseja movimentar? (coluna/linha)");
			int coluna = scanner.nextInt(); 
			int linha = scanner.nextInt();
			
			
		}while(!chequeMate);
		
		
		
	}
}
