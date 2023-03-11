package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.LibroDAO;
import entidades.Libro;

public class test {

	public static void main(String[] args) {
		LibroDAO dao = new LibroDAO();
		
		  Libro libro = new Libro(); libro.setEditorial("JAIRO");
		  libro.setIsbn("23-67-1456-58"); libro.setTitulo("Construccion Vale Oro");
		  
		  dao.create(libro); 
		 

		List<Libro> libros = new ArrayList<>();

		libros = dao.getAll();

		for (Libro l : libros) {
			System.out.println(l);
		}

	}

}
