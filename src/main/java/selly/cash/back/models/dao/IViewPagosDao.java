package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.ViewPagos;

import java.util.List;

public interface IViewPagosDao extends CrudRepository<ViewPagos, Long> {

    List<ViewPagos> findViewPagosByUsuId(Long id);
}
