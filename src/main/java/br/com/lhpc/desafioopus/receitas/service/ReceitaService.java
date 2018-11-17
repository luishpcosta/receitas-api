package br.com.lhpc.desafioopus.receitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lhpc.desafioopus.receitas.models.Receita;
import br.com.lhpc.desafioopus.receitas.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;

	public Receita salvar(Receita receita) {
		return receitaRepository.save(receita);
	}

	public List<Receita> listar() {
		return receitaRepository.findAll();
	}

	public Receita findById(long id) {
		return receitaRepository.findById(id);
	}

	public List<Receita> listarReceitasComIngrediente(Long id) {
		return receitaRepository.listarReceitasComIngrediente(id);
	}

}
