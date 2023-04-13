package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {
}
