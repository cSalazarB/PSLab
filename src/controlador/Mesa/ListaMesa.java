package controlador.Mesa;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.PMF;
import modelo.Mesa;



@SuppressWarnings("serial")
public class ListaMesa extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Mesa.class);
		
		try{
			@SuppressWarnings("unchecked")
			List<Mesa> Mesas = (List<Mesa>) q.execute();
			req.setAttribute("listaMesas", Mesas);
			RequestDispatcher rd = req.getRequestDispatcher("/ListaMesas.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			q.closeAll();
			pm.close();
		}
			
				
	}
}
