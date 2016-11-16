package main;

public class Partida {
	private int id_jug1;
	private int id_jug2;
	private Tablero tablero;
	private Puntuacion puntuacion;
	private boolean terminada;
	
	public Partida(int id_jug1, int id_jug2){
		this.id_jug1 = id_jug1;
		this.id_jug2 = id_jug2;
		this.tablero = new Tablero();
		this.puntuacion = new Puntuacion();
		this.terminada = false;
	}

	public int getId_jug1() {
		return id_jug1;
	}

	public void setId_jug1(int id_jug1) {
		this.id_jug1 = id_jug1;
	}

	public int getId_jug2() {
		return id_jug2;
	}

	public void setId_jug2(int id_jug2) {
		this.id_jug2 = id_jug2;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Puntuacion getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Puntuacion puntuacion) {
		this.puntuacion = puntuacion;
	}

	public boolean isTerminada() {
		return terminada;
	}

	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}
	
	

}
