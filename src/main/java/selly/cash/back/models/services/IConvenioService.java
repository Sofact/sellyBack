package selly.cash.back.models.services;

import selly.cash.back.models.entity.Convenio;
import selly.cash.back.models.entity.Producto;

import java.util.List;

public interface IConvenioService {


    List<Convenio> findAll();

    List<String> findAllDescripcion();

    public Convenio save(Convenio convenio);

    Convenio findById(Long id);

    void delete(Long id);
}
