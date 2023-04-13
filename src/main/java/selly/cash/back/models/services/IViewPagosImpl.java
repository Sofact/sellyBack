package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IPagosDao;
import selly.cash.back.models.dao.IViewPagosDao;
import selly.cash.back.models.entity.Pagos;
import selly.cash.back.models.entity.ViewPagos;

import java.util.List;

@Service
public class IViewPagosImpl implements IViewPagosService{

    @Autowired
    private IViewPagosDao viewPagosDao;

    @Override
    public List<ViewPagos> findall() {
        return (List<ViewPagos>) viewPagosDao.findAll();
    }

    @Override
    public List<ViewPagos> findViewPagosByUsuId(Long id) {
        return viewPagosDao.findViewPagosByUsuId(id);
    }
}
