import java.util.Stack;

public class Busca_Cega {
	
	public static void main(String[] args) {
		
		Garrafas ini = new Garrafas(0,0);
		Garrafas fim = new Garrafas(2,0); 
		System.out.println("Solução (2,0) encontrada com " + Buscar(ini,fim,true)+ " expansões");
	
	}//fim do main
	
	public static int Buscar(Garrafas i, Garrafas f, Boolean d ){ 
		
		/******************Criação e iniciação das variáveis*****************/
		
		Stack<Garrafas> borda = new Stack<Garrafas>();  
		Stack<Garrafas> explorados = new Stack<Garrafas>();
		Stack<Garrafas> gerados = new Stack<Garrafas>();
		
		boolean achou = false; //true quando encontrar a solção
		int exp = 0; //indica o número de expansões feitas
		borda.push(i); //adiciona estado inicial na borda
		Garrafas atual = new Garrafas(0,0);
		
		/**************fim da criação e iniciação das variáveis**************/
		
		do{
			if(d){
					atual = borda.get(0); borda.remove(0);		//d = true -> busca por largura
				
			}else 	atual = borda.pop();						//d = False -> busca por profundidade
			
			gerados = expandir(atual);
			explorados.push(atual);
			
			do{
				if (igual(gerados.get(0),f)) achou = true;
				
				if ((!repete(gerados.get(0),borda))
						&&(!repete(gerados.get(0),explorados))) 
							borda.push(gerados.get(0));
				
				gerados.remove(0);
			}while(!gerados.isEmpty());
			
			System.out.print("Explorados: ");
			
			for(Garrafas e: explorados)
				System.out.print(e+" ");           //mostra os explorados
			
			System.out.print("\n\rBorda: ");
			
			for(Garrafas b: borda)
				System.out.print(b+" ");           //mostra os gerados na borda
						
			System.out.println();
			for (int j=0;j<120;j++)System.out.print("-"); 
			System.out.println();
			
		exp++;	
		}while(!achou);
		
		return exp;
	}//fim do buscar
	
	private static Stack<Garrafas> expandir(Garrafas G){
		Stack<Garrafas> lista = new Stack<Garrafas>();
		
		for (int i = 1 ; i<=6 ; i++){
			Garrafas temp = new Garrafas(G);
			temp.transicao(i);
			lista.add(temp);
		}
		

				
		return lista;
	}//fim do expandir
	
	private static boolean repete(Garrafas G, Stack<Garrafas> L){
		for(int i=0;i<L.size();i++) 
			if (igual(G,L.get(i))) return true; 
		return false;
	}
	
	private static boolean igual(Garrafas G, Garrafas H){
		
		if((G.garr3==H.garr3)&&(G.garr4==H.garr4)) return true;
		else return false;
		
	}//fim do igual
}
