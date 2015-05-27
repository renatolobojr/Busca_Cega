import java.util.ArrayList;


public class Garrafas {

	public int garr4;
	public int garr3;
	
	public ArrayList<Integer> geradores = new ArrayList<Integer>();;
	
	public int id;
	public int ger;
	public static int registro=0;
	
	public Garrafas(int x, int y){
		this.garr4 = x;
		this.garr3 = y;
		this.id = registro++;
	}
	
	public Garrafas(Garrafas G){   //gerar novo estado a partir do antigo
		this.garr3 = G.garr3;
		this.garr4 = G.garr4;
		this.id = registro++;
		this.ger = G.id;
		//this.geradores.add(G.id);
	}
	
	public void transicao(int i){
		int total = garr4 + garr3;	
		
		switch (i){
		case 1: garr4= 0; break;
		case 2: garr3= 0; break;
		case 3: garr4= 4; break;
		case 4: garr3= 3; break;
		case 5: if (total>4) { garr4 = 4; garr3 = total - 4;} else { garr4 = total; garr3 = 0;}	break;
		case 6: if (total>3) { garr3 = 3; garr4 = total - 3;} else { garr3 = total; garr4 = 0;}	break;		
		}
	}
	
	public String toString(){
		String s = "["+ ger +"]("+ garr4 +","+ garr3 + ")["+ id +"]";
		return s;
	}
}
