<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="modelo.Contato" %>
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
<meta charset="UTF-8">
<title>Contatos Clientes</title>

<style>
        
        nav {
            margin-bottom: 2px;
            background-color: #791881;
        }

        .navbar-brand {
            width: 70px;
            height: auto;
        }

        header, footer {
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
            color: #5f46a3e1; 
        }

        .table {
            position: relative;
            background-color: #fff; 
            font-family: 'Courier New', Courier, monospace;
        }

        .table th {
            background-color: #5f46a3e1; 
            color: #fff; 
            font-family: 'Courier New', Courier, monospace;
        }
    </style>

</head>
<body>

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
                        <a class="nav-link" href="./././">Passagens</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./././hotel.html">Hotéis</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./././contato.html">Contato</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main class="container" id="main-container">
        <h1>Lista de Contatos</h1>
        <div class="container">
            <table class="table table-hover">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">nome</th>
                        <th scope="col">email</th>
                        <th scope="col">telefone</th>
                        <th scope="col">mensagen</th>
                        <th scope="col">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <jstl:forEach items="${listaContato}" var="contato">
                        <tr>
                            <td>${contato.idContato}</td>
                            <td>${contato.nome}</td>
                            <td>${contato.email}</td>
                            <td>${contato.telefone}</td>
                            <td>${contato.mensagen}</td>
                            <td>
                                <div class="d-flex">
                                    <a href="contato-edit?id=${contato.idContato}" class="btn btn-warning">
                                        <i class="fas fa-edit"></i> Editar
                                    </a>
                                    <a href="contato-delete?id=${contato.idContato}" class="btn btn-danger" onclick="return confirm('Deseja excluir o contato ${contato.nome}?')">
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
                
                        </ul>
                    </div>
        </div>
    

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <footer class="mt-3">© 2023 - Todos os direitos reservados.</footer>
    
</body>
</html>
