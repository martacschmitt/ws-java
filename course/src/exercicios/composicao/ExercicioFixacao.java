package exercicios.composicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import exercicios.composicao.entities.Client;
import exercicios.composicao.entities.Order;
import exercicios.composicao.entities.OrderItem;
import exercicios.composicao.entities.Product;
import exercicios.composicao.entities.enums.OrderStatus;

public class ExercicioFixacao {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(productName, price);
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			OrderItem item = new OrderItem(quantity, price, product);
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
		
	}
	
}
