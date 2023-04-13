package selly.cash.back.models.services;

import org.springframework.transaction.annotation.Transactional;
import selly.cash.back.models.entity.Marcas;
import selly.cash.back.models.entity.Parametros;

import java.util.List;

public interface IMarcasService {


    List<Marcas> findAll();

    List<String> findAllDescripcion();

    public Marcas save(Parametros parametro);

    @Transactional
    Marcas save(Marcas marca);

    void deleteById(Long id);

    public Marcas findById(Long id);
}
