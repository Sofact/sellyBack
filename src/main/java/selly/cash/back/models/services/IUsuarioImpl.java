package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IUsuarioDao;
import selly.cash.back.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class IUsuarioImpl implements IUsuarioService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioDao.findById(id);
    }

    @Override
    public Optional<Usuario> findUsuarioByUsuCorreo(String correo) {
        return usuarioDao.findUsuarioByUsuCorreo(correo);
    }
}
