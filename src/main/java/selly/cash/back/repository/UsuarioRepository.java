package selly.cash.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selly.cash.back.models.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    Optional<Usuario> findOneByUsuCorreo(String email);

}
