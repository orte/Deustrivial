package LN;

public class Tablero {
	private Casilla [][] casillas;
	private int pos_x_jug1;
	private int pos_y_jug1;
	private int pos_x_jug2;
	private int pos_y_jug2;
	private String [] categorias = {"Geografía", "Historia", "Ocio", "Deportes"};
	
	public Tablero(){
		casillas = new Casilla[4][4];
		for (int i = 0; i<4; i++){
			for (int j = 0; j<4; j++){
				String categoria = "";
				boolean quesito;
				
				quesito = false;
				categoria = obtenerCategoria(j);
				casillas[i][j] = new Casilla(i, j, categoria, quesito);
			}
			cambiarOrden();
		}
		this.pos_x_jug1 = 0;
		this.pos_y_jug1 = 0;
		this.pos_x_jug2 = 0;
		this.pos_y_jug2 = 0;
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
	public void mover(int jug, int dado){
		if (jug == 1){
			if(getPos_y_jug1()+dado>3){
				setPos_y_jug1((getPos_y_jug1()+dado)-4);
				setPos_x_jug1(getPos_x_jug1()+1);
			} else{
				setPos_y_jug1(getPos_y_jug1()+dado);
			}
		} else {
			if(getPos_y_jug2()+dado>3){
				setPos_y_jug2((getPos_y_jug2()+dado)-4);
				setPos_x_jug2(getPos_x_jug2()+1);
			} else{
				setPos_y_jug2(getPos_y_jug2()+dado);
			}
		}
	}
	
	public Casilla[][] getCasillas(){
		return casillas;
	}
	public void setCasillas(Casilla[][] casillas){
		this.casillas = casillas;
	}
	public int getPos_x_jug1() {
		return pos_x_jug1;
	}
	public void setPos_x_jug1(int pos_x_jug1) {
		this.pos_x_jug1 = pos_x_jug1;
	}
	public int getPos_y_jug1() {
		return pos_y_jug1;
	}
	public void setPos_y_jug1(int pos_y_jug1) {
		this.pos_y_jug1 = pos_y_jug1;
	}
	public int getPos_x_jug2() {
		return pos_x_jug2;
	}
	public void setPos_x_jug2(int pos_x_jug2) {
		this.pos_x_jug2 = pos_x_jug2;
	}
	public int getPos_y_jug2() {
		return pos_y_jug2;
	}
	public void setPos_y_jug2(int pos_y_jug2) {
		this.pos_y_jug2 = pos_y_jug2;
	}
	

}
