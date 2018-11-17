package br.com.lhpc.desafioopus.receitas.initializer;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.lhpc.desafioopus.receitas.models.Ingrediente;
import br.com.lhpc.desafioopus.receitas.models.Receita;
import br.com.lhpc.desafioopus.receitas.repository.IngredienteRepository;
import br.com.lhpc.desafioopus.receitas.repository.ReceitaRepository;

@Component
public class DataLoader {
	
	@Bean
	public CommandLineRunner loadData(ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository) {
		return  (args) -> { 
			Ingrediente ovo = new Ingrediente("Ovo");
			Ingrediente Acucar = new Ingrediente("Açúcar");
			Ingrediente manteiga = new Ingrediente("Manteiga");
			Ingrediente farinha = new Ingrediente("Farinha de Trigo");
			Ingrediente maisena = new Ingrediente("Maisena");
			Ingrediente leite = new Ingrediente("Leite");
			Ingrediente fermento = new Ingrediente("Fermento");
			Ingrediente baunilha = new Ingrediente("Baunilha");
			Ingrediente banana = new Ingrediente("Banana");
			
			List<Ingrediente> ingredientes = Arrays.asList(ovo,Acucar,manteiga, farinha, maisena, leite, fermento, baunilha, banana);
			ingredientes.forEach(ingrediente -> ingredienteRepository.save(ingrediente));
			
			Receita receita = new Receita("Cuca de Banana", 10, 4600, ingredientes, "Faça a massa e cubra com as bananas em fatias finas");
			receitaRepository.save(receita);
			
		};
	}

}
