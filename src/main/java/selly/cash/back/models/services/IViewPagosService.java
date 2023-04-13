package selly.cash.back.models.services;

import selly.cash.back.models.entity.Pagos;
import selly.cash.back.models.entity.ViewPagos;

import java.util.List;

public interface IViewPagosService {

    List<ViewPagos> findall();
    List<ViewPagos> findViewPagosByUsuId(Long id);

}
