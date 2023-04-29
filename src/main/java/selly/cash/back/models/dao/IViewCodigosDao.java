package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.ViewCodigos;
import selly.cash.back.models.entity.ViewComision;

public interface IViewCodigosDao extends CrudRepository<ViewCodigos, Long> {

}
