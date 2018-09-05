package controlador.Plato;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Plato;

@SuppressWarnings("serial")
public class GuardarPlato extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		
		String nombre= req.getParameter("nombre");
		String precio= req.getParameter("precio");
		double costo= Double.parseDouble(precio);
		String categoria= req.getParameter("categoria");
		String descripcion= req.getParameter("descripcion");
		
		String id=req.getParameter("idPlato");
		req.getSession().setAttribute("tipo_producto", "platos");
		
		if( id.equals("vacio") ){
			
			Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		    List<BlobKey> blobKeys = blobs.get("imagen");
		
			Plato miPlato = new Plato(nombre,descripcion,categoria,costo, blobKeys.get(0).getKeyString() );
			//creamos una instancia de PersistenceManager
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
				pm.makePersistent(miPlato);		
				req.setAttribute("operacion", "añadir" );
				
				req.getSession().setAttribute("operacion", "añadir");
				resp.sendRedirect("/ExitoEnOperacion.jsp");
			}catch(Exception e){
				System.out.println(e);
			}finally {
				pm.close();
			}
		}else{
			
			Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		    List<BlobKey> blobKeys = blobs.get("imagen_modi");
			PersistenceManager pm = PMF.get().getPersistenceManager();
		    try {
		    	Key k = KeyFactory.stringToKey(id);
				Plato e = pm.getObjectById(Plato.class, k);
				
				e.setNombre(nombre);
				e.setPrecio(costo);
				e.setCategoria(categoria);
				if( blobKeys != null && !blobKeys.isEmpty() )
					e.setKeyoutsideImage(blobKeys.get(0).getKeyString());
				e.setDescripcion(descripcion);
				
				req.getSession().setAttribute("operacion", "editar");
				resp.sendRedirect("/ExitoEnOperacion.jsp");
			}catch(Exception e){
				System.out.println(e);
			}finally{
				pm.close();
			}
		}	
	}
	
}
