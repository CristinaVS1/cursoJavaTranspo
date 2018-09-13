package br.com.cursojava.aula03;

import java.util.Scanner;

public class MédiaCincoNotas {

	public static void main(String... args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Vamos calcular sua média final. Digite cinco notas");
		System.out.println("Digite sua primeira nota");
		double nota1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a segunda nota");
		double nota2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a terceira nota");
		double nota3 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a quarta nota");
		double nota4 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite a quinta nota");
		double nota5 = Double.parseDouble(teclado.nextLine());

		double media = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;

		
		double resultado = Math.max(nota1, nota2);
		 resultado = Math.max(resultado, nota3);
		 resultado = Math.max(resultado, nota4);
		 resultado = Math.max(resultado, nota5);
		
		
		
		double resultado1 = Math.max(nota1, nota2);
		resultado1 = Math.max(resultado1, nota3);
		resultado1 = Math.max(resultado1, nota4);
		resultado1 = Math.max(resultado1, nota5);
		
		
		System.out.println("O resultado da sua média é: " + (media));
		
		System.out.println("Sua maior nota é: " + (resultado1));
		
		System.out.println("Sua menor nota é: " + resultado1);
		
		teclado.close();

	}

}
