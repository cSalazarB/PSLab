package controlador.Plato;

import java.io.IOException;


import javax.jdo.PersistenceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Plato;

@SuppressWarnings("serial")
public class EliminarPlato extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String plato = req.getParameter("eliminar");
				
		PersistenceManager pm = PMF.get().getPersistenceManager();
		req.getSession().setAttribute("tipo_producto", "platos");
		try {
			Key k = KeyFactory.stringToKey(plato);
			Plato a = pm.getObjectById(Plato.class, k);
			
			pm.deletePersistent(a);
				
			req.getSession().setAttribute("operacion", "eliminar");
			resp.sendRedirect("/ExitoEnOperacion.jsp");
		}
		finally{
			pm.close();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException { 
		doGet(request, response);
	}
}