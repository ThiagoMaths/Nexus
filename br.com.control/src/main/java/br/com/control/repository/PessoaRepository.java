package br.com.control.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.control.model.Pessoa;

import java.util.Optional;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
