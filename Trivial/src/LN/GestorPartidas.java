package LN;


import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.JDOMException;

import LD.GestorSQL;
import LD.GestorXML;

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
	GestorXML gesXML = new GestorXML();
	
	public ArrayList<Object> CrearPartida(String id1, String id2, String idP)
	{
		ArrayList<Object> objetos_partida = new ArrayList<Object>();
		
		Partida nuevaP = new Partida();
		nuevaP.setId_j1(id1);
		nuevaP.setId_j2(id2);
		nuevaP.setId_P(idP);
	
	
		FichaDePartida f1 = new FichaDePartida(id1,idP);
		FichaDePartida f2 = new FichaDePartida(id2,idP);
		
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
	
	//Aquí he pasado el método que tenías en GestorXML (como te he puesto en el otro lado, estos datos se los tiene
	//que pasar a la LP la LN, no la LD). Llama al método de GestorXML para obtener toda la lista de preguntas de 
	//una categoría concreta y devuelve una al azar.
	public Pregunta obtenerPregunta(String categoria){
		Pregunta pregunta = null;
		ArrayList <Pregunta> lista = gesSQL.listaPreguntas(categoria);	
		int random = (int)(Math.random()*lista.size());
		pregunta = lista.get(random);
		return pregunta;
	}
	public String rutaDado(int dado){
		String ruta = "img/dado";
		ruta = ruta.concat(dado+".jpg");
		return ruta;
	}
	public int[] nuevaPosicion(int posX, int posY, int dado){
		int[] posicion = new int[2];
		if(posY+dado>3){
			posicion[1] = (posY+dado-4);
			if(posX+1<4){
				posicion[0] = posX+1;
			} else{
				posicion[0] = 0;
			}
		} else if(posY+dado<0){
			posicion[1] = posY+4+dado;
			if(posX-1<0){
				posicion[0] = 3;
			} else{
				posicion[0] = posX-1;
			}
		} else{
			posicion[1] = posY+dado;
			posicion[0] = posX;
		}
		return posicion;
	}
	
}
