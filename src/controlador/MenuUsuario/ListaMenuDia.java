package controlador.MenuUsuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class ListaMenuDia extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		ejecutar(req,resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		ejecutar(req,resp);
	}
	public void ejecutar(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
			RequestDispatcher rd = req.getRequestDispatcher("/UserJsp/UserElegirMenu.jsp");
			rd.forward(req, resp);
	}
}
