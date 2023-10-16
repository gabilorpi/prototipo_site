package console;


import java.util.Scanner;

import dao.Reserva_QuartoDao;
import modelo.Reserva_Quarto;

public class Reserva_QuartoCrud {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		

		Reserva_QuartoDao reserva_QuartoDao = new Reserva_QuartoDao();
		
		int opcao =0, id =0;
		
		do {
			
			System.out.println("\n##########################Reserva_Quartos##########################\n");
			System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
			opcao=s.nextInt();
			s.nextLine();
			

            switch (opcao) {
                case 1:
                	
                	 System.out.println("ID do reserva: ");
                     int id_reserva = s.nextInt();
                     s.nextLine();      
                     System.out.println("quarto: ");
                     int quarto = s.nextInt();
                     s.nextLine();
                	 System.out.println("data_check_out: ");
                     String data_check_out = s.nextLine();
                     System.out.println("data_check_in: ");
                     String data_check_in = s.nextLine();
                    
                
                     Reserva_Quarto reserva_Quarto1 = new Reserva_Quarto(id_reserva,quarto , data_check_out, data_check_in);
                     reserva_QuartoDao.Create(reserva_Quarto1);
                    
                     break;
                case 2:
                   for (Reserva_Quarto c : reserva_QuartoDao.read()) {
                	   System.out.println(c.toString());
                   }
                    break;
                case 3:
                	 System.out.println("Id_reserva_Quarto: ");
                     id = s.nextInt();
                     s.nextLine();
                     System.out.println("quarto: ");
                     quarto = s.nextInt();
                     s.nextLine();
                     System.out.println("data_check_out: ");
                     data_check_out = s.nextLine();
                     System.out.println("data_check_in: ");
                     data_check_in = s.nextLine();
                    
                     Reserva_Quarto reserva_Quarto2 = new Reserva_Quarto(id,quarto ,data_check_out , data_check_in);
                     reserva_QuartoDao.Update(reserva_Quarto2);
                    
                     break;
                   
                case 4:
                	 System.out.println("Digite o id");
                	 id = s.nextInt();
                	 s.nextLine();
                	 
                  reserva_QuartoDao.delete(id);
                    break;
                case 5:
                	System.out.println("Digite o id");
               	 id = s.nextInt();
               	 s.nextLine();
               	 
                   Reserva_Quarto reserva_Quarto3 = reserva_QuartoDao.readById(id);
                   System.out.println(reserva_Quarto3.toString());
                    break;
               default:
            	   break;
            }
		}while(opcao !=0);
		
		System.out.println("Volte Sempre ");



	}

}
