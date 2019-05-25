package Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.swing.CellEditor;

import Modelo.Libro;

public class DaoLecturaObject {
FileInputStream fis;
ObjectInputStream ois;
String nombre="libros.object";
public DaoLecturaObject() throws IOException {
	abrir();
	}
public void abrir() throws IOException {
	if(ois==null) {
		fis= new FileInputStream(new File(nombre));
		ois= new ObjectInputStream(fis);
	}
	
	
}
public void cerrar() throws IOException {
	if(ois!=null){
		fis.close();
		ois.close();
		fis=null;
		ois=null;
	}
}
public Libro leerLibro() throws IOException, ClassNotFoundException {
	if(ois != null) {
		 Libro al= new Libro();
		 al=(Libro) ois.readObject();
		 return al;
	 }else {
		 throw new IOException();
	 }
}
public List<Libro> LeerFichero() throws IOException{
	List<Libro>libros= new ArrayList<Libro>();
	Libro l= new Libro();
	DaoLecturaObject dlo= new DaoLecturaObject();

	
	try {
			while (true) {
				l=dlo.leerLibro();
				libros.add(l);
			}
		
		
	} catch (Exception e) {
		
	}
	return libros;
	}

}
