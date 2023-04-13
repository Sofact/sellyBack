package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IComisionDao;
import selly.cash.back.models.entity.Comision;
import selly.cash.back.models.entity.Producto;

import java.util.List;

@Service
public class IComisionImpl implements IComisionService{

    @Autowired
    private IComisionDao comisionDao;

    @Override
    public List<Comision> findAll() {
        return (List<Comision>) comisionDao.findAll();
    }

    @Override
    public List<Comision> findAllbyStatus(String status) {

        return null;
    }

    @Override
    public float totalByEstatus(String status) {
        return 0;
    }

    @Override
    public Comision save(Comision comision) {

        return comisionDao.save(comision);
    }
}
