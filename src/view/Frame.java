package view;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants; 
import javax.swing.Icon; 
import javax.swing.ImageIcon; 

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
		
	public Frame(){
	    super("Chess");
	    botoes = new JButton[64];
	    Icon wking = new ImageIcon(getClass().getResource("/Imagens/White King.png"));
	    WKing = new JLabel(wking, 
	    SwingConstants.LEFT);
	    Icon wqueen = new ImageIcon(getClass().getResource("/Imagens/White Queen.png"));
	    WQueen = new JLabel(wqueen, 
	    SwingConstants.LEFT);
	    Icon wrook = new ImageIcon(getClass().getResource("/Imagens/White Rook.png"));
	    WRook = new JLabel(wrook, 
	    SwingConstants.RIGHT);
	    Icon whorse = new ImageIcon(getClass().getResource("/Imagens/White Horse.png"));
	    WHorse = new JLabel(whorse);
	    Icon wbishop = new ImageIcon(getClass().getResource("/Imagens/White Bishop.png"));
	    WBishop = new JLabel(wbishop);
	    Icon wpawn = new ImageIcon(getClass().getResource("/Imagens/White Pawn.png"));
	    WPawn = new JLabel(wpawn);
	    Icon bking = new ImageIcon(getClass().getResource("/Imagens/Black King.png"));
	    BKing = new JLabel(bking);
	    Icon bqueen = new ImageIcon(getClass().getResource("/Imagens/Black Queen.png"));
	    BQueen = new JLabel(bqueen);
	    Icon brook = new ImageIcon(getClass().getResource("/Imagens/Black Rook.png"));
	    BRook = new JLabel(brook);
	    Icon bhorse = new ImageIcon(getClass().getResource("/Imagens/Black Horse.png"));
	    BHorse = new JLabel(bhorse);
	    Icon bbishop = new ImageIcon(getClass().getResource("/Imagens/Black Bishop.png"));
	    BBishop = new JLabel(bbishop);
	    Icon bpawn = new ImageIcon(getClass().getResource("/Imagens/Black Pawn.png"));
	    BPawn = new JLabel(bpawn);
	    
	    //Cores
	    Icon wpoint = new ImageIcon(getClass().getResource("/Imagens/White Point.png"));
	    WPoint = new JLabel(wpoint);
	    Icon bpoint = new ImageIcon(getClass().getResource("/Imagens/Black Point.png"));
	    BPoint = new JLabel(bpoint);
	    
	    //torres
	    botoes[0] = new JButton(wrook);
        botoes[0].addActionListener(this);
        botoes[7] = new JButton(wrook);
        botoes[7].addActionListener(this);

        botoes[56] = new JButton(brook);
        botoes[56].addActionListener(this);
        botoes[63] = new JButton(brook);
        botoes[63].addActionListener(this);
        
        //Cavalos
        botoes[1] = new JButton(whorse);
        botoes[1].addActionListener(this);
        botoes[6] = new JButton(whorse);
        botoes[6].addActionListener(this);

        botoes[57] = new JButton(bhorse);
        botoes[57].addActionListener(this);
        botoes[62] = new JButton(bhorse);
        botoes[62].addActionListener(this);
        
        //Bispos
        botoes[2] = new JButton(wbishop);
        botoes[2].addActionListener(this);
        botoes[5] = new JButton(wbishop);
        botoes[5].addActionListener(this);

        botoes[58] = new JButton(bbishop);
        botoes[58].addActionListener(this);
        botoes[61] = new JButton(bbishop);
        botoes[61].addActionListener(this);
        
        //Damas
        botoes[3] = new JButton(wqueen);
        botoes[3].addActionListener(this);
        botoes[59] = new JButton(bqueen);
        botoes[59].addActionListener(this);
        
        //Reis
        botoes[4] = new JButton(wking);
        botoes[4].addActionListener(this);
        botoes[60] = new JButton(bking);
        botoes[60].addActionListener(this);
        
        //Peoes brancos
	    for (int i = 8; i < 16; i++){
	         botoes[i] = new JButton(wpawn);
	         botoes[i].addActionListener(this);
	    }
	    //peoes pretos
	    for (int i = 48; i < 56; i++){
	         botoes[i] = new JButton(bpawn);
	         botoes[i].addActionListener(this);
	    }
	    
	    for (int i = 0; i < 64; i++){
	    	if(botoes[i]==null) {
	    		botoes[i] = new JButton(" ");
	    		botoes[i].addActionListener(this);
	    	}
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
	    
	    //Plot Tabuleiro
	    for (int i = 0; i < 64; i++){
	    	if(botoes[i]!=null) {
	    		add(botoes[i]);
	    	}
	    }
	    
	    gridLayout = new GridLayout(8, 8, 5, 5); // 2 por 3; gaps de 5
	    container = getContentPane();
	    setLayout(gridLayout); 
	}

	@Override
	public void actionPerformed(ActionEvent event){ 
	//container.setLayout(gridLayout);
	} 
	 
	public static void main(String[] args)
	{ 
		Frame frame = new Frame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800); 
		frame.setVisible(true); 
	}	 
}