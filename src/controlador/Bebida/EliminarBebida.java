package controlador.Bebida;

import java.io.IOException;

import javax.jdo.PersistenceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Bebida;

@SuppressWarnings("serial")
public class EliminarBebida extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/plain");
		
		String bebidas = req.getParameter("eliminar");
		req.getSession().setAttribute("tipo_producto", "bebidas");		
		//creamos una istancia de PersistenceManager
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			
			Key k = KeyFactory.stringToKey(bebidas);
			Bebida a = pm.getObjectById(Bebida.class, k);
			
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