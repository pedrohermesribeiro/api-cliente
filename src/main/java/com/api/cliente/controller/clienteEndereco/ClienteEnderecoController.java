package com.api.cliente.controller.clienteEndereco;

import java.awt.print.Printable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.model.cliente.Cliente;
import com.api.cliente.model.clienteEndereco.ClienteEndereco;
import com.api.cliente.model.endereco.Endereco;
import com.api.cliente.repository.cliente.RepositoryCliente;
import com.api.cliente.repository.clienteEndereco.*;
import com.api.cliente.repository.clienteEndereco.RepositoryClienteEndereco;
import com.api.cliente.repository.endereco.RepositoryEndereco;


@RestController
@RequestMapping("/api/clienteendereco")
public class ClienteEnderecoController{

	@Autowired
	private RepositoryClienteEndereco clienteEnderecoRepository;
	
	@GetMapping
	public List<ClienteEndereco> listar() {
		return clienteEnderecoRepository.findAll();
		/*for (ClienteEndereco obj : list) {
			System.out.println(obj);
			
		}
		return list;*/
	}
	
	@PostMapping
	public ClienteEndereco adicionar(@RequestBody ClienteEndereco clienteEndereco) {
		return clienteEnderecoRepository.save(clienteEndereco);
	}
	

	
}
	
	
	
