package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Comision;

public interface IComisionDao extends CrudRepository<Comision, Long> {
}
