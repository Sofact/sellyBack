package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IPagosDao;
import selly.cash.back.models.entity.Pagos;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Optional;

@Service
public class IPagosImpl implements IPagosService{

    @Autowired
    private IPagosDao pagosDao;

    @Override
    public List<Pagos> findAll() {
        return (List<Pagos>) pagosDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public Pagos save(Pagos pagos) {
        return pagosDao.save(pagos);
    }

    @Override
    public List<Pagos> findById(Long id) {
        return null;
    }


    public List<Pagos> findPagosByUsuId(Long id) {
        return (List<Pagos>) pagosDao.findPagosByUsuId(id);
    }
}
