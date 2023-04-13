package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import selly.cash.back.models.dao.IClienteDao;
import selly.cash.back.models.entity.Clientes;

import java.util.List;
import java.util.Optional;

@Service
public class IClienteImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    public List<Clientes> findAll() {
        return (List<Clientes>) clienteDao.findAll();
    }

    @Override
    public Clientes save(Clientes cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes findById(Long id) {
        Clientes cliente =   clienteDao.findById(id).orElse(null);
        return cliente;
    }
}
