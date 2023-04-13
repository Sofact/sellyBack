package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Municipio;

public interface IMunicipioDao extends CrudRepository<Municipio, Long> {
}
