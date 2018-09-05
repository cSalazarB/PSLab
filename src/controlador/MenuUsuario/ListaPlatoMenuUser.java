package controlador.MenuUsuario;


import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Menu_Dia;
import modelo.Plato;
import modelo.PlatoMenu;
@SuppressWarnings("serial")
public class ListaPlatoMenuUser extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		
		ejecutar(req,resp);	
				
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		ejecutar(req,resp);
	}
	public void ejecutar(HttpServletRequest req,HttpServletResponse resp){
		
		String cat= req.getParameter("categoria");
		
		//System.out.println(cat);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Menu_Dia.class);
		q.setOrdering("anio desc,mes desc,dia desc,hora desc, minuto desc");
		try {
			@SuppressWarnings("unchecked")
			List<Menu_Dia> menu = (List<Menu_Dia>)q.execute();
			
			Menu_Dia mymenu = menu.get(0);
			List<PlatoMenu> pl = listPlatoMenu(mymenu.getPlatos(),cat);
			List<Plato> plato = listPlato(pl);
			
			req.setAttribute("listCantidades", pl);
			req.setAttribute("listPlatos", plato);
			RequestDispatcher rd = req.getRequestDispatcher("/UserJsp/ListaPlatosMenu.jsp");
			rd.forward(req, resp);
			
		}catch (Exception e){
			System.out.println(e);
		}finally {
			q.closeAll();
			pm.close();
		}
		
	}
	private List<PlatoMenu> listPlatoMenu(List<String> list,String tipo){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		List<PlatoMenu> listPlatos = new ArrayList<PlatoMenu>();
		for(String id: list){
			Key k = KeyFactory.stringToKey(id);
			PlatoMenu a = pm.getObjectById(PlatoMenu.class, k);
			
			if(a.getTipo().equals(tipo)){;
				listPlatos.add(a);
			}
		}
		
		return listPlatos;
	}
	private List<Plato> listPlato(List<PlatoMenu> list){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		List<Plato> listPlatos = new ArrayList<Plato>();
		for(PlatoMenu p: list){
			Key k = KeyFactory.stringToKey(p.getPlato());
			Plato a = pm.getObjectById(Plato.class, k);
			
			listPlatos.add(a);
		}
		
		return listPlatos;
	}
}
