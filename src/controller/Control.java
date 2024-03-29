package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.*;
import view.*;

public class Control {
	//Cliques
	private int linhaIni, colunaIni;
    private int linhaFim, colunaFim;
    //Branca ou não
    private Boolean white = true;
    //Validação de cor
    private int cor = 0, corIni, corFim;
    //Tabuleiro
    private Board board = new Board();
    //pecas
    private Piece pIni, pFim;
    //Cheque e Cheque-mate
    private Boolean chequeMate = false, cheque = false;
    //Testar caminho Livre
    private Boolean camLivre = true;
    //Testar numero de reis
    private int numKings = 0;

    public void setFirstClick(int linhaIni, int colunaIni) {
        this.linhaIni = linhaIni;
        this.colunaIni = colunaIni;
    }

    public void setSecondClick(int linhaFim, int colunaFim) {
    	this.linhaFim = linhaFim;
        this.colunaFim = colunaFim;
    }

    public Boolean processClicks(JButton[] buttons) {
			//definir de quem é a vez
			if(white) {
				cor = 1;
				board.setWEnPassant(false);
			}else {
				cor = 2;
				board.setBEnPassant(false);
			}
			try {
				//Pega a peca desejada pelo usuário
				pIni=board.getPeca(linhaIni, colunaIni);
				if(pIni != null) {
					corIni = pIni.getCor();
				}else {
					return false;
				}
				//confere se a peca é dele
				if(pIni != null && (corIni == cor)) {
					//Confere o destino da peça
					pFim=board.getPeca(linhaFim, colunaFim);
					if(pFim != null) {
						corFim=pFim.getCor();
					}
					//Roque
					if((pIni instanceof King)&&(pFim instanceof Rook)) {
						camLivre = pIni.andar(colunaIni, linhaIni, colunaFim, linhaFim, board);
						if(camLivre) {
							white = !white;
							return true;
						}
					}
					//Confere se o movimento é possível
					if(pFim == null || corFim != cor) {
						camLivre = pIni.andar(colunaIni, linhaIni, colunaFim, linhaFim, board);
						if(camLivre) {
							String change;
							if(cor == 1) {
								int linha = 7;
								for (int coluna = 0; coluna<8; coluna++) {
									Piece pec = board.getPeca(linha, coluna);
									if(pec instanceof Pawn) {
										change = Frame.changePawn();
										pec = ((Pawn) pec).promover(change, linha, coluna, cor);
										board.setPeca(linha, coluna, pec);
									}
								}
							}else if(cor == 2) {
								int linha = 0;
								for (int coluna = 0; coluna<8; coluna++) {
									Piece pec = board.getPeca(linha, coluna);
									if(pec instanceof Pawn) {
										change = Frame.changePawn();
										pec = ((Pawn) pec).promover(change, linha, coluna, cor);
										board.setPeca(linha, coluna, pec);
									}
								}
							}
							for (int i = 0; i < 8; i++) {
						        for (int j = 0; j < 8; j++) {
						        	Piece isKing = board.getPeca(i, j);
						        	if(isKing instanceof King) {
						        		numKings++;
						        	}
						        }
							}
							if(numKings!=2) {
								Frame.gameOver();
							}else {
								numKings = 0;
							}
							white = !white;
							return true;
						}else {
							System.out.println("A peca não pode ser movimentada aí(caminho não livre)");
							return false;
						}
					}else {
						System.out.println("A peca não pode ser movimentada aí(pFim != null)");
						return false;
					}
				}else if(pIni == null){
					System.out.println("Não há peça aí! Escolha outra");
					return false;
				}else {
					System.out.println("Essa peca nao eh sua! Selecione outra por favor");
					return false;
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
			}
		return false;
    }
    
    public void updateBoard(JButton[] buttons) {
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            Piece piece = board.getPeca(i, j);
	            if (piece == null) {
	                buttons[i * 8 + j].setIcon(null);
	            } else {
	            	Icon peca = new ImageIcon(getClass().getResource("/images/" + piece.toString() + ".png"));
	                buttons[i * 8 + j].setIcon(peca);
	            }
	        }
	    }
	}
}
