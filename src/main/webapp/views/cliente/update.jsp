<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="modelo.Cliente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
     <link rel="stylesheet" href="../../assets/css/style.css">
    <title>Editar Cliente</title>
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
        <form class="d-flex">
            <button id="signup-btn" type="button" class="btn btn-primary ml-2">
                <a href="">Cadastrar</a>
            </button>
            <button class="btn ml-2" type="submit">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="#4654A3" class="bi bi-person-circle" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"></path>
                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"></path>
                </svg>
            </button>
        </form>
    </nav>
    <main class="container" id="main-container">
        <h1>Editar Cliente</h1>
        <div class="container">
           <form id="register-form" action= "./cliente-update">
           
            <div class="input-group">
                    <div class="full-box">
                        <label for="id">Id</label>
                        <input type="text" class= "form-control" name="id" id="id" placeholder="Digite seu nome" value="${cliente.idCliente }" readonly>
                    </div>
                </div>
               
               <div class="input-group">
                    <div class="full-box">
                        <label for="name">Nome</label>
                        <input type="text" class= "form-control" name= "nome" id="nome" placeholder="Digite seu nome" value="${cliente.nome }">
                    </div>
                </div>
                
                <div class="input-group">
                    <div class="half-box spacing">
                        <label for="email">E-mail</label>
                        <input type="email" class= "form-control" name="email" id="email" placeholder="Digite seu e-mail" value="${cliente.email }">
                    </div>
                   
                </div>
                
                 <div class="input-group">
                    <div class="half-box spacing">
                        <label for="senha">Senha</label>
                        <input type="password" class= "form-control" name="senha" id="senha" placeholder="Digite sua senha" value="${cliente.senha }">
                    </div>
    			</div>
                <div class="input-group">
                    <div class="half-box">
                        <label for="telefone">Telefone</label>
                        <input type="text" class= "form-control" name="telefone" id="telefone" placeholder="Digite seu telefone" value="${cliente.telefone }">
                    </div>
                    <div class="half-box">
                        <label for="cpf">CPF/CNPJ</label>
                        <input type="text" class= "form-control" name="cpf" id="cpf" placeholder="Digite seu CPF ou CNPJ" value="${cliente.cpf }">
                    </div>
                </div>
                <div class="input-group">
                    <label for="">Endereço:</label>
                    
                    <div class="full-box">
                        <label for="rua">Rua</label>
                        <input type="text" class= "form-control" name="rua" id="rua" placeholder="Digite a rua" value="${cliente.rua }">
                    </div>
                    
                    <div class="full-box">
                        <label for="cep">CEP</label>
                        <input type="text" class= "forme-control" name="cep" id="cep" placeholder="Digite seu CEP" value="${cliente.cep }">
                    </div>
                    
                    <div class="half-box">
                        <label for="numero">Número</label>
                        <input type="text" class= "form-control" name="numero" id="numero" placeholder="Digite o número da residência" value="${cliente.numero }">
                    </div>
                    <div class="half-box">
                        <label for="bairro">Bairro</label>
                        <input type="text" class="form-control" name="bairro" id="bairro" placeholder="Digite o bairro" value="${cliente.bairro }">
                    </div>
                    <div class="half-box">
                        <label for="cidade">Cidade</label>
                        <input type="text" class= "form-control" name="cidade" id="cidade" placeholder="Digite a cidade" value="${cliente.cidade }">
                    </div>
                    <div class="half-box">
                        <label for="estado">Estado</label>
                        <input type="text" class= "form-control" name="estado" id="estado" placeholder="Digite o Estado" value="${cliente.estado }">
                    </div>
                </div>
                    
               
                <div class="input-group">
                    <input type="submit"  value="enviar">

                    
                
				
    		<button type="submit" id="delete-btn" class="btn btn-danger" formaction="./cliente">
   					 <i class="fas fa-trash"></i> Deletar
		</button>

			<button type="submit" id="edit-btn" class="btn btn-warning" formaction="./cliente">
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
                    <a class="nav-link" href="../cliente/index.html">Home</a>
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
    