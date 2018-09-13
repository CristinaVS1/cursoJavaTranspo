package br.com.cursojava.aula03;

import java.util.Scanner;

public class DiasMesesAnos {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Vou calcular sua idade em dias, meses e anos");
		System.out.println("Digite sua idade");
		int idade = Integer.parseInt(teclado.nextLine());

		int dias = idade * 365;
		int meses = idade * 12;
		int ano = idade;

		System.out.println(
				" Sua idade em dias é: " + (dias) + "\n Sua idade em meses: " + (meses) + " \n Sua idade em anos é: " + ano);

		teclado.close();

	}
}
