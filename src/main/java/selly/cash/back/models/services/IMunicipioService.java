package selly.cash.back.models.services;

import selly.cash.back.models.entity.Municipio;


import java.util.List;

public interface IMunicipioService {

    List<Municipio> findAll();

    List<String> findAllDescripcion();

    public Municipio save(Municipio municipio);
}
