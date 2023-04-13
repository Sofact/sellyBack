package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.ViewPerfil;

import java.util.List;
import java.util.Optional;

public interface IViewPerfilDao extends CrudRepository<ViewPerfil, Long> {

  Optional<ViewPerfil> findViewPerfilByUsuId(Long id);

}
