package LN;

import java.util.ArrayList;

public class Estadisticas {
	private int id_jugador;
	private int partidas_jugadas;
	private int partidas_ganadas;
	private int preguntas_acertadas;
	private int preguntas_falladas;
	
	public Estadisticas(int id_jugador){
		this.id_jugador = id_jugador;
		this.partidas_jugadas = 0;
		this.partidas_ganadas = 0;
		this.preguntas_acertadas=0;
		this.preguntas_falladas=0;
	}

	public int getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(int id_jugador) {
		this.id_jugador = id_jugador;
	}

	public int getPartidas_jugadas() {
		return partidas_jugadas;
	}

	public void setPartidas_jugadas(int partidas_jugadas) {
		this.partidas_jugadas = partidas_jugadas;
	}

	public int getPartidas_ganadas() {
		return partidas_ganadas;
	}

	public void setPartidas_ganadas(int partidas_ganadas) {
		this.partidas_ganadas = partidas_ganadas;
	}

	
	public void partidaGanada(){
		setPartidas_jugadas(getPartidas_jugadas()+1);
		setPartidas_ganadas(getPartidas_ganadas()+1);
	}
	public void partidaPerdida(){
		setPartidas_jugadas(getPartidas_jugadas()+1);
	}

	public int getPreguntas_acertadas() {
		return preguntas_acertadas;
	}

	public void setPreguntas_acertadas(int preguntas_acertadas) {
		this.preguntas_acertadas = preguntas_acertadas;
	}

	public int getPreguntas_falladas() {
		return preguntas_falladas;
	}

	public void setPreguntas_falladas(int preguntas_falladas) {
		this.preguntas_falladas = preguntas_falladas;
	}
	
	

}
