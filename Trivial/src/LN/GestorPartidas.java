package LN;

import java.util.ArrayList;

import LD.GestorSQL;

/**
  * 
  * @author Josune
  * Clase que crea partidas asociando a dos jugadores. En consecuencia crea tambien las fichas de jugador de 
  * forma simultanea
  *
  */
public class GestorPartidas 
{
	GestorSQL gesSQL = new GestorSQL();
	
	public Partida crearPartida(int id1, int id2)
	{	
		Partida nueva_P = new Partida(id1,id2);
		FichaDePartida F1 = new FichaDePartida(id1);
		FichaDePartida F2 = new FichaDePartida(id2);
		
		return nueva_P;
	}
	
	public Jugador crearJugador(String nom_usuario, int ultimo_id){
		int id_jug = ultimo_id+1;
		Jugador nuevo_J = new Jugador(id_jug, nom_usuario);
		gesSQL.guardarJugador(nuevo_J);
		return nuevo_J;
	}
	public boolean comprobarRepetido(String nom_usuario){
		boolean repetido = false;
		ArrayList<Jugador> lista = gesSQL.MostrarJugadores();
		for(Jugador aux:lista){
			if (aux.getNombre_usuario().equals(nom_usuario)){
				repetido = true;
			}
		}
		return repetido;
	}
	
	
	
	
}
