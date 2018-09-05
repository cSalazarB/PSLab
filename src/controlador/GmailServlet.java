package controlador;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.jdo.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import modelo.*;


@SuppressWarnings("serial")
public class GmailServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
	 
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();

		if(user == null){
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));

		}else{
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			if(user!=null){
				this.getServletContext().setAttribute("usuario", us );
				if(user.getEmail().equals("restaurantescondida@gmail.com") ){
					//req.setAttribute("user", us);
					RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
					try {
						rd.forward(req, resp);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					
					final Query q = pm.newQuery(Usuario.class);
					String m = user.getEmail();
					q.setFilter("email == _email");
					q.declareParameters("String _email");

					List<Usuario> usuarios = (List<Usuario>)q.execute(m);

					if(usuarios.size() != 0){
						final Query q3 = pm.newQuery(Permiso.class);
						q3.setFilter("idTipo == _idTipo");
						q3.declareParameters("Long _idTipo");
						q3.setOrdering("idRecurso descending");
						List<Permiso> permisos = (List<Permiso>) q3.execute(usuarios.get(0).getTipo());
						
						final Query q4 = pm.newQuery(Recurso.class);
						q4.setOrdering("idRecurso descending");
						List<Recurso> recursos = (List<Recurso>) q4.execute();
						req.setAttribute("usuario", usuarios.get(0));
						req.setAttribute("recursos", recursos);
						req.setAttribute("permisos", permisos);
						req.setAttribute("user", us);
						RequestDispatcher rd = req.getRequestDispatcher("usuarioIndex.jsp");
						try {
							rd.forward(req, resp);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
					}
					else{
						final Query q2 = pm.newQuery(Tipo.class);
						q2.setOrdering("idTipo descending");

						List<Tipo> tipos = (List<Tipo>) q2.execute();
						
						req.setAttribute("tipos", tipos);
						req.setAttribute("email", user.getEmail());

						RequestDispatcher rd = req.getRequestDispatcher("registrarUsuario.jsp");
						try {
							rd.forward(req,resp);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			
					}

				}

			}	 

		}
	}
}