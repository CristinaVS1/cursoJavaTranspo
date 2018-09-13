package br.com.cursojava.aula03;

import java.util.Scanner;

public class IMC {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite seu peso e altura");
		System.out.println("Digite seu peso");
		double peso = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite sua altura");
		double altura = Double.parseDouble(teclado.nextLine());

		double calculoIMC = peso / (altura * altura);

		System.out.println("O seu IMC é: " + calculoIMC);

		teclado.close();

	}

}
