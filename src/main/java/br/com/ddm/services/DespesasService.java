package br.com.ddm.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddm.domain.Despesa;
import br.com.ddm.dto.DespesaDTO;
import br.com.ddm.repositories.DespesaRepository;
import br.com.ddm.services.exceptions.ObjectNotFoundException;

@Service
public class DespesasService {

	@Autowired
	private DespesaRepository despesaRepository;
	
	public Despesa findById(Integer id) {
		Optional<Despesa> obj = despesaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: " + Despesa.class.getName()));
	}
	
	public List<Despesa> findAll(){
		return despesaRepository.findAll();
	}
	
	public Despesa create(@Valid DespesaDTO objDTO) {
		Despesa newObj = new Despesa(null, objDTO.getNome(), objDTO.getFormaPagamento(), objDTO.getValor());
		return despesaRepository.save(newObj);
	}
	
	public Despesa update(Integer id, @Valid DespesaDTO objDTO) {
		Despesa oldObj = findById(id);
		dataUpdate(objDTO, oldObj);
		return despesaRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Despesa obj = findById(id);
		despesaRepository.deleteById(obj.getId());
	}
	
	private void dataUpdate(DespesaDTO objDTO, Despesa oldObj) {
		oldObj.setNome(objDTO.getNome());
		oldObj.setFormaPagamento(objDTO.getFormaPagamento());
		oldObj.setValor(objDTO.getValor());
	}
}
