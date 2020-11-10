package exercicios.polimorfismo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercicios.polimorfismo.entities.ImportedProduct;
import exercicios.polimorfismo.entities.Product;
import exercicios.polimorfismo.entities.UsedProduct;

public class ExercicioFixacao {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			switch (type) {
			case 'i':
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();				
				products.add(new ImportedProduct(name, price, customsFee));
				break;
			case 'u':
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
				break;
			default:
				products.add(new Product(name, price));
				break;
			}
		}
		
		System.out.println("");
		
		System.out.println("PRICE TAGS:");
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
		
	}
	
}
