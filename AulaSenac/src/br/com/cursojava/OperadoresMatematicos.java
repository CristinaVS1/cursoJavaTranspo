package br.com.cursojava;

public class OperadoresMatematicos {

	public static void main(String... args) {

		int numero1 = 10;
		int numero2 = 3;

		System.out.println("Soma ");
		System.out.printf("%d + %d = %d\n", numero1, numero2, numero1 + numero2);

		System.out.println("-------------------------------------");

		System.out.println("Subtra��o ");
		System.out.printf("%d - %d = %d\n", numero1, numero2, numero1 - numero2);

		System.out.println("-------------------------------------");

		System.out.println("Multiplica��o ");
		System.out.printf("%d * %d = %d\n", numero1, numero2, numero1 * numero2);
		
		System.out.println("-------------------------------------");
		
		System.out.println("Divis�o ");
		System.out.printf("%d / %.2f = %f\n", numero1, 3.0, numero1 / 3.0);

		System.out.println("-------------------------------------");
		
		System.out.println("Resto da divis�o ");
		System.out.printf("%d %% %d = %d\n", numero1, numero2, numero1 % numero2);
		

	}

}
