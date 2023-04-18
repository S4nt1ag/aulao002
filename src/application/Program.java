package application;

import java.io.*;
import java.util.*;

import entities.Product;

public class Program {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String path = "c:\\aulao002\\in.txt";

		List<Product> list = new ArrayList<Product>();

		// le o arquivo
		ler(path, list);

		// Listar produtos
		System.out.println("PRODUCTS:");
		for (Product p : list) {
			System.out.println(p);
		}

		encontrarEatualizar("Teclado gamer", list, path);

		criarNovoProduto(path, list);

		ler(path, list);
	}

	public static void ler(String path, List<Product> list) {
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

		} catch (IOException e) {
			System.out.println("Error: linha invalida" + e.getMessage());
		}
	}

	public static void criarNovoProduto(String path, List<Product> list) {
		try {
			FileWriter cadastro = new FileWriter(path, true);
			BufferedWriter escrever = new BufferedWriter(cadastro);
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
	}

	public static void encontrarEatualizar(String nomeProcurado, List<Product> list, String path) {
		for (Product product : list) {
			if (product.getName().equalsIgnoreCase(nomeProcurado)) {
				System.out.println("Encontrei");
				System.out.println("Digite o novo nome: ");
				String novoNome = sc.next();
				product.setName(novoNome);

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
					for (Product product1 : list) {
						bw.write(product1.getName() + "," + product1.getPrice() + "," + product1.getQuantity());
						bw.newLine();
					}

				} catch (IOException e) {
					System.out.println("Error:" + e.getMessage());
				}
			}
		}
	}

}
