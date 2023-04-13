package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Clientes;

public interface IClienteDao extends CrudRepository<Clientes, Long> {
}
