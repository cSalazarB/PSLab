package controlador.Plato;

import java.io.IOException;


import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Plato;

@SuppressWarnings("serial")
public class ModificarPlato extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String plato = req.getParameter("modificar");
		//creamos una instancia de PersistenceManager
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	Key k = KeyFactory.stringToKey(plato);
			Plato e = pm.getObjectById(Plato.class, k);
			
			req.setAttribute("Plato", e);
			RequestDispatcher rd = req.getRequestDispatcher("/ModificarPlato.jsp");
			rd.forward(req, resp);
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm.close();
		}

		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
