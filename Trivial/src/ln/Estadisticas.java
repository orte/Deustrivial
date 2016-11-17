package ln;

import java.util.ArrayList;

public class Estadisticas {
	private int id_jugador;
	private int partidas_jugadas;
	private int partidas_ganadas;
	private ArrayList<Pregunta> preguntas_realizadas = new ArrayList<Pregunta>();
	private ArrayList<Pregunta> preguntas_acertadas = new ArrayList<Pregunta>();
	
	public Estadisticas(int id_jugador){
		this.id_jugador = id_jugador;
		partidas_jugadas = 0;
		partidas_ganadas = 0;
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

	public ArrayList<Pregunta> getPreguntas_realizadas() {
		return preguntas_realizadas;
	}

	public void setPreguntas_realizadas(ArrayList<Pregunta> preguntas_realizadas) {
		this.preguntas_realizadas = preguntas_realizadas;
	}

	public ArrayList<Pregunta> getPreguntas_acertadas() {
		return preguntas_acertadas;
	}

	public void setPreguntas_acertadas(ArrayList<Pregunta> preguntas_acertadas) {
		this.preguntas_acertadas = preguntas_acertadas;
	}
	public void partidaGanada(){
		setPartidas_jugadas(getPartidas_jugadas()+1);
		setPartidas_ganadas(getPartidas_ganadas()+1);
	}
	public void partidaPerdida(){
		setPartidas_jugadas(getPartidas_jugadas()+1);
	}
	
	

}
