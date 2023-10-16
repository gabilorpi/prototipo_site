package console;

import java.util.Scanner;

import dao.ContatoDao;
import modelo.Contato;

public class ContatoCrud {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		ContatoDao contatoDao = new ContatoDao();
		
		int opcao =0, id =0;
		
		do {
			
			System.out.println("\n##########################Contatos##########################\n");
			System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
			opcao=s.nextInt();
			s.nextLine();
			
		
			
			switch (opcao) {
                case 1:
                	System.out.println("Nome: ");
                    String nome = s.nextLine();
                    System.out.println("email: ");
                    String email = s.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = s.nextLine();
                    System.out.println("mensagen: ");
                    String mensagen = s.nextLine();
                   
                   
				
                    Contato contato1 = new Contato(nome , email, telefone, mensagen);
                 
				contatoDao.Create(contato1);
                    break;
                case 2:
                   for (Contato c : contatoDao.read()) {
                	   System.out.println(c.toString());
                   }
                    break;
                case 3:
                	
                	System.out.println("Nome: ");
                    nome = s.nextLine();
                    System.out.println("email: ");
                    email = s.nextLine();
                    System.out.println("Telefone: ");
                    telefone = s.nextLine();
                    System.out.println("mensagen: ");
                    mensagen = s.nextLine();
                    
                    System.out.println("Id contato: ");
                    int id_contato = s.nextInt(); 
                    s.nextLine();

                   
				
				Contato contato2 = new Contato(id_contato,nome,email,telefone,mensagen);
                	
                	contatoDao.Update(contato2);
                    break;
                case 4:
                	 System.out.println("Digite o id");
                	 id = s.nextInt();
                	 s.nextLine();
                	 
                  contatoDao.delete(id);
                    break;
                case 5:
                	System.out.println("Digite o id_contato");
               	 id = s.nextInt();
               	 s.nextLine();
               	 
                   Contato contato3 = contatoDao.readById(id);
                   System.out.println(contato3.toString());
                    break;
               default:
            	   break;
            }
		}while(opcao !=0);
		
		System.out.println("Volte Sempre ");


	}

}
