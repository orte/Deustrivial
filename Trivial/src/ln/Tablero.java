package ln;

public class Tablero {
	private Casilla [][] casillas;
	private int pos_x_jug1;
	private int pos_y_jug1;
	private int pos_x_jug2;
	private int pos_y_jug2;
	
	public Tablero(){
		casillas = new Casilla[6][6];
		for (int i = 0; i<6; i++){
			for (int j = 0; j<6; j++){
				String categoria = "";
				boolean quesito;
				if(j==0){
					quesito = true;
					categoria = obtenerCategoria(i);
				} else{
					quesito = false;
					categoria = obtenerCategoria(j);
				}
				casillas[i][j] = new Casilla(i, j, categoria, quesito);
			}
		}
		this.pos_x_jug1 = 0;
		this.pos_y_jug1 = 0;
		this.pos_x_jug2 = 0;
		this.pos_y_jug2 = 0;
	}
	
	public String obtenerCategoria(int cat){
		String categoria = null;
		switch(cat){
		case 0: categoria = "Geografía"; break;
		case 1: categoria = "Arte y Literatura"; break;
		case 2: categoria = "Historia"; break;
		case 3: categoria = "Entretenimiento"; break;
		case 4: categoria = "Ciencias y Naturaleza"; break;
		case 5: categoria = "Deporte"; break;
		}
		return categoria;
	}
	public void mover(int jug, int dado){
		if (jug == 1){
			if(getPos_y_jug1()+dado>5){
				setPos_y_jug1((getPos_y_jug1()+dado)-6);
				setPos_x_jug1(getPos_x_jug1()+1);
			} else{
				setPos_y_jug1(getPos_y_jug1()+dado);
			}
		} else {
			if(getPos_y_jug2()==5){
				setPos_y_jug2((getPos_y_jug2()+dado)-6);
				setPos_x_jug2(getPos_x_jug2()+1);
			} else{
				setPos_y_jug2(getPos_y_jug2()+dado);
			}
		}
	}
	public Pregunta preguntar(int jugador){
		//Nos falta por determinar como vamos a obtener las preguntas
		Pregunta pregunta = null;
		return pregunta;
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
