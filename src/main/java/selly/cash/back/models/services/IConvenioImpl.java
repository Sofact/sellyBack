package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IConvenioDao;
import selly.cash.back.models.entity.Convenio;

import java.util.List;

@Service
public class IConvenioImpl implements IConvenioService{

    @Autowired
    private IConvenioDao convenioDao;
    @Override
    public List<Convenio> findAll() {
        return (List<Convenio>) convenioDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Convenio save(Convenio convenio) {
        return convenioDao.save(convenio);
    }

    @Override
    public Convenio findById(Long id) {
        return null;
    }
}
