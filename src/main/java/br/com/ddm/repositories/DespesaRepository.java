package br.com.ddm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ddm.domain.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

}
