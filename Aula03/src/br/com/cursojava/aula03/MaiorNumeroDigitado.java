package br.com.cursojava.aula03;

import java.util.Scanner;

public class MaiorNumeroDigitado {
	
	public static void main(String ...args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Digite um n�mero");
		int n1 = Integer.parseInt(teclado.nextLine());
		System.out.println("Digite um segundo n�mero");
		int n2 = Integer.parseInt(teclado.nextLine());
		
		int max = Math.max(n1, n2);
		
		System.out.println("O maior n�mero digitado foi: " + (max));
		
		teclado.close();
		
		
		
		
		
		
	}

}
