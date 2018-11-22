package br.com.lhpc.desafioopus.receitas.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="receita")
public class Receita  implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	
	private Integer porcoes;
	
	private Integer calorias;
	
	@NotNull
	@NotEmpty
	@ManyToMany
    @JoinTable(
        name = "receita_ingrediente",
        joinColumns = @JoinColumn(name = "receita_id"),
        inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
	private List<Ingrediente> ingredientes;
	
	private String modoDePreparo;
	
	public Receita() {
		
	}
	
	public Receita(String nome, Integer porcoes, Integer calorias, List<Ingrediente> ingredientes,
			String modoDePreparo) {
		super();
		this.nome = nome;
		this.porcoes = porcoes;
		this.calorias = calorias;
		this.ingredientes = ingredientes;
		this.modoDePreparo = modoDePreparo;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPorcoes() {
		return porcoes;
	}

	public void setPorcoes(Integer porcoes) {
		this.porcoes = porcoes;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}
	
}


