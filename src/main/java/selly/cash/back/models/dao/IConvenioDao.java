package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Convenio;


public interface IConvenioDao  extends CrudRepository<Convenio, Long> {
}
