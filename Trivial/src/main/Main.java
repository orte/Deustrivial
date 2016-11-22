package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jdom2.JDOMException;

import LD.GestorSQL;
import LD.GestorXML;

public class Main {

	public static void main(String[] args) throws JDOMException, IOException, SQLException 
	{
		
		GestorSQL gestorS= new GestorSQL();
		gestorS.MostrarJugadores();
		//Connection conn = GestorSQL.ConectarA("Trivial.db"); //Nos conectamos a la BD
		//Statement stmt = conn.createStatement();//Creamos un statement para ejecutar sobre la BD
		
		// String sentencia ="INSERT INTO JUGADOR (ID_J,NOMBRE_J) VALUES('00002','AINHOA')";
		 
		 //stmt.executeUpdate(sentencia);
		
		//String sentencia =" INSERT INTO JUGADOR (ID_J, NOMBRE_J)VALUES('00001','JOSUNE')";
		//stmt.executeUpdate(sentencia);
		
/**String sentencia= "SELECT * FROM JUGADOR";
	
	ResultSet rs = stmt.executeQuery(sentencia);
	
	while(rs.next())
	{
	System.out.print(rs.getString(1));
	
	System.out.println(rs.getString(2));
	}
	rs.close();
	
	**/

		
	}

}
