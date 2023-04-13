package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Pagos;
import selly.cash.back.models.entity.ViewPagos;

import java.util.List;

public interface IPagosDao extends CrudRepository<Pagos, Long> {

    List<Pagos> findPagosByUsuId(Long id);
}
