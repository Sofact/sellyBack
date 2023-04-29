package selly.cash.back.models.services;

import selly.cash.back.models.entity.Codigos;
import selly.cash.back.models.entity.ViewCodigos;

import java.util.List;

public interface IViewCodigosService {

    List<ViewCodigos> findAll();



    public ViewCodigos save(ViewCodigos codigo);


    ViewCodigos findAllByCodCodigo(String codCodigo );
}
