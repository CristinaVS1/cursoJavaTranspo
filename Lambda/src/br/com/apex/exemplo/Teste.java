package br.com.apex.exemplo;

import java.util.List;
import java.util.function.Consumer;

import br.com.apex.dao.FaturaDAO;
import br.com.apex.funcoeslambda.Faturas;

public class Teste {

	

	public static void main(String[] args) {

	
	List<Faturas> faturasVencidas = new FaturaDAO().buscarFaturasVencidas();
	

	faturasVencidas.forEach(f -> {
	
		f.resumo();
	
	});

	}
}

