package LN;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Respuesta {
	private int id_pregunta;
	private int id_jugador;
	private boolean correcta;
	private String fecha;
	
	public Respuesta(int id_pregunta, int id_jugador, boolean correcta){
		this.id_jugador = id_jugador;
		this.id_pregunta = id_pregunta;
		this.correcta = correcta;
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		this.setFecha(date.format(now));
	}
	
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public int getId_jugador() {
		return id_jugador;
	}
	public void setId_jugador(int id_jugador) {
		this.id_jugador = id_jugador;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
