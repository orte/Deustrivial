package LD;
import java.sql.*;
import java.util.ArrayList;

import LN.Jugador;
public class GestorSQL 
{
	public static Connection ConectarA (String ruta)
	{
		// Cargamos el driver
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("No se ha encontrado la libreria");
		}
		
		
		
		 Connection conec = null; // Declaramos la conexion
		 try 
		 {
			 conec = DriverManager.getConnection("jdbc:sqlite:"+ ruta );
			 System.out.println("Conexión realizada correctamente - Ruta de base de datos: " + ruta);
		 }
		 
		 catch (SQLException e)
		 {
			 System.out.println("No se ha encontrado la ruta de la BD");
		 }
		 
		 return conec;
	
	}
	
	public static ArrayList<Jugador> MostrarJugadores()  
	{
		Connection conn = GestorSQL.ConectarA("data/Trivial.db"); //Nos conectamos a la BD
		Statement stmt = null;
	
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		
		String sentencia= "SELECT * FROM JUGADOR";
		
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sentencia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String nombre = " ";
		String id= " ";
		ArrayList<Jugador> datos_J = new ArrayList<Jugador>();
		ArrayList<Jugador> datos_J_aux = new ArrayList<Jugador>();
		int id_int;
		
		Jugador j1;
		
		try {
			
				while(rs.next())
				{
					j1 = new Jugador();
					id =rs.getString(1);
					System.out.println(id);
			
					id_int=Integer.parseInt(id);
					System.out.println(id_int);
					j1.setId(id_int);
			
					nombre= rs.getString(2);
					System.out.println(nombre);
					j1.setNombre_usuario(nombre);
			
					datos_J_aux.add(j1);

				}
				
				
		}
		catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return datos_J_aux;
		
		
		
	}
	
	public static void GuardarJugadorYEstadistica (String nombre)
	
	{
			//Solo recibidmos por parametro el nombre porque las estadisticas 
			// no tienen ningun otro atributo libre y los ID_J e ID_E se generan 
			// de fiorma mecanica +1.
	}
	
	/**public static void MostrarPartidas() throws SQLException
	{
		Connection conn = GestorSQL.ConectarA("data/Trivial.db"); //Nos conectamos a la BD
		Statement stmt = null;
	
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		
		String sentencia= "SELECT * FROM JUGADOR";
		
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sentencia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String nombre = " ";
		String id= " ";
		ArrayList<Jugador> datos_J = new ArrayList<Jugador>();
		ArrayList<Jugador> datos_J_aux = new ArrayList<Jugador>();
		int id_int;
		
		Jugador j1;
		
		try {
			
				while(rs.next())
				{
					j1 = new Jugador();
					id =rs.getString(1);
					System.out.println(id);
			
					id_int=Integer.parseInt(id);
					System.out.println(id_int);
					j1.setId(id_int);
			
					nombre= rs.getString(2);
					System.out.println(nombre);
					j1.setNombre_usuario(nombre);
			
					datos_J_aux.add(j1);

				}
				
				
		}
		catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return datos_J_aux;
		
		
		
		
		
		
		
	}**/

}
