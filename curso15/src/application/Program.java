package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o caminho do arquivo .csv: ");
		String strPath = sc.nextLine();
		List<Product> list = new ArrayList<Product>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
					String[] vect = line.split(",");
					String name = vect[0];
					Double price = Double.parseDouble(vect[1]);
					Integer qte = Integer.parseInt(vect[2]);
					Double vendas = price * qte;
					Product prod = new Product(name, price, qte);
					list.add(prod);
					line = br.readLine();
			}
			
			System.out.println("Produtos: ");
			for(Product p : list) {
				System.out.println(p);
			}
			sc.close();
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		String path = "C:\\Users\\artur\\Desktop\\Results\\out.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
