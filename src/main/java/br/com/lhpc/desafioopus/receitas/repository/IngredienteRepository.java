package br.com.lhpc.desafioopus.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lhpc.desafioopus.receitas.models.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{

}
