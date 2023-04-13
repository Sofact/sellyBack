package selly.cash.back.models.services;

import selly.cash.back.models.entity.Codigos;
import selly.cash.back.models.entity.Marcas;
import selly.cash.back.models.entity.Parametros;

import java.util.List;

public interface ICodigosService {

    List<Codigos> findAll();
    public Codigos save(Codigos codigo);


    Codigos findAllByCodCodigo(String codCodigo );

}
