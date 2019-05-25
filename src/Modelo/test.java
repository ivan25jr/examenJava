package Modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Conexion.CrearDB;
import Conexion.DaoBBDD;
import Dao.DaoEscrituraObject;
import Dao.DaoLecturaObject;

public class test {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Libro l= new Libro("nieves", "mola mazo", 1);
		Libro l2= new Libro("Junaki", "mola mazo", 1);
		Libro l3= new Libro("nie", "mola mazo", 1);
		
		CrearDB db= new CrearDB();
		db.crear("biblioteca");
		DaoBBDD daob= new DaoBBDD();
		l3.setPrestado(true);
		//DaoLecturaObject dl= new DaoLecturaObject();
		//DaoEscrituraObject deo= new DaoEscrituraObject();
		Biblioteca biblioteca= new Biblioteca();
		biblioteca.añadirLibro(l);
		biblioteca.añadirLibro(l2);
		biblioteca.añadirLibro(l3);
	biblioteca.guardarFichero();
		//biblioteca.guardarFicheroPrestado();
		//stem.out.println(biblioteca.lecturaFichero("Libros.object"));
		List<Libro>libros=biblioteca.leerFichero();
		for (Libro libro : libros) {
			daob.insertar(libro);

		}
		
	}

}
