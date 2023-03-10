package xadrez;

abstract class Peca{
	int cor;
        
        public Peca(int cor){
            this.cor = cor;
        }
        
	public String representa() {
		return "Peça";
	}
	
        public boolean conferePos(int x,int y){
            if(x<= 8 && y <= 8 && x > 0 && y > 0){
                return true;
            }else{
                return false;
            }
        }
        
	public void andar() {
            
//            int[] posiAtual, posiDest;
            
		
	}
}
