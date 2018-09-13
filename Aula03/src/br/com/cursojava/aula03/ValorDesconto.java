package br.com.cursojava.aula03;

import java.util.Scanner;

public class ValorDesconto {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o valor de um produto");
		double produto = Double.parseDouble(teclado.nextLine());

		double desconto = 0.50 * produto;

		System.out.println("O produto com percentual de desconto fica: " + (desconto));

		teclado.close();

	}
}
