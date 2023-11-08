package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import modelo.Cliente;


@WebServlet(urlPatterns = {"/cliente", "/cliente-create", "/cliente-edit", "/cliente-update", "/cliente-delete"})
public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ClienteDao udao = new ClienteDao();
    Cliente cliente= new Cliente();

    public ClienteServlet() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
		case "/cliente":
			read(request, response);
			break;
		case "/cliente-create":
			create(request, response);
			break;
		case "/cliente-edit":
			edit(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
		case "/cliente-delete":
			delete(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> lista = udao.read();
        request.setAttribute("listaCliente", lista);

        RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/cliente.jsp"); 
        rd.forward(request, response);

    }
    
    protected void  create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	String numeroStr = request.getParameter("numero");
        if (numeroStr != null && !numeroStr.isEmpty()) {
            cliente.setNumero(Integer.parseInt(numeroStr));
    	
    	cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRua(request.getParameter("rua"));
		cliente.setCep(request.getParameter("cep"));
		cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
		cliente.setBairro(request.getParameter("bairro"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setEstado(request.getParameter("estado"));

		udao.Create(cliente);
		response.sendRedirect("cliente");
		
        } else {
            
            response.sendRedirect("cliente-create"); 
            return;
        }
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		cliente = udao.readById(id);
		
		request.setAttribute("cliente", cliente);

		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/update.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
	   
		 if (idParam != null && !idParam.isEmpty()) {
		
	    try {
	        int id = Integer.parseInt(idParam);
	       

	    
		cliente.setIdCliente(id);
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRua(request.getParameter("rua"));
		cliente.setCep(request.getParameter("cep"));
		cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
		cliente.setBairro(request.getParameter("bairro"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setEstado(request.getParameter("estado"));


		udao.Update(cliente);
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
		response.sendRedirect("cliente");
	}

}
    
    


