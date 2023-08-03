Algoritmo "AgenciaDeViangens"


Var
   cliente: vetor[1..2, 1..3] de caractere
   destino: vetor[1..2, 1..3] de caractere
   opcao, opcao_cliente, opcao_destino, total_clientes, total_destinos, i, j: inteiro

Inicio
   total_clientes := 0
   total_destinos := 0
   repita
      escreval("========== Menu Agência de Viagens ==========")
      escreval("1 - Cadastrar Cliente")
      escreval("2 - Cadastrar Destino")
      escreval("3 - Consultar Clientes")
      escreval("4 - Consultar Destinos")
      escreval("5 - Sair")
      escreval("============================================")
      escreval("Digite a opção desejada: ")
      leia(opcao)

      escolha opcao
         caso 1
            se total_clientes < 2 entao
               escreval("===== Cadastro de Cliente =====")
               escreval("Digite o nome do cliente: ")
               leia(cliente[total_clientes + 1, 1])
               escreval("Digite a idade do cliente: ")
               leia(cliente[total_clientes + 1, 2])
               escreval("Digite o e-mail do cliente: ")
               leia(cliente[total_clientes + 1, 3])
               total_clientes := total_clientes + 1
               escreval("Cliente cadastrado com sucesso!")
            senao
               escreva("Limite máximo de clientes cadastrados atingido!")
            fimse

         caso 2
            se total_destinos < 2 entao
               escreval("===== Cadastro de Destino =====")
               escreval("Digite o nome do destino: ")
               leia(destino[total_destinos + 1, 1])
               escreval("Digite a descrição do destino: ")
               leia(destino[total_destinos + 1, 2])
               total_destinos := total_destinos + 1
               escreval("Destino cadastrado com sucesso!")
            senao
               escreval("Limite máximo de destinos cadastrados atingido!")
            fimse

         caso 3
            escreval("===== Consulta de Clientes =====")
            para i de 1 ate total_clientes faca
               escreval("Nome: ", cliente[i, 1])
               escreval("Idade: ", cliente[i, 2])
               escreval("E-mail: ", cliente[i, 3])
               escreval("-----------------------------")
            fimpara

         caso 4
            escreval("===== Consulta de Destinos =====")
            para j de 1 ate total_destinos faca
               escreval("Destino: ", destino[j, 1])
               escreval("Descrição: ", destino[j, 2])
               escreval("-----------------------------")
            fimpara

         caso 5
            escreva("Finalizando cadastros...")
            // Saímos do menu ao terminar o loop principal

         caso contrario:
            escreva("Opção inválida! Digite um número de 1 a 5.")
      fimescolha
   ate opcao = 5
fimalgoritmo
