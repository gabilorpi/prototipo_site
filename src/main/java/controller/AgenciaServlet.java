package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AgenciaDao;
import modelo.Agencia;

@WebServlet(urlPatterns = { "/agencia", "/agencia-create", "/agencia-edit", "/agencia-update", "/agencia-delete" })
public class AgenciaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    AgenciaDao udao = new AgenciaDao();
    Agencia agencia = new Agencia();

    public AgenciaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/agencia":
                read(request, response);
                break;

            case "/agencia-create":
                create(request, response);
                break;
            case "/agencia-edit":
                edit(request, response);
                break;
            case "/agencia-update":
                update(request, response);
                break;
            case "/agencia-delete":
                delete(request, response);
                break;
            default:
                response.sendRedirect("index.html");
                break;
        }
    }

    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Agencia> lista = udao.read();
        request.setAttribute("listaAgencia", lista);

        RequestDispatcher rd = request.getRequestDispatcher("./views/agencia/agencia.jsp");
        rd.forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        
        agencia.setNome_Agencia(request.getParameter("nomeAgencia"));
        agencia.setCep(request.getParameter("cep"));
        agencia.setRua(request.getParameter("rua"));
        agencia.setBairro(request.getParameter("bairro"));
        agencia.setTelefone(request.getParameter("telefone"));

        udao.Create(agencia);
        response.sendRedirect("agencia");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Agencia agencia = udao.readById(id);
        
        request.setAttribute("agencia", agencia);

        RequestDispatcher rd = request.getRequestDispatcher("./views/agencia/update.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                Agencia agencia = udao.readById(id);
                
                agencia.setNome_Agencia(request.getParameter("nomeAgencia"));
                agencia.setCep(request.getParameter("cep"));
                agencia.setRua(request.getParameter("rua"));
                agencia.setBairro(request.getParameter("bairro"));
                agencia.setTelefone(request.getParameter("telefone"));
                
                udao.Update(agencia);
                response.sendRedirect("agencia");
            } catch (NumberFormatException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        udao.delete(id);
        response.sendRedirect("agencia");
    }
}
