package br.com.cursojava.aula2;

public class MaiorNumero {

	public static void main(String ...args) {
		
		
		int a = 10;
		int b = 20;
		int c = 15;
		
		//Faz a compara��o e resulta o maior n�mero entre eles;
		
		int maiorMenor = Math.max(a, b);
		
		//Faz uma segunda compara��o entre o resultado anterior e a vari�vel definida acima
		
		int resultadoFinal = Math.max(maiorMenor, c);
		
		System.out.println("Resultado da opera��o: " + resultadoFinal);
		
		
		
		
		
		
		
		
	}
}
