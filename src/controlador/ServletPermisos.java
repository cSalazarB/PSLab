package controlador;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import modelo.*;

public class ServletPermisos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String caso = (String) req.getAttribute("caso");
		Long idTipo = (Long) req.getAttribute("tipo");
		Long idRecurso = (Long) req.getAttribute("recurso");
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		if(caso != null && caso.equals("tipo")){
			final Query q = pm.newQuery(Recurso.class);
			q.setOrdering("idRecurso descending");
			List<Recurso> recursos = (List<Recurso>)q.execute();
			Transaction tx = pm.currentTransaction();
			tx.begin();		
			try{
				try{
					for(Recurso rs : recursos){	
						Permiso nuevo;
						nuevo = new Permiso(idTipo, rs.getId());
						pm.makePersistent(nuevo);						
					}
					tx.commit();
					req.setAttribute("caso", null);
					req.setAttribute("tipo", null);
					System.out.println("Recursos agregados a Tipo correctamente.");
					resp.sendRedirect("/gmailServlet");
				}catch(Exception e){
					System.out.println(e);
					System.out.println("Ocurrió un error, vuelva a intentarlo.");
					resp.sendRedirect("/gmailServlet");
				}

			}catch(Exception e){
				System.out.println(e);
			}finally{
				try {
					if (tx.isActive())
						tx.rollback();
				} finally {
					pm.close();
				}
			}	
		}else if(idRecurso != null && caso.equals("recurso")){
			final Query q = pm.newQuery(Tipo.class);
			q.setOrdering("idTipo descending");
			List<Tipo> tipos = (List<Tipo>)q.execute();
			Transaction tx = pm.currentTransaction();
			tx.begin();		
			try{
				try{
					for(Tipo tp : tipos){
						Permiso nuevo;
						nuevo = new Permiso(tp.getId(), idRecurso);
						pm.makePersistent(nuevo);						
					}
					tx.commit();
					req.setAttribute("caso", null);
					req.setAttribute("tipo", null);
					System.out.println("Agregando recurso a tipos  correctamente.");
					resp.sendRedirect("/gmailServlet");
				}catch(Exception e){
					System.out.println(e);
					System.out.println("Ocurrió un error, vuelva a intentarlo.");
					resp.sendRedirect("/gmailServlet");
				}

			}catch(Exception e){
				System.out.println(e);
			}finally{
				try {
					if (tx.isActive())
						tx.rollback();
				} finally {
					pm.close();
				}
			}		
		}else{
			System.out.println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("/gmailServlet.html");
		}
	}
}
