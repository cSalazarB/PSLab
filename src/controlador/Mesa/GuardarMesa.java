package controlador.Mesa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;


import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Mesa;

@SuppressWarnings("serial")
public class GuardarMesa extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ejecutar(req,resp);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException { 
		ejecutar(request, response);
	}
	public void ejecutar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String nombre= req.getParameter("nombre");
		String sillas= req.getParameter("sillas");
		int numSillas=Integer.parseInt(sillas);
		String imagen= req.getParameter("imagen");
		String disponible= req.getParameter("disponible");
		if(disponible==null)disponible="false";
		
		boolean disp=Boolean.parseBoolean(disponible);
		
		String id=req.getParameter("idMesa");
		
		if(id==null){
		
			Mesa miMesa = new Mesa(nombre,numSillas,imagen,disp);
			//creamos una instancia de PersistenceManager
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
				pm.makePersistent(miMesa);
				
				Key k = KeyFactory.stringToKey(miMesa.getIdMesa());
				@SuppressWarnings("unused")
				Mesa a = pm.getObjectById(Mesa.class,k);
				
				resp.sendRedirect("listamesa");
	
				}
			finally {
				pm.close();
			}
		}else{
			PersistenceManager pm = PMF.get().getPersistenceManager();
		    try {
		    	Key k = KeyFactory.stringToKey(id);
				Mesa e = pm.getObjectById(Mesa.class, k);
				
				e.setNombre(nombre);
				e.setImagen(imagen);
				e.setDisponible(disp);
				
				resp.sendRedirect("listamesa");
			}catch(Exception e){
				System.out.println(e);
			}finally{
				pm.close();
			}
		}	
	}
}
