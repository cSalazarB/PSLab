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

public class ListPermisos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q1 = pm.newQuery(Tipo.class);
		q1.setOrdering("idTipo descending");
		
		final Query q2 = pm.newQuery(Recurso.class);
		q2.setOrdering("idRecurso descending");
		
		final Query q3 = pm.newQuery(Permiso.class);
		q3.setOrdering("idTipo descending, idRecurso descending");
		
		List<Tipo> tipos = (List<Tipo>)q1.execute();
		List<Recurso> recursos = (List<Recurso>)q2.execute();
		List<Permiso> permisos = (List<Permiso>)q3.execute();
		
		req.setAttribute("tipos",tipos);
		req.setAttribute("recursos",recursos);
		req.setAttribute("permisos",permisos);
		RequestDispatcher rd = req.getRequestDispatcher("/tablaPermisos.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}