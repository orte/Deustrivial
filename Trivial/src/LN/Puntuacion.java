package LN;

public class Puntuacion {
	
	private int quesitos_jug1;
	private int quesitos_jug2;
	
	public Puntuacion(){
		
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
