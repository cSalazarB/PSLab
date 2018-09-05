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
import modelo.BebidaMenu;
import modelo.Menu_Dia;
import modelo.Bebida;
@SuppressWarnings("serial")
public class ListaBebidaMenuUser extends HttpServlet {
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
			List<BebidaMenu> pl = listBebidaMenu(mymenu.getBebidas(),cat);
			List<Bebida> bebida = listBebida(pl);
			
			req.setAttribute("listCantidades", pl);
			req.setAttribute("listBebidas", bebida);
			RequestDispatcher rd = req.getRequestDispatcher("/UserJsp/ListaBebidasMenu.jsp");
			rd.forward(req, resp);
			
		}catch (Exception e){
			System.out.println(e);
		}finally {
			q.closeAll();
			pm.close();
		}
		
	}
	private List<BebidaMenu> listBebidaMenu(List<String> list,String tipo){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		List<BebidaMenu> listBebidas = new ArrayList<BebidaMenu>();
		for(String id: list){
			Key k = KeyFactory.stringToKey(id);
			BebidaMenu a = pm.getObjectById(BebidaMenu.class, k);
			
			if(a.getTipo().equals(tipo)){;
				listBebidas.add(a);
			}
		}
		
		return listBebidas;
	}
	private List<Bebida> listBebida(List<BebidaMenu> list){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		List<Bebida> listBebidas = new ArrayList<Bebida>();
		for(BebidaMenu p: list){
			Key k = KeyFactory.stringToKey(p.getBebida());
			Bebida a = pm.getObjectById(Bebida.class, k);
			
			listBebidas.add(a);
		}
		
		return listBebidas;
	}
}
