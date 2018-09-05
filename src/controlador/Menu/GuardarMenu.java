package controlador.Menu;

import java.io.IOException;
import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import controlador.PMF;
import modelo.Bebida;
import modelo.BebidaMenu;
import modelo.Menu_Dia;
import modelo.Plato;
import modelo.PlatoMenu;

@SuppressWarnings("serial")
public class GuardarMenu extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		ArrayList<Plato> misEntradas=(ArrayList<Plato>)getServletContext().getAttribute("misEntradas");
		ArrayList<String> misCanEntradas=(ArrayList<String>)getServletContext().getAttribute("misCanEntradas");

		ArrayList<Plato> misFondos=(ArrayList<Plato>)getServletContext().getAttribute("misFondos");
		ArrayList<String> misCanFondos=(ArrayList<String>)getServletContext().getAttribute("misCanFondos");

		ArrayList<Plato> misPostres=(ArrayList<Plato>)getServletContext().getAttribute("misPostres");
		ArrayList<String> misCanPostres=(ArrayList<String>)getServletContext().getAttribute("misCanPostres");

		ArrayList<Bebida> misGaseosas=(ArrayList<Bebida>)getServletContext().getAttribute("misGaseosas");
		ArrayList<String> misCanGaseosas=(ArrayList<String>)getServletContext().getAttribute("misCanGaseosas");

		ArrayList<Bebida> misCervezas=(ArrayList<Bebida>)getServletContext().getAttribute("misCervezas");
		ArrayList<String> misCanCervezas=(ArrayList<String>)getServletContext().getAttribute("misCanCervezas");

		ArrayList<Bebida> misRefrescos=(ArrayList<Bebida>)getServletContext().getAttribute("misRefrescos");
		ArrayList<String> misCanRefrescos=(ArrayList<String>)getServletContext().getAttribute("misCanRefrescos");
		
		
		Menu_Dia miMenu = new Menu_Dia();
		
		ArrayList<String> dataPlatos = new ArrayList<String>();
		ArrayList<String> dataBebidas = new ArrayList<String>();
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			if(misEntradas != null){
				for(int i = 0; i< misEntradas.size();i++){
					PlatoMenu plato = new PlatoMenu(misEntradas.get(i),Integer.parseInt(misCanEntradas.get(i)),"Entrada");
					pm.makePersistent(plato);
					dataPlatos.add(plato.getIdPlatoMenu());
				}
			}
			if(misFondos != null){
				for(int i = 0; i< misFondos.size();i++){
					PlatoMenu plato = new PlatoMenu(misFondos.get(i),Integer.parseInt(misCanFondos.get(i)),"Fondo");
					pm.makePersistent(plato);
					dataPlatos.add(plato.getIdPlatoMenu());
				}
			}
			if(misPostres != null){
				for(int i = 0; i< misPostres.size();i++){
					PlatoMenu plato = new PlatoMenu(misPostres.get(i),Integer.parseInt(misCanPostres.get(i)),"Postre");
					pm.makePersistent(plato);
					dataPlatos.add(plato.getIdPlatoMenu());
				}
			}
			miMenu.setPlatos(dataPlatos);
			
			
			//AQUI PARA BEBIDAS
			if(misGaseosas != null){
				for(int i = 0; i< misGaseosas.size();i++){
					BebidaMenu bebida = new BebidaMenu(misGaseosas.get(i),Integer.parseInt(misCanGaseosas.get(i)),"Gaseosa");
					pm.makePersistent(bebida);
					dataBebidas.add(bebida.getIdBebidaMenu());
				}
			}
			if(misCervezas != null){
				for(int i = 0; i< misCervezas.size();i++){
					BebidaMenu bebida = new BebidaMenu(misCervezas.get(i),Integer.parseInt(misCanCervezas.get(i)),"Cerveza");
					pm.makePersistent(bebida);
					dataBebidas.add(bebida.getIdBebidaMenu());
				}
			}
			if(misRefrescos != null){
				for(int i = 0; i< misRefrescos.size();i++){
					BebidaMenu bebida = new BebidaMenu(misRefrescos.get(i),Integer.parseInt(misCanRefrescos.get(i)),"Refresco");
					pm.makePersistent(bebida);
					dataBebidas.add(bebida.getIdBebidaMenu());
				}
			}
			miMenu.setBebidas(dataBebidas);
			pm.makePersistent(miMenu);
			
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/Final_Menu_Elegido.jsp");
			rd.forward(req, resp);
		}finally{
			pm.close();
		}
		
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse	response) throws ServletException, IOException { 
		doGet(request, response);
	}
}
