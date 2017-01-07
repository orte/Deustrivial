package LN;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Partida 
{
	private int id_j1;
	private int id_j2;
	private int posx_jug1;
	private int posy_jug1;
	private int posx_jug2;
	private int posy_jug2;
	private int dado;
	private int puntJug1;
	private int puntJug2;
	private boolean turno;	
	private Tablero tablero;
	private boolean terminada;
	private String fecha_inic;
	
	public Partida(int id1, int id2)
	{
	
		this.id_j1=id1;
		this.id_j2=id2;//El ID de los jugadores
		
		terminada=false;
		this.comienzo();//da valor a turno 1 o 2
		
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		fecha_inic=date.format(now);
		posx_jug1 = 0;
		posy_jug1 = 0;
		posx_jug2 = 0;
		posy_jug2 = 0;
		puntJug1 = 0;
		puntJug2 = 0;
		tablero = new Tablero(posx_jug1, posy_jug1, posx_jug2, posy_jug2);
		
	}
	public Partida(){
		
	}
	
	public Partida (String fecha, int id1, int id2, int posx_jug1, int posy_jug1, int posx_jug2, int posy_jug2, int puntJug1, int puntJug2, boolean turno, int dado){
		this.fecha_inic = fecha;
		this.id_j1 = id1;
		this.id_j2 = id2;
		this.posx_jug1 = posx_jug1;
		this.posy_jug1 = posy_jug1;
		this.posx_jug2 = posx_jug2;
		this.posy_jug2 = posy_jug2;
		this.puntJug1 = puntJug1;
		this.puntJug2 = puntJug2;
		this.turno = turno;
		this.dado = dado;
		tablero = new Tablero(posx_jug1, posy_jug1, posx_jug2, posy_jug2);
	}
	public void comienzo(){
		int sorteo = (int)(Math.random());
		System.out.println(sorteo);
		if(sorteo == 0){
			turno = true;
		} 
		else {
			turno = false;
		}
		
	}
	public void tirarDado(){
		int nuevoDado = (int) (Math.random()*4+1);
		setDado(nuevoDado);
	}
	public void mover(int posx, int posy){
		if(getTurno()==true){
			setPosx_jug1(posx);
			setPosy_jug1(posy);
		} else{
			setPosx_jug2(posx);
			setPosy_jug2(posy);
		}
	}
	public String rutaDado(){
		String ruta = "img/dado";
		ruta = ruta.concat(dado+".jpg");
		return ruta;
	}
	public int[] nuevaPosicion(int posX, int posY, int dado){
		int[] posicion = new int[2];
		if(posY+dado>3){
			posicion[1] = (posY+dado-4);
			if(posX+1<4){
				posicion[0] = posX+1;
			} else{
				posicion[0] = 0;
			}
		} else if(posY+dado<0){
			posicion[1] = posY+4+dado;
			if(posX-1<0){
				posicion[0] = 3;
			} else{
				posicion[0] = posX-1;
			}
		} else{
			posicion[1] = posY+dado;
			posicion[0] = posX;
		}
		return posicion;
	}
	public int getDado(){
		return this.dado;
	}
	public void setDado(int dado){
		this.dado = dado;
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
	public String getFecha_inic() {
		return fecha_inic;
	}
	public void setFecha_inic(String fecha_inic) {
		this.fecha_inic = fecha_inic;
	}

	public int getId_j1() {
		return id_j1;
	}

	public void setId_j1(int id_j1) {
		this.id_j1 = id_j1;
	}

	public int getId_j2() {
		return id_j2;
	}

	public void setId_j2(int id_j2) {
		this.id_j2 = id_j2;
	}

	public int getPosx_jug1() {
		return posx_jug1;
	}

	public void setPosx_jug1(int posx_jug1) {
		this.posx_jug1 = posx_jug1;
	}

	public int getPosy_jug1() {
		return posy_jug1;
	}

	public void setPosy_jug1(int posy_jug1) {
		this.posy_jug1 = posy_jug1;
	}

	public int getPosx_jug2() {
		return posx_jug2;
	}

	public void setPosx_jug2(int posx_jug2) {
		this.posx_jug2 = posx_jug2;
	}

	public int getPosy_jug2() {
		return posy_jug2;
	}

	public void setPosy_jug2(int posy_jug2) {
		this.posy_jug2 = posy_jug2;
	}

	public boolean getTurno() {
		return turno;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int getPuntJug1() {
		return puntJug1;
	}

	public void setPuntJug1(int puntJug1) {
		this.puntJug1 = puntJug1;
	}

	public int getPuntJug2() {
		return puntJug2;
	}

	public void setPuntJug2(int puntJug2) {
		this.puntJug2 = puntJug2;
	}
	public void preguntaAcertada(int jugador){
		if(jugador == 1){
			puntJug1++;
		} else{
			puntJug2++;
		}
	}
	public String toString(){
		GestorDatos ges = new GestorDatos();
		String jug1 = ges.obtenerJugador(id_j1).getNombre_usuario();
		String jug2 = ges.obtenerJugador(id_j2).getNombre_usuario();
		String fecha = fecha_inic.substring(0, 10);
		String hora = fecha_inic.substring(11, 13);
		String minutos = fecha_inic.substring(14, 16);
		String segundos = fecha_inic.substring(17, fecha_inic.length());
		return "Partida empezada el "+fecha+" a las "+hora+":"+minutos+":"+segundos+" entre "+jug1+" y "+jug2;
	}
	

}
