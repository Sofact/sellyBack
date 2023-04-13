package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IProductoDao;
import selly.cash.back.models.entity.Producto;

import java.util.List;

@Service
public class IProductoImpl implements IProductoService{

    @Autowired
    private IProductoDao productoDao;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public void delete(Long id) {

        productoDao.delete(findById(id));
    }
}
