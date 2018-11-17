package br.com.lhpc.desafioopus.receitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lhpc.desafioopus.receitas.models.Ingrediente;
import br.com.lhpc.desafioopus.receitas.models.Receita;
import br.com.lhpc.desafioopus.receitas.service.IngredienteService;
import br.com.lhpc.desafioopus.receitas.service.ReceitaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping
@Api(value="API REST RECEITAS")
@CrossOrigin("*")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@PostMapping("/receita")
	@ApiOperation(value="Inicializa uma receita e retorna Receita Criada")
	public ResponseEntity<Receita> criar(@RequestBody Receita receita){
		receita = receitaService.salvar(receita);
		return ResponseEntity.status(HttpStatus.CREATED).body(receita);
		
	}
	
	@GetMapping("/receitas")
	@ApiOperation(value="Devolve todas as receitas em memória")
	public ResponseEntity<List<Receita>> listar(){
		 List<Receita> lista = receitaService.listar();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/receitas/{id}")
	@ApiOperation(value="Devolve uma receita em memória por id")
	public  ResponseEntity<Receita> buscarPorId(@PathVariable long id){
		Receita receita = receitaService.findById(id);
		return receita != null ? ResponseEntity.ok().body(receita) : ResponseEntity.notFound().build() ;
	}
	
	@GetMapping("/receitas/{id}/ingrediente")
	@ApiOperation(value="Devolve os ingredientes de uma receita")
	public  ResponseEntity<List<Ingrediente>> IngredientesPorReceita(@PathVariable long id){
		Receita receita = receitaService.findById(id);
		return receita != null ? ResponseEntity.ok().body(receita.getIngredientes()) : ResponseEntity.notFound().build() ;
	}
	
	@GetMapping("/receitas/-/ingrediente/{id}")
	@ApiOperation(value="devolve receitas que contenham o ingrediente definido por id")
	public  ResponseEntity<List<Receita>> receitaComIngrediente(@PathVariable long id){
		 List<Receita> lista = receitaService.listarReceitasComIngrediente(id);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/ingredientes")
	@ApiOperation(value="devolve os ingredientes disponíveis, ordenados alfabeticamente")
	public ResponseEntity<List<Ingrediente>> listarIngredientes(){
		List<Ingrediente> listaIngredientes = ingredienteService.listaOrdenadaAlfabeticamente();
		return ResponseEntity.ok().body(listaIngredientes);
	}
	
}
