package controlador.Bebida;

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
import modelo.Bebida;

@SuppressWarnings("serial")
public class GuardarBebida extends HttpServlet {
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse	resp) throws ServletException, IOException { 
		resp.setContentType("text/html");
		
		String nombre= req.getParameter("nombre");
		String precio= req.getParameter("precio");
		double costo=Double.parseDouble(precio);
		String categoria= req.getParameter("categoria");
				
		String id = (String)req.getParameter("idBebida");
		req.getSession().setAttribute("tipo_producto", "bebidas");
		
		if( id.equals("vacio") ){ //SI ES QUE LA BEBIDA ES NUEVA
			
			Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		    List<BlobKey> blobKeys = blobs.get("imagen");
		         
			Bebida mibebida=new Bebida();
			mibebida.setNombre(nombre);
			mibebida.setPrecio(costo);	
			mibebida.setCategoria(categoria); 
			mibebida.setKeyoutsideImage( blobKeys.get(0).getKeyString() );
			//creamos una instancia de PersistenceManager
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
				
				pm.makePersistent(mibebida);//HACEMOS PERSISTSTENTE EL OBJETO	
				req.setAttribute("operacion", "añadir");

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
				Bebida e = pm.getObjectById(Bebida.class, k);
				
				e.setNombre(nombre);
				e.setPrecio(costo);
				e.setCategoria(categoria);
				if( blobKeys != null && !blobKeys.isEmpty() )
					e.setKeyoutsideImage(blobKeys.get(0).getKeyString());
				
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
