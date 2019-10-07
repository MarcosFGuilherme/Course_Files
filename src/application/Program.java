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

import entities.SellItens;

public class Program {

	public static void main(String[] args) {
		Scanner sc = null;
		List<SellItens> sellItens = new ArrayList<>();
		try {
			// Main folder : C:\\temp
			File mainFolder = new File("C:\\temp");

			// Get file in : C:\temp\in\itensVendidos.csv
			sc = new Scanner(System.in);
			System.out.print("Enter a File (.csv): ");
			String strFile = sc.nextLine();

			// Reading file
			sellItens = readyFile(new File(mainFolder.getPath() + "\\in\\" + strFile));
			
			// Make folder out
			File[] folders = mainFolder.listFiles(File::isDirectory);
			for (File folder : folders) {
				if (!folder.getName().equals("\\out")) {
					boolean success = new File(mainFolder.getPath() + "\\out").mkdir();
				}
			}
			System.out.println();
			
			// Writing file.
			writerFile(mainFolder.getPath() + "\\out\\summary.csv" , sellItens);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static List<SellItens> readyFile(File pathIn) {
		List<SellItens> sellItens = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String line = br.readLine();

			while (line != null) {
				String[] si = line.split(",");
				SellItens sellItem = new SellItens(si[0], Double.parseDouble(si[1]), Integer.parseInt(si[2]));
				sellItens.add(sellItem);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		return sellItens;
	}

	public static void writerFile(String pathOut, List<SellItens> sellItens) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut))) {
			for (SellItens si : sellItens) {
				//System.out.println(si.toString(si.totalItens()));
				bw.write(si.toString(si.totalItens()));
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
	}
}
