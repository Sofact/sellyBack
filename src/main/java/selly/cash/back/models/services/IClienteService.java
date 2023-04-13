package selly.cash.back.models.services;

import selly.cash.back.models.entity.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Clientes> findAll();

    public Clientes save(Clientes cliente);

    Clientes findById(Long id);
}
