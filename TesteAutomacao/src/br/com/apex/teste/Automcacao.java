package br.com.apex.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automcacao {

	private static WebElement cpf;
	private static WebElement   dataNascimento;

	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.magentofacil.com.br/customer/account/create/");

		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.sendKeys("Carlos");

		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.sendKeys("de Souza");

	   dataNascimento = driver.findElement(By.id("dob"));
	   digitaDataNacimentoDevagar("19/08/2000");

		cpf = driver.findElement(By.id("taxvat"));
		digitaCpfDevagar("19866690091");

		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys("valcanaiacristina16+1@gmail.com");

		WebElement senha = driver.findElement(By.id("password"));
		senha.sendKeys("abacaxi1");

		WebElement confirmarSenha = driver.findElement(By.id("password-confirmation"));
		confirmarSenha.sendKeys("abacaxi1");

		WebElement confirmaCadastro = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
		confirmaCadastro.click();

	}


	private static void digitaCpfDevagar(String string) {
		for (int i = 0; i < string.length(); i++) {
			try {
				Thread.sleep(1000);
				char c = string.charAt(i);
				String s = Character.toString(c);
				cpf.sendKeys(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
		


	private static void digitaDataNacimentoDevagar(String string) {
		for (int i = 0; i < string.length(); i++) {
			try {
				Thread.sleep(1000);
				char c = string.charAt(i);
				String s = Character.toString(c);
				dataNascimento.sendKeys(s);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	
}
	}