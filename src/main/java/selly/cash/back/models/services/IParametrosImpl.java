package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import selly.cash.back.models.dao.IParametroDao;
import selly.cash.back.models.entity.Parametros;

import java.util.List;
import java.util.Optional;

@Service
public class IParametrosImpl implements IParametroService{

    @Autowired
    private IParametroDao parametroDao;
    @Override
    @Transactional(readOnly = true)
    public List<Parametros> findAll() {

        return (List<Parametros>) parametroDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    @Transactional()
    public Parametros save(Parametros parametro) {

        return parametroDao.save(parametro);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        parametroDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Parametros findById(Long id) {

        Parametros params = parametroDao.findById(id).orElse(null);
        return params;
    }
}
