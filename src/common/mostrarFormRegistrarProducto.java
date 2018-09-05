package common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class mostrarFormRegistrarProducto  extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		try{
			RequestDispatcher rd = req.getRequestDispatcher("/FormRegistrarProducto.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
		}			
	}
}
