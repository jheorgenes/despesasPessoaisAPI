package br.com.ddm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ddm.repositories.DespesaRepository;

@Service
public class DespesasService {

	@Autowired
	private DespesaRepository despesaRepository;
	
	
}
