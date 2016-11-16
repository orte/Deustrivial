package main;

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
				String categoria = obtenerCategoria();
				boolean quesito;
				if(j==0){
					quesito = true;
				} else{
					quesito = false;
				}
				casillas[i][j] = new Casilla(i, j, categoria, quesito);
			}
		}
		this.pos_x_jug1 = 0;
		this.pos_y_jug1 = 0;
		this.pos_x_jug2 = 0;
		this.pos_y_jug2 = 0;
	}
	public String obtenerCategoria(){
		String categoria = null;
		int cat = (int) (Math.random()*6);
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
	public void mover(int jug){
		if (jug == 1){
			if(getPos_y_jug1()==5){
				setPos_y_jug1(0);
				setPos_x_jug1(getPos_x_jug1()+1);
			} else{
				setPos_y_jug1(getPos_y_jug1()+1);
			}
		} else {
			if(getPos_y_jug2()==5){
				setPos_y_jug2(0);
				setPos_x_jug2(getPos_x_jug2()+1);
			} else{
				setPos_y_jug2(getPos_y_jug2()+1);
			}
		}
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
