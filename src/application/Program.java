package application;

import java.io.File;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String  strPath = sc.nextLine();
		
		File path = new File(strPath);
		// C:\Users\User\Documents\Marcos\Desenvolvimento\Scripts-Banco.txt
		
		System.out.println("getPath: " + path.getPath());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getName: " + path.getName());
		
		sc.close();
	}

}
