package controlador;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.Query;
import javax.jdo.Transaction;

//import com.google.appengine.api.users.User;
//import com.google.appengine.api.users.UserService;
//import com.google.appengine.api.users.UserServiceFactory;

import modelo.*;

@SuppressWarnings("serial")
public class CambiarPermisos extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/html");
		
		String permisos = req.getParameter("permisos");
		System.out.println("permisos: "+permisos);

		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Permiso.class);
		q.setOrdering("idTipo descending, idRecurso descending");

		List<Permiso> lista = (List<Permiso>)q.execute();

		int size = permisos.length();
		Transaction tx = pm.currentTransaction();
		tx.begin();

		try{
			String sal = "";
			for(int i=0;i< size;i++){
				for (int j = 0; j < lista.size(); j++) {
					System.out.print(lista.get(j).getEnable());
				}
				System.out.println();
				boolean v = lista.get(i).getEnable();
				if(v)
					sal+="1";
				else
					sal+="0";
				
				boolean enable;
				if(permisos.charAt(i) == '1')
					enable = true;
				else
					enable = false;
				if(!(lista.get(i).getEnable() ^ enable))
					continue;
				Permiso found = pm.getObjectById(Permiso.class,lista.get(i).getId());
				if(enable)
					found.setEnable(true);
				else
					found.setEnable(false);

			}
			System.out.println(sal);
			tx.commit();
			resp.getWriter().println("<h4> Cambios Realizados con Exito </h4>");

		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("<h4> Ocurrio un Error, Vuelva a Intentarlo </h4>");
		}finally{
			try {
				if (tx.isActive())
					tx.rollback();
			} finally {
				pm.close();
			}}
	}
}