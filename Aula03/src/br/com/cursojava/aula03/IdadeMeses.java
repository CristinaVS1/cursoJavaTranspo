package br.com.cursojava.aula03;

import java.util.Scanner;

public class IdadeMeses {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Vamos calcular a sua idade em meses");
		System.out.println("Digite sua idade");
		int idade = Integer.parseInt(teclado.nextLine());

		int meses = idade * 12;

		System.out.println("Sua idade em meses é: " + (meses));

		teclado.close();

	}

}
