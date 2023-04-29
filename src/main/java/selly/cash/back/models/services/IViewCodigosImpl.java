package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IViewCodigosDao;
import selly.cash.back.models.entity.ViewCodigos;

import java.util.List;

@Service
public class IViewCodigosImpl implements IViewCodigosService{

    @Autowired
    private IViewCodigosDao ViewCodigosDao ;
    @Override
    public List<ViewCodigos> findAll() {
        return (List<ViewCodigos>) ViewCodigosDao.findAll();
    }

    @Override
    public ViewCodigos save(ViewCodigos codigo) {
        return null;
    }

    @Override
    public ViewCodigos findAllByCodCodigo(String codCodigo) {
        return null;
    }
}
