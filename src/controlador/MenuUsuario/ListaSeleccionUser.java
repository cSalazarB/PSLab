package controlador.MenuUsuario;

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
public class ListaSeleccionUser extends HttpServlet{
@SuppressWarnings("unchecked")
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String[] codigos = req.getParameterValues("codigos[]");
		String[] cantidades = req.getParameterValues("cantidades[]");
		String tipo = req.getParameter("clase");
		
		
		//creamos una instancia de PersistenceManager
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			if(tipo.equals("Entrada")||tipo.equals("Fondo")||tipo.equals("Postre")){
				
				if(tipo.equals("Entrada")){
					ArrayList<Plato> lasEntradas=(ArrayList<Plato>)getServletContext().getAttribute("lasEntradas");
					ArrayList<String> lasCanEntradas=(ArrayList<String>)getServletContext().getAttribute("lasCanEntradas");
					if(lasEntradas==null){
						lasEntradas = new ArrayList<Plato>();
						lasCanEntradas = new ArrayList<String>();
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Plato a = pm.getObjectById(Plato.class, k);
							lasEntradas.add(a);
							lasCanEntradas.add(cantidades[i]);
						}
					    
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<lasEntradas.size();j++){
								if(lasEntradas.get(j).getIdPlato().equals(codigos[i])){
									int num =Integer.parseInt(lasCanEntradas.get(j))+Integer.parseInt(cantidades[i]);
									lasCanEntradas.set(j, num+"");
									break;
								}
							}
							if(j==lasEntradas.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Plato a = pm.getObjectById(Plato.class, k);
								lasEntradas.add(a);
								lasCanEntradas.add(cantidades[i]);
							}
						}	
					}
					getServletContext().setAttribute("lasEntradas", lasEntradas);
				    getServletContext().setAttribute("lasCanEntradas", lasCanEntradas);
						
				}
				else if(tipo.equals("Fondo")){
					ArrayList<Plato> lasFondos=(ArrayList<Plato>)getServletContext().getAttribute("lasFondos");
					ArrayList<String> lasCanFondos=(ArrayList<String>)getServletContext().getAttribute("lasCanFondos");
					if(lasFondos==null){
						lasFondos = new ArrayList<Plato>();
						lasCanFondos = new ArrayList<String>();
						
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Plato a = pm.getObjectById(Plato.class, k);
							lasFondos.add(a);
							lasCanFondos.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<lasFondos.size();j++){
								if(lasFondos.get(j).getIdPlato().equals(codigos[i])){
									int num =Integer.parseInt(lasCanFondos.get(j))+Integer.parseInt(cantidades[i]);
									lasCanFondos.set(j, num+"");
									break;
								}
							}
							if(j==lasFondos.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Plato a = pm.getObjectById(Plato.class, k);
								lasFondos.add(a);
								lasCanFondos.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("lasFondos", lasFondos);
				    getServletContext().setAttribute("lasCanFondos", lasCanFondos);
				}
				else{
					ArrayList<Plato> lasPostres=(ArrayList<Plato>)getServletContext().getAttribute("lasPostres");
					ArrayList<String> lasCanPostres=(ArrayList<String>)getServletContext().getAttribute("lasCanPostres");
					if(lasPostres==null){
						lasPostres = new ArrayList<Plato>();
						lasCanPostres = new ArrayList<String>();
					    
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Plato a = pm.getObjectById(Plato.class, k);
							lasPostres.add(a);
							lasCanPostres.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<lasPostres.size();j++){
								if(lasPostres.get(j).getIdPlato().equals(codigos[i])){
									int num =Integer.parseInt(lasCanPostres.get(j))+Integer.parseInt(cantidades[i]);
									lasCanPostres.set(j, num+"");
									break;
								}
							}
							if(j==lasPostres.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Plato a = pm.getObjectById(Plato.class, k);
								lasPostres.add(a);
								lasCanPostres.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("lasPostres", lasPostres);
				    getServletContext().setAttribute("lasCanPostres",lasCanPostres);
				}
				
			}
			else if(tipo.equals("Gaseosa")||tipo.equals("Refresco")||tipo.equals("Cerveza")){
				if(tipo.equals("Gaseosa")){
					ArrayList<Bebida> lasGaseosas=(ArrayList<Bebida>)getServletContext().getAttribute("lasGaseosas");
					ArrayList<String> lasCanGaseosas=(ArrayList<String>)getServletContext().getAttribute("lasCanGaseosas");
					if(lasGaseosas==null){
						lasGaseosas = new ArrayList<Bebida>();
						lasCanGaseosas = new ArrayList<String>();
					    
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Bebida a = pm.getObjectById(Bebida.class, k);
							lasGaseosas.add(a);
							lasCanGaseosas.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<lasGaseosas.size();j++){
								if(lasGaseosas.get(j).getIdBebida().equals(codigos[i])){
									int num =Integer.parseInt(lasCanGaseosas.get(j))+Integer.parseInt(cantidades[i]);
									lasCanGaseosas.set(j, num+"");
									break;
								}
							}
							if(j==lasGaseosas.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Bebida a = pm.getObjectById(Bebida.class, k);
								lasGaseosas.add(a);
								lasCanGaseosas.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("lasGaseosas", lasGaseosas);
				    getServletContext().setAttribute("lasCanGaseosas",lasCanGaseosas);				
						
				}
				else if(tipo.equals("Refresco")){
					
					ArrayList<Bebida> lasRefrescos=(ArrayList<Bebida>)getServletContext().getAttribute("lasRefrescos");
					ArrayList<String> lasCanRefrescos=(ArrayList<String>)getServletContext().getAttribute("lasCanRefrescos");
					if(lasRefrescos==null){
						lasRefrescos = new ArrayList<Bebida>();
						lasCanRefrescos = new ArrayList<String>();
					   
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Bebida a = pm.getObjectById(Bebida.class, k);
							lasRefrescos.add(a);
							lasCanRefrescos.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<lasRefrescos.size();j++){
								if(lasRefrescos.get(j).getIdBebida().equals(codigos[i])){
									int num =Integer.parseInt(lasCanRefrescos.get(j))+Integer.parseInt(cantidades[i]);
									lasCanRefrescos.set(j, num+"");
									break;
								}
							}
							if(j==lasRefrescos.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Bebida a = pm.getObjectById(Bebida.class, k);
								lasRefrescos.add(a);
								lasCanRefrescos.add(cantidades[i]);
							}
						}
					}
					 getServletContext().setAttribute("lasRefrescos", lasRefrescos);
					 getServletContext().setAttribute("lasCanRefrescos",lasCanRefrescos);				
				
				}
				else{
					ArrayList<Bebida> lasCervezas=(ArrayList<Bebida>)getServletContext().getAttribute("lasCervezas");
					ArrayList<String> lasCanCervezas=(ArrayList<String>)getServletContext().getAttribute("lasCanCervezas");
					if(lasCervezas==null){
						lasCervezas = new ArrayList<Bebida>();
						lasCanCervezas = new ArrayList<String>();
					    
					   
					    for(int i=0;i<codigos.length;i++){
							Key k = KeyFactory.stringToKey(codigos[i]);
							Bebida a = pm.getObjectById(Bebida.class, k);
							lasCervezas.add(a);
							lasCanCervezas.add(cantidades[i]);
						}
					}
					else{
						for(int i=0;i<codigos.length;i++){
							int j;
							for(j=0;j<lasCervezas.size();j++){
								if(lasCervezas.get(j).getIdBebida().equals(codigos[i])){
									int num =Integer.parseInt(lasCanCervezas.get(j))+Integer.parseInt(cantidades[i]);
									lasCanCervezas.set(j, num+"");
									break;
								}
							}
							if(j==lasCervezas.size()){
								Key k = KeyFactory.stringToKey(codigos[i]);
								Bebida a = pm.getObjectById(Bebida.class, k);
								lasCervezas.add(a);
								lasCanCervezas.add(cantidades[i]);
							}
						}
					}
					getServletContext().setAttribute("lasCervezas", lasCervezas);
				    getServletContext().setAttribute("lasCanCervezas",lasCanCervezas);
				}
			}
			RequestDispatcher rd = req.getRequestDispatcher("UserJsp/MenuElegidoUser.jsp");
			rd.forward(req, resp);
			
	}
	finally{
		pm.close();
	}
	}
	
public void doPost(HttpServletRequest req, HttpServletResponse resp){
	
	String [] val = req.getParameterValues("codigoa");
	String [] can = req.getParameterValues("cantidades");
	
	System.out.println(val);
	System.out.println(can);
}
}
