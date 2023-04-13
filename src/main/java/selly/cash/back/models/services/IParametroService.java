package selly.cash.back.models.services;

import selly.cash.back.models.entity.Parametros;

import java.util.List;
import java.util.Optional;

public interface IParametroService {

    List<Parametros> findAll();

    List<String> findAllDescripcion();

    public Parametros save(Parametros parametro);

    void deleteById(Long id);

    public Parametros findById(Long id);
}
