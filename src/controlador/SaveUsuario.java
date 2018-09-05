package controlador;
import modelo.*;

import java.io.IOException;
//import java.util.List;

import javax.jdo.PersistenceManager;
//import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveUsuario extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String nombre = req.getParameter("nombre");
		String email = req.getParameter("email");
		String keyTipo = req.getParameter("tipo");
		String sexo = req.getParameter("sexo");

		System.out.println(nombre);
		System.out.println(email);
		System.out.println(sexo);

		Usuario nuevo = new Usuario(email, nombre, Boolean.parseBoolean(sexo)); 
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.begin();


		try{
			Tipo found = pm.getObjectById(Tipo.class, Long.parseLong(keyTipo));
			nuevo.setTipo(found);			

			try{
				pm.makePersistent(nuevo);
				tx.commit();
				System.out.println("Persona grabada correctamente.");
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
			}}		



	}

}
