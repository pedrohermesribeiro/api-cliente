package com.api.cliente.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cliente.model.cliente.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

}
