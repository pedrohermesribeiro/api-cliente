package com.api.cliente.controller.endereco;

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
import org.springframework.web.bind.annotation.RestController;

import com.api.cliente.model.cliente.Cliente;
import com.api.cliente.model.endereco.Endereco;
import com.api.cliente.repository.endereco.RepositoryEndereco;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	@Autowired
	private RepositoryEndereco enderecoRepository;
	
	@GetMapping
	public List<Endereco> listar() {
		return enderecoRepository.findAll();
	}
	
	@PostMapping
	public Endereco adicionar(@RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		return enderecoRepository.findById(id)
		.map(record -> ResponseEntity.ok().body(record))
		.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id,@RequestBody Endereco endereco){
		return enderecoRepository.findById(id)
		.map(record ->{ record.setLogradouro(endereco.getLogradouro());record.setCEP(endereco.getCEP());
		record.setNumero(endereco.getNumero());
		Endereco updated = enderecoRepository.save(record);
		return ResponseEntity.ok().body(updated);})
		.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return enderecoRepository.findById(id)
		.map(record ->{enderecoRepository.deleteById(id);
			return ResponseEntity.noContent().<Void>build();})
		.orElse(ResponseEntity.notFound().build());
	}
}
