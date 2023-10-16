package console;

import java.util.Locale;
import java.util.Scanner;

import dao.HotelDao;
import modelo.Hotel;

public class HotelCrud {

	public static void main(String[] args) {
		
			
			Scanner s = new Scanner(System.in); 
			Locale.setDefault(Locale.US);

			HotelDao hotelDao = new HotelDao();
			
			int opcao =0, id =0;
			
			do {
				
				System.out.println("\n##########################Hotels##########################\n");
				System.out.println("1- CRIAR 2- CONSULTAR 3- ATUALIZAR 4- DELETAR 5- CONSULTAR POR ID 0- SAIR ");
				opcao=s.nextInt();
				s.nextLine();
				

	            switch (opcao) {
	                case 1:
	                	
	                	 System.out.println("ID do hotel: ");
	                     int id_hotel = s.nextInt();
	                     s.nextLine();
	                	 System.out.println("Preço por noite: ");
	                     String precoPorNoite = s.next();
	                     double precoPor = Double.parseDouble(precoPorNoite);           
	                     System.out.println("Categorias: ");
	                     String categorias = s.nextLine();
	                	 System.out.println("Nome do hotel: ");
	                     String nomehotel = s.nextLine();
	                     System.out.println("CEP: ");
	                     String cep = s.nextLine();
	                     System.out.println("Rua: ");
	                     String rua = s.nextLine();
	                     System.out.println("Bairro: ");
	                     String bairro = s.nextLine();
	                     System.out.println("Telefone: ");
	                     String telefone = s.nextLine();
	                
	                     Hotel hotel1 = new Hotel(id_hotel, precoPor, categorias, nomehotel, cep, rua, bairro, telefone);
	                     hotelDao.Create(hotel1);
	                    
	                     break;
	                case 2:
	                   for (Hotel c : hotelDao.read()) {
	                	   System.out.println(c.toString());
	                   }
	                    break;
	                case 3:
	                	 System.out.println("Id_hotel: ");
	                     id = s.nextInt();
	                     s.nextLine();
	                     System.out.println(" Preço por noite: ");
	                     String novoPrecoStr = s.next();
	                     double novoPreco = Double.parseDouble(novoPrecoStr);
	                     System.out.println("Categorias: ");
	                     categorias = s.nextLine();
	                     System.out.println("Nome do hotel: ");
	                     nomehotel = s.nextLine();
	                     System.out.println("CEP: ");
	                     cep = s.nextLine();
	                     System.out.println("Rua: ");
	                     rua = s.nextLine();
	                     System.out.println("Bairro: ");
	                     bairro = s.nextLine();
	                     System.out.println("Telefone: ");
	                     telefone = s.nextLine();
	                    
	                     Hotel hotel2 = new Hotel(id,novoPreco , categorias, nomehotel, cep, rua, bairro, telefone);
	                     hotelDao.Update(hotel2);
	                    
	                     break;
	                   
	                case 4:
	                	 System.out.println("Digite o id");
	                	 id = s.nextInt();
	                	 s.nextLine();
	                	 
	                  hotelDao.delete(id);
	                    break;
	                case 5:
	                	System.out.println("Digite o id");
	               	 id = s.nextInt();
	               	 s.nextLine();
	               	 
	                   Hotel hotel3 = hotelDao.readById(id);
	                   System.out.println(hotel3.toString());
	                    break;
	               default:
	            	   break;
	            }
			}while(opcao !=0);
			
			System.out.println("Volte Sempre ");

		

		


	}

}
