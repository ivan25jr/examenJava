package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Modelo.Biblioteca;
import Modelo.Libro;

public class DaoEscrituraObject {
	FileOutputStream fos;
	ObjectOutputStream oos;
	String libro= "libros.object";
	public DaoEscrituraObject() throws IOException {
	abrir();
	}
	public DaoEscrituraObject(String nombre) throws IOException {
		this.libro=nombre;
	abrir();
	}
	public void abrir() throws IOException {
		if(oos==null) {
			fos= new FileOutputStream(new File(libro));
			oos= new ObjectOutputStream(fos);
		}
		
		
	}
	public void cerrar() throws IOException {
		if(oos!=null||fos!=null){
			fos.close();
			oos.close();
			fos=null;
			oos=null;
		}
	}
	public void escribirLibro(Libro l) throws IOException {
		if(oos!=null) {
			oos.writeObject(l);
		}
		
	}
	public void escrituraFichero(List<Libro>libros) throws IOException {
		DaoEscrituraObject dao= new DaoEscrituraObject();
		for (Libro libro : libros) {
			oos.writeObject(libro);
		}
		cerrar();
		
	}
	public void escrituraficheroPrestados() throws IOException {
		List<Libro>libros= new ArrayList<Libro>();
		DaoLecturaObject daol= new DaoLecturaObject();
		DaoEscrituraObject daoe= new DaoEscrituraObject("prestados.object");
		
		libros=daol.LeerFichero();
		for (Libro libro : libros) {
			if( libro.isPrestado()==true) {
				
				daoe.escribirLibro(libro);
			}
		}
		
	}

}
