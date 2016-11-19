package LN;

public class Partida {
	private Ficha jug1;
	private Ficha jug2;
	private int dado;
	private Tablero tablero;
	private Puntuacion puntuacion;
	private boolean turno;		//Si turno es true, le toca al jugador 1, si es false le toca al jugador 2
	private boolean terminada;
	
	public Partida(int id_jug1, int id_jug2){
		this.jug1 = new Ficha(id_jug1);
		this.jug2 = new Ficha(id_jug2);
		this.tablero = new Tablero();
		this.puntuacion = new Puntuacion();
		this.terminada = false;
		this.dado = 0;
	}
	public void comienzo(){
		int sorteo = (int)Math.random();
		if(sorteo == 0){
			turno = false;
		} else {
			turno = true;
		}
		tablero.setPos_x_jug1(0);
		tablero.setPos_y_jug1(0);
		tablero.setPos_x_jug2(0);
		tablero.setPos_y_jug2(0);
	}
	
	public Ficha getJug1() {
		return jug1;
	}
	public void setJug1(Ficha jug1) {
		this.jug1 = jug1;
	}
	public Ficha getJug2() {
		return jug2;
	}
	public void setJug2(Ficha jug2) {
		this.jug2 = jug2;
	}
	public int getDado(){
		return this.dado;
	}
	public void setDado(int dado){
		this.dado = dado;
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

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	
	

}
