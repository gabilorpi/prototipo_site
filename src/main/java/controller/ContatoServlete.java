package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ContatoDao;
import modelo.Contato;

@WebServlet(urlPatterns = {"/contato", "/contato-create", "/contato-edit", "/contato-update", "/contato-delete"})
public class ContatoServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatoDao udao = new ContatoDao();
    Contato contato= new Contato();

   
    public ContatoServlete() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getServletPath();

		
		switch (action) {
		case "/contato":
			read(request, response);
			break;
		case "/contato-create":
			create(request, response);
			break;
		case "/contato-edit":
			edit(request, response);
			break;
		case "/contato-update":
			update(request, response);
			break;
		case "/contato-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
	}
	}
		protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Contato> lista = udao.read();
	        request.setAttribute("listaContato", lista);

	        RequestDispatcher rd = request.getRequestDispatcher("./views/contato/contato.jsp"); 
	        rd.forward(request, response);
		}

		protected void  create(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	    	
	    	
	    	
	            
				contato.setNome(request.getParameter("nome"));
	            contato.setEmail(request.getParameter("email"));
	            contato.setTelefone(request.getParameter("telefone"));
	            contato.setMensagem(request.getParameter("mensagem"));
			

			udao.Create(contato);
			response.sendRedirect("contato");
			   
	            
	        
		}

		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			
			contato = udao.readById(id);
			
			request.setAttribute("contato", contato);

			RequestDispatcher rd = request.getRequestDispatcher("./views/contato/update.jsp");
			rd.forward(request, response);
		}

		protected void update(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String idParam = request.getParameter("id");
		   
			 if (idParam != null && !idParam.isEmpty()) {
			
		    try {
		        int id = Integer.parseInt(idParam);
		       

		    
		        contato.setIdContato(id);
		        contato.setNome(request.getParameter("nome"));
		        contato.setEmail(request.getParameter("email"));
		        contato.setTelefone(request.getParameter("telefone"));
		        contato.setMensagem(request.getParameter("mensagen"));
			


			udao.Update(contato);
			response.sendRedirect("cliente");
		    } catch (NumberFormatException e) {
		        
		        response.sendRedirect("error.jsp"); 
		  
		    }
		
			  } else {
			        
				  response.sendRedirect("error.jsp"); 
		  }
	}
			 
			 

		protected void delete(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			udao.delete(id);
			response.sendRedirect("contato");
		

	}
	    
	    



	}
	