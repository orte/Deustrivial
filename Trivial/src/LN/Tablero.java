package LN;

public class Tablero {
	private Casilla [][] casillas;
	private String [] categorias = {"Geografia", "Historia", "Ocio", "Deportes"};

	public Tablero(int posx_jug1, int posy_jug1, int posx_jug2, int posy_jug2){
		casillas = new Casilla[4][4];
		for (int i = 0; i<4; i++){
			for (int j = 0; j<4; j++){
				String categoria = obtenerCategoria(j);
				boolean hayDos = false;
				boolean ocupada = false;
				if ((i == posx_jug1&& j==posy_jug1)||(i == posx_jug2&& j==posy_jug2)){
					ocupada = true;
				}
				casillas[i][j] = new Casilla(i, j, categoria, ocupada, hayDos);
			}
			cambiarOrden();
		}
		if (posx_jug1 == posx_jug2 && posy_jug1 == posy_jug2){
			casillas[posx_jug1][posy_jug1].setOcupada(true);
			casillas[posx_jug1][posy_jug1].setHayDos(true);
			casillas[posx_jug1][posy_jug1].ponerIconoFichas(2);
		} else{
			casillas[posx_jug1][posy_jug1].setOcupada(true);
			casillas[posx_jug2][posy_jug2].setOcupada(true);
			casillas[posx_jug1][posy_jug1].ponerIconoFichas(0);
			casillas[posx_jug2][posy_jug2].ponerIconoFichas(1);
		}
	}
	public void cambiarOrden(){
		String primero = categorias[0];
		for(int i = 0; i<categorias.length-1; i++){
			categorias[i] = categorias[i+1];
		}
		categorias[categorias.length-1] = primero;
		
	}
	public String obtenerCategoria(int cat){
		String categoria = null;
		categoria = categorias[cat];
		return categoria;
	}
	
	
	public Casilla[][] getCasillas(){
		return casillas;
	}
	public void setCasillas(Casilla[][] casillas){
		this.casillas = casillas;
	}
}
