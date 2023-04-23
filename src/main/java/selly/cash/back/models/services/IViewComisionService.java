package selly.cash.back.models.services;

import selly.cash.back.models.entity.Comision;
import selly.cash.back.models.entity.ViewComision;


import java.util.List;

public interface IViewComisionService {

    List<ViewComision> findAll();

    public List<ViewComision> findAllByEstado(String estado);
    List<String> findAllDescripcion();

    public Comision save(Comision comision);

    ViewComision findTopByUsuIdOrderByComIdDesc(String usuId);


}
