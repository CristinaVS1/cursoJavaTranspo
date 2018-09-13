package br.com.apex.dao;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.apex.funcoeslambda.Faturas;

public class FaturaDAO {



	

	public List<Faturas> buscarFaturasVencidas(){
		
		List<Faturas> faturasVencidas = new ArrayList<Faturas>().;
		Faturas f1 = new Faturas("joao@joao.com", 350.00, LocalDate.now().minusDays(3)); 
		Faturas f2 = new Faturas("carlos@carlos.com", 150.00, LocalDate.now().minusDays(3));
		Faturas f3 = new Faturas("jose@jose.com", 180.00, LocalDate.now().minusDays(3));
		
		return Arrays.asList(f1,f2,f3);
		
		
		
		
	}
	
	
}
