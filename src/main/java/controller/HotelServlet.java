package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HotelDao;
import modelo.Hotel;


@WebServlet(urlPatterns = {"/hotel", "/hotel-create", "/hotel-edit", "/hotel-update", "/hotel-delete"})
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HotelDao udao = new HotelDao();
       Hotel hotel = new Hotel();
    public HotelServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch (action) {
		case "/hotel":
			read(request,response);
			
			break;
			
		 case "/hotel-create":
             create(request, response);
             break;
         case "/hotel-edit":
             edit(request, response);
             break;
         case "/hotel-update":
             update(request, response);
             break;
			
		case "/hotel-delete":
			delete(request,response);
			break;
			
			default:
				response.sendRedirect("index.html");
				break;
		
		}
		
	}
		protected void read(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
			List<Hotel> lista = udao.read();
			
			request.setAttribute("listaHotel", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("./views/hotel/hotel.jsp");
			rd.forward(request, response);
		}

		protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 
		    hotel.setPrecoPorNoite(Double.parseDouble(request.getParameter("precoPorNoite"))); 
		    hotel.setNomeHotel(request.getParameter("nomeHotel"));
		    hotel.setCep(request.getParameter("cep"));
		    hotel.setRua(request.getParameter("rua"));
		    hotel.setBairro(request.getParameter("bairro"));
		    hotel.setTelefone(request.getParameter("telefone"));

		
		    udao.Create(hotel);

		    response.sendRedirect("hotel");
		}

		
		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		    int id = Integer.parseInt(request.getParameter("id"));

		   
		    Hotel hotel = udao.readById(id);

		    if (hotel != null) {
		        
		        request.setAttribute("hotel", hotel);

		        
		        RequestDispatcher rd = request.getRequestDispatcher("./views/hotel/update.jsp"); 
		        rd.forward(request, response);
		    } else {
		        
		        response.sendRedirect("hotel"); 
		    }
		}

		protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    int id = Integer.parseInt(request.getParameter("id"));

		    
		    Hotel hotel = udao.readById(id);

		    if (hotel != null) {
		       
		        hotel.setPrecoPorNoite(Double.parseDouble(request.getParameter("precoPorNoite")));
		        hotel.setNomeHotel(request.getParameter("nomeHotel"));
		        hotel.setCep(request.getParameter("cep"));
		        hotel.setRua(request.getParameter("rua"));
		        hotel.setBairro(request.getParameter("bairro"));
		        hotel.setTelefone(request.getParameter("telefone"));

		       
		        udao.Update(hotel);

		       
		        response.sendRedirect("hotel");
		    } else {
		        
		        response.sendRedirect("hotel"); 
		    }
		}

		
		
		
		protected void delete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
			int id = Integer.parseInt(request.getParameter("id"));
			udao.delete(id);
			response.sendRedirect("hotel");
		}
}
