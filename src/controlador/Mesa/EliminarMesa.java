package controlador.Mesa;

import java.io.IOException;


import javax.jdo.PersistenceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Mesa;

@SuppressWarnings("serial")
public class EliminarMesa extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String[] mesas = req.getParameterValues("eliminar[]");
				
		//creamos una instancia de PersistenceManager
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			//pm.makePersistent(miMesa);
			for(int i=0;i<mesas.length;i++){
				Key k = KeyFactory.stringToKey(mesas[i]);
				Mesa a = pm.getObjectById(Mesa.class, k);
				
				pm.deletePersistent(a);
				
			}
			//pm.close();
			
			/*final PersistenceManager pms = PMF.get().getPersistenceManager();
			final Query q = pms.newQuery(Mesa.class);
			
			try{
				@SuppressWarnings("unchecked")
				List<Mesa> lismesas = (List<Mesa>) q.execute();
				req.setAttribute("listaMesas", lismesas);
				RequestDispatcher rd = req.getRequestDispatcher("/ListaMesas.jsp");
				rd.forward(req, resp);
			}catch(Exception e){
				System.out.println(e);
			}finally{
				q.closeAll();
				pms.close();
			}*/
			resp.sendRedirect("listamesa");
	}
	finally{
		pm.close();
	}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException { 
		doGet(request, response);
	}
}