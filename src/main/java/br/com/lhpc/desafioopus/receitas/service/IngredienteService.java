package br.com.lhpc.desafioopus.receitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lhpc.desafioopus.receitas.models.Ingrediente;
import br.com.lhpc.desafioopus.receitas.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;

	public List<Ingrediente> listaOrdenadaAlfabeticamente() {
		return ingredienteRepository.findAll(new Sort(Sort.Direction.ASC, "nome"));
	}

}
