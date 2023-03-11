package recurso;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.LibroDAO;
import entidades.Libro;

@Path("/libros")
public class RecursoLibro {

	private LibroDAO dao = new LibroDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> getAll() {
		return dao.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Libro getById(@PathParam("id") int id) {
		return dao.getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean crearLibro(Libro l) {
		boolean flag = true;
		try {
			dao.create(l);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/update")
	public boolean actualizarLibro(Libro l) {
		boolean flag = true;
		try {
			dao.update(l);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/delete/{id}")
	public boolean eliminarLibro(@PathParam("id") int id) {
		boolean bandera = true;
		try {
			dao.deleteById(id);
		} catch (Exception e) {
			bandera = false;
		}
		return bandera;
	}

}
