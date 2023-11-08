<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="modelo.Hotel" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>




<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	
    <title>Buscadores de Aventuras</title>
</head>
<body>
	
	<style>
        
        * {
  margin: 0;
  padding: 0;
}
       
nav{
  margin-bottom: 2px;
   background-color:#791881
}

.navbar-brand {
  width: 70px; 
  height:auto;
 

}

header,footer {
  width: 100%;
  padding: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(121, 24, 129, 0.877);
  color: #ffffff;
  box-sizing: border-box;
 position: absolute;
 bottom: 0;
}

      h1 {
            margin-bottom: 20px;
            color: #5f46a3e1; /* Texto roxo */
        }

        .table {
           
            position: ;
            background-color: #fff; /* Fundo da tabela em branco */
             font-family: 'Courier New', Courier, monospace;
        }

        .table th {
            background-color: #5f46a3e1; /* Fundo roxo para cabeçalho da tabela */
            color: #fff; /* Texto em branco */
         font-family: 'Courier New', Courier, monospace;
        }

        /* Adicione estilos do Bootstrap conforme necessário */
    </style>

     <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <button class="btn btn" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                Menu
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="./././index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./././passagens">Passagens</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./././hotel">Hotéis</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./././contato">Contato</a>
                    </li>
                </ul>
            </div>
        </div>
        </nav>
    <main class="container" id="main-container">
        <h1>Lista de Hotéis</h1>
        <div class="container">
           
           <table class="table table-hover">
           		 <thead class = "table-dark">
           
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">precoPorNoite</th>
                    <th scope="col">categorias</th>
                    <th scope="col">nomes_hoteis</th>
                    <th scope="col">cep</th>
                    <th scope="col">rua</th>
                    <th scope="col">bairro</th>
                    <th scope="col">telefone</th>
                     <th scope="col">ação</th>
                    
                </tr>
                </thead>
                <tbody>
                    <jstl:forEach items="${listaHotel}" var="hotel">
    <tr>
        <td>${hotel.idHotel}</td>
        <td>${hotel.precoPorNoite}</td>
        <td>${hotel.categorias}</td>
        <td>${hotel.nomeHotel}</td>
        <td>${hotel.cep}</td>
        <td>${hotel.rua}</td>
        <td>${hotel.bairro}</td>
        <td>${hotel.telefone}</td>
        <td>
   			
   			<div class="d-flex">
            <a href="hotel-edit?id=${hotel.idHotel}" class="btn btn-warning">
                <i class="fas fa-edit"></i> Editar
            </a>
            <a href="hotel-delete?id=${hotel.idHotel}" class="btn btn-danger" onclick="return confirm('Deseja excluir o hotel ${hotel.nomeHotel}?')">
                <i class="fas fa-trash"></i> Deletar
            </a>
            </div>
            
        </td>
    </tr>
</jstl:forEach>
               </tbody>
            </table>
        </div>
    </main>
    <!-- ... (código do menu lateral) ... -->
    <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">Menu</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../projeto/passagens.html">Passagens</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../projeto/hoteis.html">Hotéis</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../projeto/contato.html">Contato</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-bs-toggle="collapse" href="#agenciaSubmenu" role="button"
                        aria-expanded="false">Agência</a>
                    <div class="collapse" id="agenciaSubmenu">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Buscadores de aventuras Ba</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Buscadores de aventuras Sp</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Buscadores de aventuras Df </a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <footer class="mt-3">© 2023 - Todos os direitos reservados.</footer>
    
</body>
</html>
    