package controlador.Menu;

import java.io.IOException;
import java.util.ArrayList;


import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controlador.PMF;
import modelo.Bebida;
import modelo.Plato;

@SuppressWarnings("serial")
public class ListaMenuSeleccionado  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String[] codigos = req.getParameterValues("codigos[]");
		String[] cantidades = req.getParameterValues("cantidades[]");
		String tipo = req.getParameter("clase");
		
		//HttpSession getServletContext()= req.getSession();
				
		
		//creamos una instancia de PersistenceManager
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			if(tipo.equals("Entrada")||tipo.equals("Plato de Fondo")||tipo.equals("Postre")){
				
				if(tipo.equals("Entrada")){
					@SuppressWarnings("unchecked")
					ArrayList<Plato> misEntradas=(ArrayList<Plato>)getServletContext().getAttribute("misEntradas");
					@SuppressWarnings("unchecked")
					ArrayList<String> misCanEntradas=(ArrayList<String>)getServletContext().getAttribute("misCanEntradas");
					if(misEntradas==null){
						misEntradas = new ArrayList<Plato>();
						misCanEntradas = new ArrayList<String>();
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Plato a = pm.getObjectById(Plato.class, k);
							misEntradas.add(a);
							misCanEntradas.add(cantidades[i]);
						}
					    
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<misEntradas.size();j++){
								if(misEntradas.get(j).getIdPlato().equals(codigos[i])){
									int num =Integer.parseInt(misCanEntradas.get(j))+Integer.parseInt(cantidades[i]);
									misCanEntradas.set(j, num+"");
									break;
								}
							}
							if(j==misEntradas.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Plato a = pm.getObjectById(Plato.class, k);
								misEntradas.add(a);
								misCanEntradas.add(cantidades[i]);
							}
						}
						
					}
					getServletContext().setAttribute("misEntradas", misEntradas);
				    getServletContext().setAttribute("misCanEntradas", misCanEntradas);
						
				}
				else if(tipo.equals("Plato de Fondo")){
					@SuppressWarnings("unchecked")
					ArrayList<Plato> misFondos=(ArrayList<Plato>)getServletContext().getAttribute("misFondos");
					@SuppressWarnings("unchecked")
					ArrayList<String> misCanFondos=(ArrayList<String>)getServletContext().getAttribute("misCanFondos");
					if(misFondos==null){
						misFondos = new ArrayList<Plato>();
						misCanFondos = new ArrayList<String>();
						
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Plato a = pm.getObjectById(Plato.class, k);
							misFondos.add(a);
							misCanFondos.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<misFondos.size();j++){
								if(misFondos.get(j).getIdPlato().equals(codigos[i])){
									int num =Integer.parseInt(misCanFondos.get(j))+Integer.parseInt(cantidades[i]);
									misCanFondos.set(j, num+"");
									break;
								}
							}
							if(j==misFondos.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Plato a = pm.getObjectById(Plato.class, k);
								misFondos.add(a);
								misCanFondos.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("misFondos", misFondos);
				    getServletContext().setAttribute("misCanFondos", misCanFondos);
				}
				else{
					@SuppressWarnings("unchecked")
					ArrayList<Plato> misPostres=(ArrayList<Plato>)getServletContext().getAttribute("misPostres");
					@SuppressWarnings("unchecked")
					ArrayList<String> misCanPostres=(ArrayList<String>)getServletContext().getAttribute("misCanPostres");
					if(misPostres==null){
						misPostres = new ArrayList<Plato>();
						misCanPostres = new ArrayList<String>();
					    
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Plato a = pm.getObjectById(Plato.class, k);
							misPostres.add(a);
							misCanPostres.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<misPostres.size();j++){
								if(misPostres.get(j).getIdPlato().equals(codigos[i])){
									int num =Integer.parseInt(misCanPostres.get(j))+Integer.parseInt(cantidades[i]);
									misCanPostres.set(j, num+"");
									break;
								}
							}
							if(j==misPostres.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Plato a = pm.getObjectById(Plato.class, k);
								misPostres.add(a);
								misCanPostres.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("misPostres", misPostres);
				    getServletContext().setAttribute("misCanPostres",misCanPostres);
				}
				
			}
			else if(tipo.equals("Gaseosa")||tipo.equals("Refresco")||tipo.equals("Cerveza")){
				if(tipo.equals("Gaseosa")){
					@SuppressWarnings("unchecked")
					ArrayList<Bebida> misGaseosas=(ArrayList<Bebida>)getServletContext().getAttribute("misGaseosas");
					@SuppressWarnings("unchecked")
					ArrayList<String> misCanGaseosas=(ArrayList<String>)getServletContext().getAttribute("misCanGaseosas");
					if(misGaseosas==null){
						misGaseosas = new ArrayList<Bebida>();
						misCanGaseosas = new ArrayList<String>();
					    
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Bebida a = pm.getObjectById(Bebida.class, k);
							misGaseosas.add(a);
							misCanGaseosas.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<misGaseosas.size();j++){
								if(misGaseosas.get(j).getIdBebida().equals(codigos[i])){
									int num =Integer.parseInt(misCanGaseosas.get(j))+Integer.parseInt(cantidades[i]);
									misCanGaseosas.set(j, num+"");
									break;
								}
							}
							if(j==misGaseosas.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Bebida a = pm.getObjectById(Bebida.class, k);
								misGaseosas.add(a);
								misCanGaseosas.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("misGaseosas", misGaseosas);
				    getServletContext().setAttribute("misCanGaseosas",misCanGaseosas);				
						
				}
				else if(tipo.equals("Refresco")){
					@SuppressWarnings("unchecked")
					ArrayList<Bebida> misRefrescos=(ArrayList<Bebida>)getServletContext().getAttribute("misRefrescos");
					@SuppressWarnings("unchecked")
					ArrayList<String> misCanRefrescos=(ArrayList<String>)getServletContext().getAttribute("misCanRefrescos");
					if(misRefrescos==null){
						misRefrescos = new ArrayList<Bebida>();
						misCanRefrescos = new ArrayList<String>();
					   
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Bebida a = pm.getObjectById(Bebida.class, k);
							misRefrescos.add(a);
							misCanRefrescos.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<misRefrescos.size();j++){
								if(misRefrescos.get(j).getIdBebida().equals(codigos[i])){
									int num =Integer.parseInt(misCanRefrescos.get(j))+Integer.parseInt(cantidades[i]);
									misCanRefrescos.set(j, num+"");
									break;
								}
							}
							if(j==misRefrescos.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Bebida a = pm.getObjectById(Bebida.class, k);
								misRefrescos.add(a);
								misCanRefrescos.add(cantidades[i]);
							}
						}
					}
					 getServletContext().setAttribute("misRefrescos", misRefrescos);
					 getServletContext().setAttribute("misCanRefrescos",misCanRefrescos);				
				
				}
				else{
					@SuppressWarnings("unchecked")
					ArrayList<Bebida> misCervezas=(ArrayList<Bebida>)getServletContext().getAttribute("misCervezas");
					@SuppressWarnings("unchecked")
					ArrayList<String> misCanCervezas=(ArrayList<String>)getServletContext().getAttribute("misCanCervezas");
					if(misCervezas==null){
						misCervezas = new ArrayList<Bebida>();
						misCanCervezas = new ArrayList<String>();
					    
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Bebida a = pm.getObjectById(Bebida.class, k);
							misCervezas.add(a);
							misCanCervezas.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<misCervezas.size();j++){
								if(misCervezas.get(j).getIdBebida().equals(codigos[i])){
									int num =Integer.parseInt(misCanCervezas.get(j))+Integer.parseInt(cantidades[i]);
									misCanCervezas.set(j, num+"");
									break;
								}
							}
							if(j==misCervezas.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Bebida a = pm.getObjectById(Bebida.class, k);
								misCervezas.add(a);
								misCanCervezas.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("misCervezas", misCervezas);
				    getServletContext().setAttribute("misCanCervezas",misCanCervezas);
				}
			}
			RequestDispatcher rd = req.getRequestDispatcher("/Menu_Elegido.jsp");
			rd.forward(req, resp);
			
	}
	finally{
		pm.close();
	}
		
	}
	
}