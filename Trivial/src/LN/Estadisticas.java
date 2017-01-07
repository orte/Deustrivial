package LN;


public class Estadisticas {
	private int id_jugador;
	private int partidas_jugadas;
	private int partidas_ganadas;
	private int preguntas_totales;
	private int preguntas_acertadas;
	private float porcent_acertadas;
	
	public Estadisticas(int id_jugador, int preg_tot, int preg_acert, int part_jug, int part_gan){
		this.id_jugador = id_jugador;
		this.partidas_jugadas = part_jug;
		this.partidas_ganadas = part_gan;
		this.preguntas_totales = preg_tot;
		this.preguntas_acertadas = preg_acert;
		if(preg_tot == 0){
			this.porcent_acertadas = 0;
		} else{
			this.porcent_acertadas = (((float)(preg_acert))/((float)(preg_tot)))*100;
			
		}
		
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

	public int getPreguntas_totales() {
		return preguntas_totales;
	}

	public void setPreguntas_totales(int preguntas_totales) {
		this.preguntas_totales = preguntas_totales;
	}

	public int getPreguntas_acertadas() {
		return preguntas_acertadas;
	}

	public void setPreguntas_acertadas(int preguntas_acertadas) {
		this.preguntas_acertadas = preguntas_acertadas;
	}

	public float getPorcent_acertadas() {
		return porcent_acertadas;
	}

	public void setPorcent_acertadas(float porcent_acertadas) {
		this.porcent_acertadas = porcent_acertadas;
	}
}
