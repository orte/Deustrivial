package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datos {

	private final String RUTABD = "data/trivial";
	
	public Connection conectar(){
		try{
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:sqlite:"+RUTABD);
		} catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	public ResultSet obtenerDatos(String sentencia){
		Connection conn = conectar();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sentencia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rs;
	}
	public void guardarDatos(String sentencia){
		Connection conn = conectar();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.executeUpdate(sentencia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
