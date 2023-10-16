package console;

import java.util.List;
import java.util.Scanner;

import dao.PassagensDao;
import modelo.Passagens;

public class PassagensCrud {

    public static void main(String[] args) {
    	
    	 Scanner scanner = new Scanner(System.in);
         PassagensDao passagensDao = new PassagensDao();

           
        	int opcao =0, id =0;

            do {
                System.out.println("\n##########################Passagens##########################\n");
                System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
                opcao = scanner.nextInt();
                scanner.nextLine();

    
                switch (opcao) {
                    case 1:
                    	 System.out.println("ID de Passagem: ");
                         int idPassagens = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("ID de Voo: ");
                         int idVoo = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("ID de Cliente: ");
                         int idCliente = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("ID de Voo: ");
                         int idVooVoo = scanner.nextInt();
                         scanner.nextLine();
                         Passagens passagem1 = new Passagens(idPassagens, idVoo, idCliente, idVooVoo);
                         passagensDao.Create(passagem1);
                        break;
                    case 2:
                    	List<Passagens> passagens = passagensDao.read();
                        for (Passagens passagem : passagens) {
                            System.out.println(passagem);
                        }
                        break;
                    case 3:
                    	 System.out.println("ID de Passagem: ");
                         idPassagens = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("ID de Voo: ");
                         idVoo = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("ID de Cliente: ");
                         idCliente = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("ID de Voo: ");
                         idVooVoo = scanner.nextInt();
                         scanner.nextLine();
                         Passagens passagem2 = new Passagens(idPassagens, idVoo, idCliente, idVooVoo);
                         passagensDao.Update(passagem2);
                        break;
                    case 4:
                    	 System.out.println("Digite o ID de Passagem: ");
                         idPassagens = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Digite o ID de Voo: ");
                         idVoo = scanner.nextInt();
                         scanner.nextLine();
                         passagensDao.delete(idPassagens, idVoo);
                        break;
                    case 5:
                        System.out.println("Digite o ID de Passagem: ");
                        idPassagens = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o ID de Voo: ");
                        idVoo = scanner.nextInt();
                        scanner.nextLine();
                        Passagens passagem3 = passagensDao.readById(idPassagens, idVoo);
                        System.out.println(passagem3);
                        break;
                    default:
                        break;
                }
            } while (opcao != 0);

            System.out.println("Volte Sempre ");
        }
   
    }
    	

    

