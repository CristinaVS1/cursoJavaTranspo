package br.com.cursojava.aula03;

import java.util.Scanner;

public class M�dia {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Vamos calcular sua m�dia, digite tr�s notas a seguir!");
		System.out.println("Digite sua primeira nota");
		double nota1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a segunda nota");
		double nota2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a terceira e �ltima nota");
		double nota3 = Double.parseDouble(teclado.nextLine());

		double media = (nota1 + nota2 + nota3) / 3;

		System.out.println("O resultado da sua m�dia �: " + (media));

		teclado.close();

	}

}
