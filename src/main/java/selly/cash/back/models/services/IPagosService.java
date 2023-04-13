package selly.cash.back.models.services;

import selly.cash.back.models.entity.Pagos;
import selly.cash.back.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IPagosService {

    List<Pagos> findAll();

    List<String> findAllDescripcion();

    public Pagos save(Pagos pagos);

    List<Pagos> findById(Long id);

    List<Pagos> findPagosByUsuId(Long id);

}
