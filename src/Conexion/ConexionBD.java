package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
private String user="root";
private String password="";
private String url="jdbc:mysql://localhost:3306/";
private String bd="Biblioteca";
Connection conexion;
Connection conexion2;
public ConexionBD(String nombre) throws ClassNotFoundException, SQLException {
	this.bd=nombre;
	Class.forName("com.mysql.jdbc.Driver");
	conexion= DriverManager.getConnection(url+bd, user, password);
	
	System.out.println("conectado");
}
public ConexionBD() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	conexion2= DriverManager.getConnection(url, user, password);
	System.out.println("conectado2");
}
public Connection getConexion() throws ClassNotFoundException, SQLException {
	if(conexion ==null) {
		new ConexionBD();
	}
	return conexion;
}
public Connection getConexion2() throws ClassNotFoundException, SQLException {
	if(conexion2 ==null) {
		new ConexionBD();
	}
	return conexion2;
}
}
