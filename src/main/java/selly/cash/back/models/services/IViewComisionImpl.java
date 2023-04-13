package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IViewComisionDao;
import selly.cash.back.models.entity.Comision;
import selly.cash.back.models.entity.ViewComision;

import java.util.List;

@Service
public class IViewComisionImpl  implements IViewComisionService{

    @Autowired
    private IViewComisionDao viewComisionDao;


    @Override
    public List<ViewComision> findAll() {

        return (List<ViewComision>) viewComisionDao.findAll();
    }

    public List<ViewComision> findAllByEstado(String estado){

        return (List<ViewComision>) viewComisionDao.findViewComisionsByComEstado(estado);
    }
    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Comision save(Comision comision) {
        return null;
    }
}
