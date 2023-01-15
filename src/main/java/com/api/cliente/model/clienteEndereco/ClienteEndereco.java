package com.api.cliente.model.clienteEndereco;

import java.util.List;

import com.api.cliente.model.cliente.Cliente;
import com.api.cliente.model.endereco.Endereco;
import com.api.cliente.repository.cliente.RepositoryCliente;
import com.api.cliente.repository.endereco.RepositoryEndereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class ClienteEndereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Cliente cliente;
	@OneToOne
	private Endereco endereco;
	/*@OneToMany(mappedBy = "lista")
	private List<Resposta> respostas = new ArrayList<>();*/
	
	ClienteEndereco (Cliente cliente, Endereco endereco){
		this.cliente = new Cliente();
		this.endereco = new Endereco();
	}
	ClienteEndereco(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String mostrar() {
		 StringBuilder sb = new StringBuilder();
					sb.append("Nome: ").append(cliente.getNome()).append("\nData Nascimento: ").append(cliente.getDataNascimento().toString())		
					.append("\nEndereço: ").append(endereco.getLogradouro()).append("\nNº: ").append(endereco.getNumero())
					.append("\nCEP: ").append(endereco.getCEP());
		return sb.toString();
	}


	
}
