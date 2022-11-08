package br.com.ddm.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ddm.domain.Despesa;
import br.com.ddm.dto.DespesaDTO;
import br.com.ddm.services.DespesasService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/despesas")
public class DespesasResource {

	@Autowired
	private DespesasService despesasService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DespesaDTO> findById(@PathVariable Integer id){
		DespesaDTO objDTO = new DespesaDTO(despesasService.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<DespesaDTO>> findAll(){
		List<DespesaDTO> listaDespesas = despesasService.findAll().stream().map(obj -> new DespesaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDespesas);
	}
	
	@PostMapping
	public ResponseEntity<DespesaDTO> create(@Valid @RequestBody DespesaDTO objDTO){
		Despesa newObj = despesasService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DespesaDTO> update(@PathVariable Integer id, @Valid @RequestBody DespesaDTO objDTO){
		DespesaDTO newObj = new DespesaDTO(despesasService.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		despesasService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
