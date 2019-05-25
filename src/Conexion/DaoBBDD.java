package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Libro;

public class DaoBBDD {
Connection conexion;
ConexionBD bd;
public DaoBBDD() throws ClassNotFoundException, SQLException {
	bd= new ConexionBD("biblioteca");
	conexion= bd.getConexion();
}
public void insertar(Libro v) throws SQLException {
	String Sql= "insert into Libro values (?,?,?,?,?)";
	
	PreparedStatement psPreparedStatement= conexion.prepareStatement(Sql);
	psPreparedStatement.setInt(1, v.identificador);
	psPreparedStatement.setString(2, v.getTitulo());
	psPreparedStatement.setString(3, v.getDescripcion());
	psPreparedStatement.setBoolean(4, v.isPrestado());
	psPreparedStatement.setInt(5, v.tipoDeLibro);
	
	
	 psPreparedStatement.executeUpdate();
	 psPreparedStatement.close();
	 System.out.println("ejecutado");
}
}
