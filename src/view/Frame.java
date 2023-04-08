package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.Control;
import model.*;

public class Frame extends JFrame implements ActionListener 
{
	private final JButton[] botoes; 
	private final JLabel WKing;
	private final JLabel WQueen;
	private final JLabel WRook;
	private final JLabel WHorse;
	private final JLabel WBishop;
	private final JLabel WPawn;
	private final JLabel BKing;
	private final JLabel BQueen;
	private final JLabel BRook;
	private final JLabel BHorse;
	private final JLabel BBishop;
	private final JLabel BPawn;
	private final JLabel WPoint;
	private final JLabel BPoint;
	private final Container container; 
	private final GridLayout gridLayout; 
	private int[] firstClick = {-1, -1}; // coordenadas do primeiro clique
    private int[] secondClick = {-1, -1}; // coordenadas do segundo clique

	Control control = new Control();

		
	public Frame(){
	    super("Chess");
	    botoes = new JButton[64];
	    Icon wking = new ImageIcon(getClass().getResource("/images/White King.png"));
	    WKing = new JLabel(wking, 
	    SwingConstants.LEFT);
	    Icon wqueen = new ImageIcon(getClass().getResource("/images/White Queen.png"));
	    WQueen = new JLabel(wqueen, 
	    SwingConstants.LEFT);
	    Icon wrook = new ImageIcon(getClass().getResource("/images/White Rook.png"));
	    WRook = new JLabel(wrook, 
	    SwingConstants.RIGHT);
	    Icon whorse = new ImageIcon(getClass().getResource("/images/White Horse.png"));
	    WHorse = new JLabel(whorse);
	    Icon wbishop = new ImageIcon(getClass().getResource("/images/White Bishop.png"));
	    WBishop = new JLabel(wbishop);
	    Icon wpawn = new ImageIcon(getClass().getResource("/images/White Pawn.png"));
	    WPawn = new JLabel(wpawn);
	    Icon bking = new ImageIcon(getClass().getResource("/images/Black King.png"));
	    BKing = new JLabel(bking);
	    Icon bqueen = new ImageIcon(getClass().getResource("/images/Black Queen.png"));
	    BQueen = new JLabel(bqueen);
	    Icon brook = new ImageIcon(getClass().getResource("/images/Black Rook.png"));
	    BRook = new JLabel(brook);
	    Icon bhorse = new ImageIcon(getClass().getResource("/images/Black Horse.png"));
	    BHorse = new JLabel(bhorse);
	    Icon bbishop = new ImageIcon(getClass().getResource("/images/Black Bishop.png"));
	    BBishop = new JLabel(bbishop);
	    Icon bpawn = new ImageIcon(getClass().getResource("/images/Black Pawn.png"));
	    BPawn = new JLabel(bpawn);
	    
	    //torres
	    botoes[0] = new JButton(wrook);
        botoes[7] = new JButton(wrook);

        botoes[56] = new JButton(brook);
        botoes[63] = new JButton(brook);
        
        //Cavalos
        botoes[1] = new JButton(whorse);
        botoes[6] = new JButton(whorse);

        botoes[57] = new JButton(bhorse);
        botoes[62] = new JButton(bhorse);
        
        //Bispos
        botoes[2] = new JButton(wbishop);
        botoes[5] = new JButton(wbishop);

        botoes[58] = new JButton(bbishop);
        botoes[61] = new JButton(bbishop);
        
        //Damas
        botoes[3] = new JButton(wqueen);
        botoes[59] = new JButton(bqueen);
        
        //Reis
        botoes[4] = new JButton(wking);
        botoes[60] = new JButton(bking);
        
        //Peoes brancos
	    for (int i = 8; i < 16; i++){
	         botoes[i] = new JButton(wpawn);
	    }
	    //peoes pretos
	    for (int i = 48; i < 56; i++){
	         botoes[i] = new JButton(bpawn);
	    }
	    
	    for (int i = 0; i < 64; i++){
	    	if(botoes[i]==null) {
	    		botoes[i] = new JButton(" ");
	    	}
	    }
	    for (int i = 0; i < 64; i++) {
	        botoes[i].addActionListener(this);
	    }
	    
	    //Cores
	    Boolean white = true;
	    for (int i = 0; i < 64; i++){
	    	if(white) {
	    		botoes[i].setBackground(Color.LIGHT_GRAY);
	    	}else {
	    		botoes[i].setBackground(Color.DARK_GRAY);
	    	}
	    	white = !white;
	    	if((i == 7)||(i==14)||(i==23)||(i==31)||(i==39)||(i==47)||(i==55)) {
	    		white = !white;
	    	}
	    }
	    botoes[15].setBackground(Color.LIGHT_GRAY);
	    
	    //Plot Tabuleiro
	    for (int i = 0; i < 64; i++){
	    	if(botoes[i]!=null) {
	    		add(botoes[i]);
	    	}
	    }
	    
	    gridLayout = new GridLayout(8, 8, 5, 5); // 2 por 3; gaps de 5
	    container = getContentPane();
	    setLayout(gridLayout); 
	    
	    for (int i = 0; i < 64; i++) {
	        botoes[i].addActionListener(this);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent event){ 
		// Obter a coordenada da posição clicada em matriz
		JButton button = (JButton) event.getSource();
		int row = -1;
		int column = -1;
		for (int i = 0; i < 64; i++) {
			if (botoes[i] == button) {
				row = i / 8;
				column = i % 8;
				break;
			}
		}
		// Verificar se a primeira coordenada já foi definida
        if (firstClick[0] == -1) {
            firstClick[0] = row;
            firstClick[1] = column;
            control.setFirstClick(row, column);
        } else {
        	// Verificar se as coordenadas são diferentes
            if (row != firstClick[0] || column != firstClick[1]) {
            	// Armazenar a coordenada atual como a segunda coordenada
                secondClick[0] = row;
                secondClick[1] = column;
                control.setSecondClick(row, column);
                
                control.processClicks();
                control.updateBoard(botoes);

                // Resetar as coordenadas dos cliques
                firstClick[0] = -1;
                firstClick[1] = -1;
                secondClick[0] = -1;
                secondClick[1] = -1;
            }
        }
	}
	 
	public static void main(String[] args)
	{ 
		Frame frame = new Frame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800); 
		frame.setVisible(true); 
	}	 
}