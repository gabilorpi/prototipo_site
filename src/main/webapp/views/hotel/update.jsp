<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Hotel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../../assets/css/style.css">
    <title>Editar Agencia</title>
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
                        <a class="nav-link" href="./index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../l">Passagens</a>
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
    </nav>
    <main class="container" id="main-container">
        <h1>Editar Agencia</h1>
        <div class="container">
            <form id="register-form" action="./hotel-update">
                <div class="input-group">
                    <div class="full-box">
                        <label for="id">Id</label>
                        <input type="text" class="form-control" name="id" id="id" placeholder="Digite seu nome" value="${hotel.idHotel}" readonly>
                    </div>
                </div>
                
                <div class="input-group">
                    <div class="full-box">
                        <label for="precoPorNoite">Id</label>
                        <input type="text" class="form-control" name="precoPorNoite" id="id" placeholder="Digite seu nome" value="${hotel.precoPorNoite}" readonly>
                    </div>
                </div>
                
                
                
                 <div class="form-group">
              <label for="categorias">Categoria:</label>
              <select class="form-control" id="categoria">
                <option value="1">Categoria 1</option>
                <option value="2">Categoria 2</option>
                <option value="3">Categoria 3</option>
                <option value="4">Categoria 4</option>
                <option value="5">Categoria 5</option>
              </select>
            </div>

                <div class="input-group">
                    <div class="full-box">
                        <label for="name">NomeHotel</label>
                        <input type="text" class="form-control" name="nomeHotel" id="nomeHotel" placeholder="Digite o nome do hotel" value="${hotel.nomeHotel}">
                    </div>
                </div>

                <div class="full-box">
                    <label for="cep">CEP</label>
                    <input type="text" class="form-control" name="cep" id="cep" placeholder="Digite o CEP" value="${hotel.cep}">
                </div>

                <div class="full-box">
                    <label for="rua">Rua</label>
                    <input type="text" class="form-control" name="rua" id="rua" placeholder="Digite a rua" value="${hotel.rua}">
                </div>

                <div class="half-box">
                    <label for="bairro">Bairro</label>
                    <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Digite o bairro" value="${hotel.bairro}">
                </div>

                <div class="half-box">
                    <label for="telefone">Telefone</label>
                    <input type="text" class="form-control" name="telefone" id="telefone" placeholder="Digite o telefone" value="${hotel.telefone}">
                </div>
					
				<div class="input-group">
                    <input type="submit"  value="cadastrar">

                    
                
				
    		<button type="submit" id="delete-btn" class="btn btn-danger" formaction="./hotel">
   					 <i class="fas fa-trash"></i> Deletar
		</button>

			<button type="submit" id="edit-btn" class="btn btn-warning" formaction="./hotel">
  					  <i class="fas fa-edit"></i> Editar
		</button>

                </div>	
              
            </form>
        </div>
    </main>

    <!-- Menu Lateral (Offcanvas) -->
    <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">Menu</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="../agencia/index.html">Home</a>
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
    <footer class="mt-3">© 2023 - Todos os direitos reservados.</footer>
</body>
</html>
