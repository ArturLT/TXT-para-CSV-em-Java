package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
		File sourceFile = new File(strPath); 
        String sourceFolderStr = sourceFile.getParent(); 

        
        String outFolderPathStr = sourceFolderStr + File.separator + "out";
        File outFolder = new File(outFolderPathStr);
        
        if (!outFolder.exists()) {
            if (outFolder.mkdir()) { 
                System.out.println("Pasta 'out' criada em: " + outFolderPathStr);
            } else {
                System.err.println("Falha ao criar a pasta 'out' em: " + outFolderPathStr);
                sc.close();
                return;
            }
        } else {
            System.out.println("Pasta 'out' já existe: " + outFolderPathStr);
        }
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			line = br.readLine();
			
			while (line != null) {
					String[] vect = line.split(",");
					String name = vect[0];
					Double price = Double.parseDouble(vect[1]);
					Integer qte = Integer.parseInt(vect[2]);
					Product prod = new Product(name, price, qte);
					line = br.readLine();
			}
			
			sc.close();
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

}
