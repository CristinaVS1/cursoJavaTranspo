package br.com.cursojava.aula03;

import java.util.Scanner;

public class Média {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Vamos calcular sua média, digite três notas a seguir!");
		System.out.println("Digite sua primeira nota");
		double nota1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a segunda nota");
		double nota2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a terceira e última nota");
		double nota3 = Double.parseDouble(teclado.nextLine());

		double media = (nota1 + nota2 + nota3) / 3;

		System.out.println("O resultado da sua média é: " + (media));

		teclado.close();

	}

}
