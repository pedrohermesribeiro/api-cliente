package com.api.cliente.model.cliente;

import java.util.Objects;

import javax.annotation.processing.Generated;

import com.api.cliente.model.endereco.Endereco;
import com.api.cliente.repository.endereco.RepositoryEndereco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.*;;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Date dataNascimento;
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> endereco;

	public Cliente (Long id,String nome, Date dataNascimento,List<Endereco> endereco) {
		this.setId(id);
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setEndereco(endereco); 
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
}
