package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Marcas;
import selly.cash.back.models.entity.Parametros;

public interface IMarcasDao extends CrudRepository<Marcas, Long> {
}
