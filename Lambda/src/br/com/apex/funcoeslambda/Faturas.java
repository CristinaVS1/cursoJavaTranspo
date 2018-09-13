package br.com.apex.funcoeslambda;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Faturas {

	public String emailDevedor;
	public double valorFatura;
	public DayOfWeek diaVencimento;

	public Faturas(String emailDevedor, double valorFatura, LocalDate minusDays) {
		super();
		this.emailDevedor = emailDevedor;
		this.valorFatura = valorFatura;
		this.diaVencimento = diaVencimento;
	}

	public String getEmailDevedor() {
		return emailDevedor;
	}

	public void setEmailDevedor(String emailDevedor) {
		this.emailDevedor = emailDevedor;
	}

	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}

	public DayOfWeek getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(DayOfWeek diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public String resumo() {
		
		return String.format("Valor R$ % e dia de vencimento: %", this.getValorFatura(), this.getDiaVencimento());
	
	}
	
	
}
