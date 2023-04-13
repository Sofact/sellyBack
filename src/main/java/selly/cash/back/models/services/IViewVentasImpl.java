package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IViewVentasDao;
import selly.cash.back.models.entity.ViewVentas;

import java.util.List;

@Service
public class IViewVentasImpl implements IViewVentasService{

    @Autowired
    private IViewVentasDao viewVentasDao;

    @Override
    public List<ViewVentas> findAll() {
        return (List<ViewVentas>) viewVentasDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public List<ViewVentas> findViewVentasByUsuId(Long id) {
        return viewVentasDao.findViewVentasByUsuId(id);
    }

    @Override
    public ViewVentas save(ViewVentas viewVentas) {
        return viewVentasDao.save(viewVentas);
    }
}
