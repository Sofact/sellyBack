package selly.cash.back.models.services;


import selly.cash.back.models.entity.ViewVentas;

import java.util.List;

public interface IViewVentasService {

    List<ViewVentas> findAll();

    List<String> findAllDescripcion();

    List<ViewVentas> findViewVentasByUsuId(Long id);

    public ViewVentas save(ViewVentas viewVentas);
}
