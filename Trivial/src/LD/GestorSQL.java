package LD;
import java.sql.*;
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
	
	public static void MostrarJugadores() throws SQLException
	{
		Connection conn = GestorSQL.ConectarA("Trivial.db"); //Nos conectamos a la BD
		Statement stmt = conn.createStatement();
		
		String sentencia= "SELECT * FROM JUGADOR";
		
		ResultSet rs = stmt.executeQuery(sentencia);
		
		while(rs.next())
		{
		System.out.print(rs.getString(1));
		
		System.out.println(rs.getString(2));
		}
		rs.close();

	}
	
	public static void GuardarJugadorYEstadistica (String nombre)
	
	{
			//Solo recibidmos por parametro el nombre porque las estadisticas 
			// no tienen ningun otro atributo libre y los ID_J e ID_E se generan 
		// de fiorma mecanica +1.
	}
}
