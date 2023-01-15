package com.api.cliente.controller.cliente;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.model.cliente.Cliente;
import com.api.cliente.repository.cliente.*;
import com.api.cliente.repository.cliente.RepositoryCliente;
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private RepositoryCliente clienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return clienteRepository.findById(id)
		.map(record -> ResponseEntity.ok().body(record))
		.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody Cliente cliente){
		return clienteRepository.findById(id)
		.map(record ->{ record.setNome(cliente.getNome());
			record.setDataNascimento(cliente.getDataNascimento());
			Cliente updated = clienteRepository.save(record);
		return ResponseEntity.ok().body(updated);})
		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return clienteRepository.findById(id)
		.map(record ->{clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();})
		.orElse(ResponseEntity.notFound().build());

	}

	

	
}
