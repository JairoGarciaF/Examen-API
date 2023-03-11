package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Libro;

public class LibroDAO {

	private EntityManager em;

	public LibroDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaLibro");
		em = emf.createEntityManager();
	}

	public Libro getById(int id) {
		return em.find(Libro.class, id);
	}

	public List<Libro> getAll() {
		String JPQL = "SELECT l FROM Libro l";
		Query consulta = this.em.createQuery(JPQL);
		List<Libro> libros = consulta.getResultList();
		return libros;
	}

	public void create(Libro libro) {
		em.getTransaction().begin();
		try {
			em.persist(libro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Fallo en la creación del libro");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

	}

	public void update(Libro libro) {
		em.getTransaction().begin();
		try {
			em.merge(libro);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Fallo en la actualizacion del libro");
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}
	
	public void deleteById(int id) {
		Libro libro = this.getById(id);
		if (libro != null) {
			em.getTransaction().begin();
			try {
				em.remove(libro);
				em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Error en eliminar libro");
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			}

		}
	}

}
