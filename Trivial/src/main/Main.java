package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jdom2.JDOMException;

import LD.GestorSQL;
import LD.GestorXML;
import LN.Jugador;
import LP.menuPrincipal;

public class Main {

	public static void main(String[] args) throws JDOMException, IOException, SQLException 
	{
		
		GestorSQL gestorS= new GestorSQL();
		gestorS.MostrarPartidas();
		//Connection conn = GestorSQL.ConectarA("Trivial.db"); //Nos conectamos a la BD
		//Statement stmt = conn.createStatement();//Creamos un statement para ejecutar sobre la BD
		
		// String sentencia ="INSERT INTO JUGADOR (ID_J,NOMBRE_J) VALUES('00002','AINHOA')";
		 
		 //stmt.executeUpdate(sentencia);
		
		//String sentencia =" INSERT INTO JUGADOR (ID_J, NOMBRE_J)VALUES('00001','JOSUNE')";
		//stmt.executeUpdate(sentencia);
		
		
	}

}
