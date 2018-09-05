package controlador;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.Query;
import modelo.*;

public class ListUsuario extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Usuario.class);
		q.setOrdering("idUsuario descending");

		List<Usuario> usuarios = (List<Usuario>)q.execute();
		req.setAttribute("usuarios",usuarios);
		RequestDispatcher rd = req.getRequestDispatcher("/listUsuario.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}






	}
}
