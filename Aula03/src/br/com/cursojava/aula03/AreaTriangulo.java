package br.com.cursojava.aula03;

import java.util.Scanner;

public class AreaTriangulo {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite a base de um triangulo");
		double base = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a base de um triangulo");
		double altura = Double.parseDouble(teclado.nextLine());

		double area = (base * altura) / 2;

		System.out.println("O resultado da área do triângulo é: " + area);

		teclado.close();

	}
}
