package br.com.cursojava.aula2;

public class MaiorNumero {

	public static void main(String ...args) {
		
		
		int a = 10;
		int b = 20;
		int c = 15;
		
		//Faz a comparação e resulta o maior número entre eles;
		
		int maiorMenor = Math.max(a, b);
		
		//Faz uma segunda comparação entre o resultado anterior e a variável definida acima
		
		int resultadoFinal = Math.max(maiorMenor, c);
		
		System.out.println("Resultado da operação: " + resultadoFinal);
		
		
		
		
		
		
		
		
	}
}
