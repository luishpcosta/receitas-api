package br.com.lhpc.desafioopus.receitas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.lhpc.desafioopus.receitas.models.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	Receita findById(long id);
	
	@Query("Select r FROM Receita r JOIN FETCH r.ingredientes i where i.id=?1")
	List<Receita> listarReceitasComIngrediente(Long id);
	
}
