package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.ViewVentas;

import java.util.List;

public interface IViewVentasDao extends CrudRepository<ViewVentas, Long>{

    List<ViewVentas> findViewVentasByUsuId(Long id);
}
