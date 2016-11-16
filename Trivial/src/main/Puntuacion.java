package main;

public class Puntuacion {
	private int acertadas_jug1;
	private int acertadas_jug2;
	private int quesitos_jug1;
	private int quesitos_jug2;
	
	public Puntuacion(){
		this.acertadas_jug1 = 0;
		this.acertadas_jug2 = 0;
		this.quesitos_jug1 = 0;
		this.quesitos_jug2 = 0;
	}

	public void quesitoConseguido(int jugador){
		if (jugador == 1){
			setQuesitos_jug1(getQuesitos_jug1()+1);
		} else {
			setQuesitos_jug2(getQuesitos_jug2()+1);
		}
	}
	
	public void preguntaAcertada(int jugador){
		if (jugador == 1){
			setAcertadas_jug1(getAcertadas_jug1()+1);
		} else {
			setAcertadas_jug2(getAcertadas_jug2()+1);
		}
	}
	public int getAcertadas_jug1() {
		return acertadas_jug1;
	}

	public void setAcertadas_jug1(int acertadas_jug1) {
		this.acertadas_jug1 = acertadas_jug1;
	}

	public int getAcertadas_jug2() {
		return acertadas_jug2;
	}

	public void setAcertadas_jug2(int acertadas_jug2) {
		this.acertadas_jug2 = acertadas_jug2;
	}

	public int getQuesitos_jug1() {
		return quesitos_jug1;
	}

	public void setQuesitos_jug1(int quesitos_jug1) {
		this.quesitos_jug1 = quesitos_jug1;
	}

	public int getQuesitos_jug2() {
		return quesitos_jug2;
	}

	public void setQuesitos_jug2(int quesitos_jug2) {
		this.quesitos_jug2 = quesitos_jug2;
	}
	
	

}
