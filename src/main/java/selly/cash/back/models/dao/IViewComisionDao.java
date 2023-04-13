package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Codigos;
import selly.cash.back.models.entity.ViewComision;

import java.util.List;

public interface IViewComisionDao extends CrudRepository<ViewComision, Long> {


    List<ViewComision> findViewComisionsByComEstado(String estado);
}
