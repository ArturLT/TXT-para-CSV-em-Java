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
        
        String outputCsvFilePath = outFolderPathStr + File.separator + "summary.csv";
		
        try (BufferedReader br = new BufferedReader(new FileReader(strPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputCsvFilePath))) {

              
               bw.write("Produto,ValorTotalVendido");
               bw.newLine(); 

               String line = br.readLine();

               // Se o seu TXT tem um cabeçalho 
               // if (line != null && line.contains("Nome") && line.contains("Preco") && line.contains("Quantidade")) {
               //    line = br.readLine(); // Pula o cabeçalho
               // }


               while (line != null) {
                   if (!line.trim().isEmpty()) { 
                       String[] vect = line.split(",");

                       // Garante que a linha tem os 3 elementos esperados
                       if (vect.length >= 3) {
                           String name = vect[0].trim(); 
                           Double price = Double.parseDouble(vect[1].trim());
                           Integer qte = Integer.parseInt(vect[2].trim());

                          
                           Double totalVendido = price * qte;

                           
                           bw.write(name + "," + String.format("%.2f", totalVendido)); 
                           bw.newLine(); 
                       } else {
                           System.out.println("Aviso: Linha ignorada por formato inválido (menos de 3 colunas): " + line);
                       }
                   }
                   line = br.readLine(); 
               }
             System.out.println("\nProcessamento concluído com sucesso!");
             System.out.println("Arquivo CSV de saída criado em: " + outputCsvFilePath);
			
		}
        catch (IOException e) {
        	System.err.println("Erro de E/S (leitura/escrita de arquivo): " + e.getMessage());
        } catch (NumberFormatException e) {
        	System.err.println("Erro de formato de número em uma linha. Verifique se preço e quantidade são válidos: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
        	System.err.println("Erro: Linha com formato inesperado. Verifique se os campos estão separados por vírgula: " + e.getMessage());
        } finally {
        	sc.close(); 
        }
		
	}

}
