package Modelo;
import java.io.Serializable;

import Interzaf.Ordenable;

public class Libro implements Serializable, Comparable<Libro> {

	private String titulo;
	private String descripcion;
	private boolean prestado;
	public Integer tipoDeLibro;
	public static Integer contador=0;
	public Integer identificador=100;
	public Libro() {
		
	}
	public Libro(String titulo, String de, Integer tidl) {
		this.titulo=titulo;
		this.descripcion= de;
		prestado=false;
		tipoDeLibro=tidl;
		identificador=identificador+contador;
		
		contador++;

	}
	public Libro(String titutlo,String des) {
		this(titutlo,des,3);
	}
	public Libro(String cadena) {
		String[] array= cadena.split(",");
	}
	public boolean isPrestado() {
		return prestado;
	}
	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	@Override
	public int compareTo(Libro o) {
		int compara;
		compara=identificador.compareTo(o.identificador);
		return compara;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", descripcion=" + descripcion + ", prestado=" + prestado + ", tipoDeLibro="
				+ tipoDeLibro + ", contador=" + contador + ", identificador=" + identificador + "]";
	}
	

}
