package controlador.Bebida;

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
import modelo.Bebida;

@SuppressWarnings("serial")
public class ListaBebida extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ejecutar(req,resp);						
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ejecutar(req,resp);
	}
	public void ejecutar(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Bebida.class);
		
		try{
			@SuppressWarnings("unchecked")
			List<Bebida> bebidas = (List<Bebida>) q.execute();
			req.setAttribute("listaBebidas", bebidas);
			RequestDispatcher rd = req.getRequestDispatcher("/ListaBebidas.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			q.closeAll();
			pm.close();
		}
		
	}
}
