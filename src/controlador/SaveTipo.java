package controlador;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;

public class SaveTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String nombre = req.getParameter("nombre");
		if(nombre != null && nombre.length() != 0){
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			Tipo nuevo = new Tipo(nombre);
			try{
				pm.makePersistent(nuevo);
				System.out.println("Tipo grabado correctamente.");
				req.setAttribute("caso", "tipo");
				req.setAttribute("tipo", nuevo.getId());
				RequestDispatcher rd = req.getRequestDispatcher("servletPermisos");
				rd.forward(req, resp);
						
			}catch(Exception e){
				System.out.println(e);
				resp.getWriter().println("Ocurrió un error, vuelva a intentarlo.");
				resp.sendRedirect("/gmailServlet");
			}finally{
				pm.close();
			}
			
			
		}
		
	}
}
