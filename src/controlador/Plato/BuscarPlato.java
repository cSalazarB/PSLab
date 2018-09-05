package controlador.Plato;

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
import modelo.Plato;
@SuppressWarnings("serial")
public class BuscarPlato extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		String cat= req.getParameter("categoria");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Plato.class);
		q.setFilter("categoria == '"+cat+"'");
		
		try{
			@SuppressWarnings("unchecked")
			List<Plato> platos = (List<Plato>) q.execute();
			req.setAttribute("listaPlatos", platos);
			RequestDispatcher rd = req.getRequestDispatcher("/ListaPlatos.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			q.closeAll();
			pm.close();
		}
			
				
	}

}
