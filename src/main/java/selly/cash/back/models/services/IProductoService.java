package selly.cash.back.models.services;

import selly.cash.back.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    List<String> findAllDescripcion();

    Producto findById(Long id);

    public Producto save(Producto producto);

    void delete(Long id);

}
