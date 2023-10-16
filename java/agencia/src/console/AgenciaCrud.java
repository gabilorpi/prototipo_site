package console;
import java.util.Scanner;

import dao.AgenciaDao;
import modelo.Agencia;

public class AgenciaCrud {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in); 
		AgenciaDao agenciaDao = new AgenciaDao();
		
		int opcao =0, id =0;
		
		do {
			
			System.out.println("\n##########################Agencias##########################\n");
			System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
			opcao=s.nextInt();
			s.nextLine();
			
			String nome_agencia = "";
			
			switch (opcao) {
                case 1:
                	System.out.println("Nome: ");
                    String nomeagencia = s.nextLine();
                    System.out.println("CEP: ");
                    String cep = s.nextLine();
                    System.out.println("Rua: ");
                    String rua = s.nextLine();
                    System.out.println("Bairro: ");
                    String bairro = s.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = s.nextLine();
                   
                   
				
                    Agencia agencia1 = new Agencia(nome_agencia , cep, rua, bairro, telefone);
                 
				agenciaDao.Create(agencia1);
                    break;
                case 2:
                   for (Agencia c : agenciaDao.read()) {
                	   System.out.println(c.toString());
                   }
                    break;
                case 3:
                	
                	System.out.println("Nome: ");
                    nomeagencia = s.nextLine();
                    System.out.println("CEP: ");
                    cep = s.nextLine();
                    System.out.println("Rua: ");
                    rua = s.nextLine();
                    System.out.println("Bairro: ");
                    bairro = s.nextLine();
                    System.out.println("Telefone: ");
                    telefone = s.nextLine();
                    System.out.println("ID da Agência: ");
                    int id_agencia = s.nextInt(); 
                    s.nextLine();

                   
				
				Agencia agencia2 = new Agencia(id_agencia,nome_agencia,cep,rua, bairro,telefone);
                	
                	agenciaDao.Update(agencia2);
                    break;
                case 4:
                	 System.out.println("Digite o id");
                	 id = s.nextInt();
                	 s.nextLine();
                	 
                  agenciaDao.delete(id);
                    break;
                case 5:
                	System.out.println("Digite o id");
               	 id = s.nextInt();
               	 s.nextLine();
               	 
                   Agencia agencia3 = agenciaDao.readById(id);
                   System.out.println(agencia3.toString());
                    break;
               default:
            	   break;
            }
		}while(opcao !=0);
		
		System.out.println("Volte Sempre ");

	}

}
