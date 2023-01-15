package com.api.cliente.repository.clienteEndereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.cliente.model.cliente.Cliente;
import com.api.cliente.model.clienteEndereco.ClienteEndereco;
import com.api.cliente.model.endereco.Endereco;


public interface RepositoryClienteEndereco extends JpaRepository<ClienteEndereco, Long> {
	@Query(value = "SELECT cl.nome,ed.logradouro,ed.numero"
			+ "ed.CEP from Cliente as cl, Endereco as ed where cl.id = ed.id_cliente",nativeQuery = true)
	List<ClienteEndereco> findAll();
	
}


