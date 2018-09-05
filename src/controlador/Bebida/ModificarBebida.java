package controlador.Bebida;

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
import modelo.Bebida;

@SuppressWarnings("serial")
public class ModificarBebida extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String bebida = req.getParameter("modificar");	
		//creamos una instancia de PersistenceManager
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	    	Key k = KeyFactory.stringToKey(bebida);
			Bebida e = pm.getObjectById(Bebida.class, k);
			
			req.setAttribute("Bebida", e);
			RequestDispatcher rd = req.getRequestDispatcher("/ModificarBebida.jsp");
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
