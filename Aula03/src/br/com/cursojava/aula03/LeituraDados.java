package br.com.cursojava.aula03;

import java.util.Scanner;

public class LeituraDados {

	public static void main(String... args) {

		Scanner teste = new Scanner(System.in);

		/*System.out.println("Digite um n�mero");
		String n1 = teste.nextLine();
		int numero1 = Integer.parseInt(n1);
		System.out.println("Digite outro n�mero");
		int numero2 = Integer.parseInt(teste.nextLine());
		System.out.println(" O resultado �: " + (numero1 +  numero2));
		*/
		System.out.println("Digite o pre�o do produto");
		double preco = Double.parseDouble(teste.nextLine());
		double desconto = 0.10;
		
		System.out.println("O valor do desconto �: " + (preco * desconto));
		
		

		teste.close();

	}

}
