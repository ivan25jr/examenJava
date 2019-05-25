package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Dao.DaoEscrituraObject;
import Dao.DaoLecturaObject;

public class Biblioteca{
DaoEscrituraObject deo;
DaoLecturaObject dlo;

List<Libro>ListaLibros;

public Biblioteca(List<Libro>ListaLibros) throws IOException {
	deo= new DaoEscrituraObject();
	dlo= new DaoLecturaObject();
	this.ListaLibros=ListaLibros;
}
public Biblioteca() throws IOException {
	deo= new DaoEscrituraObject();
	dlo= new DaoLecturaObject();
	
	this.ListaLibros=new ArrayList<Libro>();
}
public void añadirLibro(Libro l) {
	ListaLibros.add(l);
}
public List<Libro> ordenarLibros(){
	Collections.sort(this.ListaLibros);
	return ListaLibros;
}
public boolean estaPrestado(Integer identificador) {
	boolean prestado=false;
	for (Libro libro : ListaLibros) {
		if(libro.identificador.compareTo(identificador)==0) {
			prestado= libro.isPrestado();
		}else {
			prestado=false;
		}
	}
	return prestado;
}
public void guardarFichero() throws IOException {
	deo.escrituraFichero(ListaLibros);
}
public void guardarFicheroPrestado() throws IOException {
	deo.escrituraficheroPrestados();
}
public List<Libro> leerFichero() throws IOException{
	return dlo.LeerFichero();
}



}

