package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IMunicipioDao;
import selly.cash.back.models.entity.Municipio;

import java.util.List;

@Service
public class IMuniImpl implements IMunicipioService{

    @Autowired
    private IMunicipioDao municipioDao;

    @Override
    public List<Municipio> findAll() {
        return (List<Municipio>) municipioDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Municipio save(Municipio municipio) {
        return municipioDao.save(municipio);
    }
}
