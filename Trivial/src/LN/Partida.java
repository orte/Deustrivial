package LN;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Partida 
{

	private String id_P;
	private String id_j1;
	private String id_j2;
	private int dado;
	private Tablero tablero;
	private boolean turno;		//Si turno es true, le toca al jugador 1, si es false le toca al jugador 2
	private boolean terminada;
	private String fecha_inic;
	
	public Partida(String id1, String id2)
	{
	
		this.id_j1=id1;
		this.id_j2=id2;//El ID de los jugadores
		tablero=new Tablero();//Situacion inicial por defecto
		
		terminada=false;
		this.comienzo();//da valor a turno 1 o 2
		
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		fecha_inic=date.format(now);
		
		
	}
	
	public Partida ()
	{
		tablero=new Tablero();
	}
	public void comienzo(){
		int sorteo = (int)(Math.random());
		System.out.println(sorteo);
		if(sorteo == 0)
		{
			turno = false;
		} 
		else 
		{
			turno = true;
		}
		tablero.setPos_x_jug1(0);
		tablero.setPos_y_jug1(0);
		tablero.setPos_x_jug2(0);
		tablero.setPos_y_jug2(0);
	}
	public void tirarDado(){
		int nuevoDado = (int) (Math.random()*6+1);
		setDado(nuevoDado);
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
	public String getId_P() {
		return id_P;
	}
	public void setId_P(String id_P) {
		this.id_P = id_P;
	}
	public String getFecha_inic() {
		return fecha_inic;
	}
	public void setFecha_inic(String fecha_inic) {
		this.fecha_inic = fecha_inic;
	}

	public String getId_j1() {
		return id_j1;
	}

	public void setId_j1(String id_j1) {
		this.id_j1 = id_j1;
	}

	public String getId_j2() {
		return id_j2;
	}

	public void setId_j2(String id_j2) {
		this.id_j2 = id_j2;
	}
	
	

}
