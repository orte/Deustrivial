package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jdom2.JDOMException;

import LD.GestorSQL;
import LD.GestorXML;
import LN.Jugador;
import LN.Pregunta;
import LP.menuPrincipal;

public class Main {

	public static void main(String[] args) throws JDOMException, IOException, SQLException 
	{
		GestorSQL sql = new GestorSQL();
		ArrayList<Pregunta> lista = sql.listaPreguntas("Historia");
		for(int i = 0; i<lista.size(); i++){
			System.out.println(lista.get(i).toString());
		}
		
		
	}

}
