package console;


import java.util.Locale;
import java.util.Scanner;

import dao.VooDao;
import modelo.Voo;

public class VooCrud {

public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in); 
		Locale.setDefault(Locale.US);

		VooDao vooDao = new VooDao();
		
		int opcao =0, id =0;
		do {
			
			System.out.println("\n##########################Voos##########################\n");
			System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
			opcao=s.nextInt();
			s.nextLine();
			

            switch (opcao) {
                case 1:
                	 System.out.println("Hora de Decolagem: ");
                     String horaDecolagem = s.nextLine();
                     System.out.println("Data de Decolagem: ");
                     String dataDecolagem = s.nextLine();
                     System.out.println("Hora de Aterrissagem: ");
                     String horaAterrissagem = s.nextLine();
                     System.out.println("Data de Aterrissagem: ");
                     String dataAterrissagem = s.nextLine();
                     System.out.println("Origem: ");
                     String origem = s.nextLine();
                     System.out.println("Destino: ");
                     String destino = s.nextLine();
                     System.out.println("Preco: ");
                     String precoStr = s.next();
                     double preco = Double.parseDouble(precoStr);
				
                     Voo voo1 = new Voo(0, horaDecolagem, dataDecolagem, horaAterrissagem, dataAterrissagem, origem, destino, preco);
                     vooDao.Create(voo1);
                    break;
                case 2:
                   for (Voo c : vooDao.read()) {
                	   System.out.println(c.toString());
                   }
                    break;
                case 3:
                	
                	System.out.println("ID do voo que deseja atualizar: ");
                    id = s.nextInt();
                    s.nextLine();
                    
                    System.out.println(" Hora de Decolagem: ");
                    String HoraDecolagem = s.nextLine();
                    
                    System.out.println(" Data de Decolagem (AAAA-MM-DD): ");
                    String DataDecolagem = s.nextLine();
                    
                    System.out.println(" Hora de Aterrissagem: ");
                    String HoraAterrissagem = s.nextLine();
                    
                    System.out.println(" Data de Aterrissagem (AAAA-MM-DD): ");
                    String DataAterrissagem = s.nextLine();
                    
                    System.out.println(" Origem: ");
                    String Origem = s.nextLine();
                    
                    System.out.println(" Destino: ");
                    String Destino = s.nextLine();
                    
                    System.out.println("Novo Preço: ");
                    String novoPrecoStr = s.next();
                    double novoPreco = Double.parseDouble(novoPrecoStr);
                    
                    Voo voo2 = new Voo(id, HoraDecolagem, DataDecolagem, HoraAterrissagem, DataAterrissagem, Origem, Destino, novoPreco);
                    
                    vooDao.Update(voo2);
                    break;

                case 4:
                	 System.out.println("Digite o id");
                	 id = s.nextInt();
                	 s.nextLine();
                	 
                  vooDao.delete(id);
                    break;
                case 5:
                	System.out.println("Digite o id");
               	 id = s.nextInt();
               	 s.nextLine();
               	 
                   Voo voo3 = vooDao.readById(id);
                   System.out.println(voo3.toString());
                    break;
               default:
            	   break;
            }
		}while(opcao !=0);
		
		System.out.println("Volte Sempre ");

	}


}
