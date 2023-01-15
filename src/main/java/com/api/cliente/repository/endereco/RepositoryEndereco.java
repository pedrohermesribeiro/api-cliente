package com.api.cliente.repository.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.cliente.model.cliente.Cliente;
import com.api.cliente.model.clienteEndereco.ClienteEndereco;
import com.api.cliente.model.endereco.Endereco;

public interface RepositoryEndereco extends JpaRepository<Endereco, Long> {

	/*@Query(value = true, value = "SELECT ed.logradouro from Endereco as ed",nativeQuery = true)
	List<Endereco> findAll();*/

}

