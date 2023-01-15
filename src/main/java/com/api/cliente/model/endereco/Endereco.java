package com.api.cliente.model.endereco;


import com.api.cliente.model.cliente.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	private String logradouro;
	private String CEP;
	private String numero;
	
	public Endereco (Long id,Cliente cliente,String logradouro, String cep, String numero) {
		this.setId(id);
		this.setCliente(cliente); 
		this.setLogradouro(logradouro); 
		this.setCEP(cep); 
		this.setNumero(numero); 
	}
	
	public Endereco() {
		
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

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	


}
