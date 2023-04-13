package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import selly.cash.back.models.dao.IMarcasDao;
import selly.cash.back.models.entity.Marcas;
import selly.cash.back.models.entity.Parametros;

import java.util.List;

@Service
public class iMarcasImpl implements IMarcasService{

    @Autowired
    private IMarcasDao marcasDao;
    @Override
    @Transactional(readOnly = true)
    public List<Marcas> findAll() {
        return (List<Marcas>) marcasDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Marcas save(Parametros parametro) {
        return null;
    }

    @Override
    @Transactional
    public Marcas save(Marcas marca) {

        return marcasDao.save(marca);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Marcas findById(Long id) {
        return null;
    }
}
