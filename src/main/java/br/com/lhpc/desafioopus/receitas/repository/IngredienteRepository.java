package br.com.lhpc.desafioopus.receitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lhpc.desafioopus.receitas.models.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
	@Query("SELECT distinct i FROM Ingrediente i JOIN FETCH i.receitas")
	List<Ingrediente> listaIngredientesEmReceita();

}
