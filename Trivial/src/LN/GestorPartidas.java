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
	
	public ArrayList<Object> CrearPartida(String id1, String id2)
	{
		ArrayList<Object> objetos_partida = new ArrayList<Object>();
		
		Partida nuevaP = new Partida();
		FichaDePartida f1 = new FichaDePartida(id1);
		FichaDePartida f2 = new FichaDePartida(id2);
		
		objetos_partida.add(nuevaP);
		objetos_partida.add(f1);
		objetos_partida.add(f2);
		
		return objetos_partida;
		
		
		
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
