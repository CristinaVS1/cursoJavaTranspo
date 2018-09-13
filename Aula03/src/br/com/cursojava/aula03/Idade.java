package br.com.cursojava.aula03;

import java.util.Scanner;

public class Idade {

	public static void main(String ...args) {
		
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite sua idade. Em seguida vamos apresentar a sua idade daqui a vinte anos");
		System.out.println("Digite sua idade");
		int idade = Integer.parseInt(teclado.nextLine());
		
		int idade20 = idade + 20;
		
		System.out.println("Sua idade daqui 20 anos será: " + (idade20));
		
		
		teclado.close();
		
	}
}
