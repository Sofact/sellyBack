package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import selly.cash.back.models.dao.IViewPagosGroupDao;
import selly.cash.back.models.entity.ViewPagosGrouped;

import java.util.List;

@Service
public class IViewPagosGroupedImpl implements IViewPagosGroupedService{


    @Autowired
    private IViewPagosGroupDao viewPagosGroupDao;

    @Override
    public List<ViewPagosGrouped> findall() {
        return (List<ViewPagosGrouped>) viewPagosGroupDao.findAll();
    }

    @Override
    public List<ViewPagosGrouped> findViewPagosGroupedByConvEstado(@PathVariable String estado) {
        return (List<ViewPagosGrouped>) viewPagosGroupDao.findViewPagosGroupedByConvEstado(estado);
    }
}
