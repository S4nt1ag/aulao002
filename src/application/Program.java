package application;

import java.io.*;
import java.util.*;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		String path = "c:\\aulao002\\in.txt";

		List<Product> list = new ArrayList<Product>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				String name = vect[0];
				Double price = Double.parseDouble(vect[1]);
				Integer qte = Integer.parseInt(vect[2]);

				Product prod = new Product(name, price, qte);
				list.add(prod);

				line = br.readLine();
			}
			System.out.println("PRODUCTS:");
			for (Product p : list) {
				System.out.println(p);
			}
		} catch (IOException e) {
			System.out.println("Error: linha invalida" + e.getMessage());
		}
		try {
			FileWriter cadastro = new FileWriter(path, true);
			BufferedWriter escrever = new BufferedWriter(cadastro);
			Scanner sc = new Scanner(System.in);
			System.out.println("Nome do produto: ");
			String name = sc.nextLine();
			System.out.println("Preço do produto: ");
			Double price = sc.nextDouble();
			System.out.println("Quantidade do produto: ");
			Integer qte = sc.nextInt();
			escrever.write(name + "," + price + "," + qte);
			escrever.newLine();

			sc.close();
			escrever.close();

		} catch (InputMismatchException | IOException e1) {
			e1.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {

				String[] vect = line.split(",");
				String name = vect[0];
				Double price = Double.parseDouble(vect[1]);
				Integer qte = Integer.parseInt(vect[2]);

				Product prod = new Product(name, price, qte);
				list.add(prod);

				line = br.readLine();
			}
			System.out.println("PRODUCTS:");
			for (Product p : list) {
				System.out.println(p);
			}
		} catch (IOException e) {
			System.out.println("Error: linha invalida" + e.getMessage());
		}

	}

}
