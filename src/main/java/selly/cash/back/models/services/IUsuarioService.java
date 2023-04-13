package selly.cash.back.models.services;

import selly.cash.back.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> findAll();

    List<String> findAllDescripcion();

    public Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long id);

    public Optional<Usuario> findUsuarioByUsuCorreo(String correo);
}
