package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		String  path =  "C:\\Users\\User\\Documents\\Marcos\\Desenvolvimento\\ws-eclipse\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		//Scanner sc = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			try {
				if (br!= null) br.close();
				if (fr!= null) fr.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
