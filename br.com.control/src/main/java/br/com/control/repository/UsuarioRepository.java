package br.com.control.repository;

import jakarta.data.repository.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.control.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("select u from Usuario u where (u.login) = ?1")
    Usuario findByLogin(String login);

    @Query("select u from Usuario u where upper(u.login) = ?1 and upper(u.senha) = ?2 ")
    boolean validarLogin(String login, String senha);


}
