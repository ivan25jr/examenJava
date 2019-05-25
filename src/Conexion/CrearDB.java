package Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearDB {
	Connection conexion;
	ConexionBD bd;
public CrearDB() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated constructor stub
	bd= new ConexionBD();
	conexion=bd.getConexion2();
}
public void crear(String nombre) throws SQLException {
	String sql="create database "+nombre;
	String sql1="use "+nombre;
	Statement cr= conexion.createStatement();
	Statement cr1= conexion.createStatement();
	
	cr.executeUpdate(sql);
	cr1.executeUpdate(sql1);
	cr1.close();
	cr.close();
	crearTabla();
}
public void crearTabla() throws SQLException {
	String sql="CREATE TABLE IF NOT EXISTS `libro` (`identificador` int(11) NOT NULL,`titulo` varchar(25) NOT NULL,`descripcion` varchar(25) NOT NULL,`prestado` tinyint(1) NOT NULL,  `tipoLibro` int(11) NOT NULL) ENGINE=MyISAM DEFAULT CHARSET=latin1;";
	Statement cr= conexion.createStatement();
	cr.executeUpdate(sql);
	cr.close();
}
public void eliminarBD(String nombre) throws SQLException {
	String sql="drop database "+nombre;
	Statement cr= conexion.createStatement();
	cr.executeUpdate(sql);
	cr.close();
}
}
