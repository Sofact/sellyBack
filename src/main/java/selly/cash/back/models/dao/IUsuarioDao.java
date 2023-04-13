package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Usuario;

import java.util.Optional;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {


    public Optional<Usuario> findUsuarioByUsuCorreo(String correo);
}
