package console;


import java.util.Scanner;

import dao.ClienteDao;

import modelo.Cliente;



public class ConsoleCrud {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in); 

		ClienteDao clienteDao = new ClienteDao();
		
		int opcao =0, id =0;
		do {
			
			System.out.println("\n##########################Clientes##########################\n");
			System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
			opcao=s.nextInt();
			s.nextLine();
			

            switch (opcao) {
                case 1:
                	System.out.println("Nome: ");
                    String nome = s.nextLine();
                    System.out.println("Email: ");
                    String email = s.nextLine();
                    System.out.println("Senha: ");
                    String senha = s.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = s.nextLine();
                    System.out.println("CPF: ");
                    String cpf = s.nextLine();
                    System.out.println("Rua: ");
                    String rua = s.nextLine();
                    System.out.println("CEP: ");
                    String cep = s.nextLine();
                    System.out.println("Número: ");
                    int numero = s.nextInt();
                    s.nextLine();
                    System.out.println("Bairro: ");
                    String bairro = s.nextLine();
                    System.out.println("Cidade: ");
                    String cidade = s.nextLine();
                    System.out.println("Estado: ");
                    String estado = s.nextLine();
                   
				
				Cliente cliente1 = new Cliente(nome,email,senha,telefone,cpf,rua,cep,numero,bairro,cidade,estado);
                 clienteDao.Create(cliente1);
                    break;
                case 2:
                   for (Cliente c : clienteDao.read()) {
                	   System.out.println(c.toString());
                   }
                    break;
                case 3:
                	
                	System.out.println("Nome: ");
                    nome = s.nextLine();
                    System.out.println("Email: ");
                    email = s.nextLine();
                    System.out.println("Senha: ");
                    senha = s.nextLine();
                    System.out.println("Telefone: ");
                    telefone = s.nextLine();
                    System.out.println("CPF: ");
                    cpf = s.nextLine();
                    System.out.println("Rua: ");
                    rua = s.nextLine();
                    System.out.println("CEP: ");
                    cep = s.nextLine();
                    System.out.println("Número: ");
                    numero = s.nextInt();
                    s.nextLine();
                    System.out.println("Bairro: ");
                    bairro = s.nextLine();
                    System.out.println("Cidade: ");
                    cidade = s.nextLine();
                    System.out.println("Estado: ");
                    estado = s.nextLine();
                    System.out.println("id: ");
                    id = s.nextInt();
                    s.nextLine();
                    
                	Cliente cliente2 = new Cliente(id,nome,email,senha,telefone,cpf,rua,cep,numero,bairro,cidade,estado);
                	
                	clienteDao.Update(cliente2);
                    break;
                case 4:
                	 System.out.println("Digite o id");
                	 id = s.nextInt();
                	 s.nextLine();
                	 
                  clienteDao.delete(id);
                    break;
                case 5:
                	System.out.println("Digite o id");
               	 id = s.nextInt();
               	 s.nextLine();
               	 
                   Cliente cliente3 = clienteDao.readById(id);
                   System.out.println(cliente3.toString());
                    break;
               default:
            	   break;
            }
		}while(opcao !=0);
		
		System.out.println("Volte Sempre ");

	}

	

}
