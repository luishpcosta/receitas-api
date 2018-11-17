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

@Entity
@Table(name="ingrediente")
public class Ingrediente implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany
    @JoinTable(
        name = "receita_ingrediente",
        joinColumns = @JoinColumn(name = "ingrediente_id"),
        inverseJoinColumns = @JoinColumn(name = "receita_id")
    )
	private List<Receita> receitas;

	public Ingrediente() {
	}

	public Ingrediente(String nome) {
		this.nome = nome;
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

}
