package LN;

public class FichaDePartida {

	private int id_jugador;
	private int num_quesitos;
	private int preguntas_realizadas;
	private int preguntas_acertadas;
	
	public FichaDePartida(int id_jugador){
		this.id_jugador = id_jugador;
		this.num_quesitos = 0;
		this.preguntas_realizadas = 0;
		this.preguntas_acertadas = 0;
	}
	
	public int getId_jugador() {
		return id_jugador;
	}
	public void setId_jugador(int id_jugador) {
		this.id_jugador = id_jugador;
	}
	public int getNum_quesitos() {
		return num_quesitos;
	}
	public void setNum_quesitos(int num_quesitos) {
		this.num_quesitos = num_quesitos;
	}
	public int getPreguntas_realizadas() {
		return preguntas_realizadas;
	}
	public void setPreguntas_realizadas(int preguntas_realizadas) {
		this.preguntas_realizadas = preguntas_realizadas;
	}
	public int getPreguntas_acertadas() {
		return preguntas_acertadas;
	}
	public void setPreguntas_acertadas(int preguntas_acertadas) {
		this.preguntas_acertadas = preguntas_acertadas;
	}
	
	
}
