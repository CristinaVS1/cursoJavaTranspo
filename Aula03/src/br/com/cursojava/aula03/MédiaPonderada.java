package br.com.cursojava.aula03;

import java.util.Scanner;

public class M�diaPonderada {

	public static void main(String ...args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Bem-vindo ao nosso sistema de m�dias ponderadas");
		System.out.println("Digite sua primeira nota");
		double nota1 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite sua segunda nota");
		double nota2 = Double.parseDouble(teclado.nextLine());
		System.out.println("Digite sua terceira nota");
		double nota3 =Double.parseDouble(teclado.nextLine());
		
		
		double pesoPonderado1 = 2;
		double pesoPonderado2 = 3;
		double pesoPonderado3 = 5;
		double notaMaxima = 10;
		
		double primeiraNota = (pesoPonderado1 * nota1) / notaMaxima;
		double segundaNota = (pesoPonderado2 * nota2) / notaMaxima;
		double terceiraNota = (pesoPonderado3 * nota3) / notaMaxima;
		
		double mediaPonderada = primeiraNota + segundaNota + terceiraNota;
		
		System.out.println("A sua m�dia �: " + mediaPonderada);
		
		
		
		teclado.close();
		
	}
}
