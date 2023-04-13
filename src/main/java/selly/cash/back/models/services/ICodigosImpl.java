package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import selly.cash.back.models.dao.ICodigosDao;
import selly.cash.back.models.entity.Codigos;
import selly.cash.back.models.entity.Marcas;
import selly.cash.back.models.entity.Parametros;

import java.util.List;

@Service
public class ICodigosImpl implements ICodigosService{

    @Autowired
    private ICodigosDao codigosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Codigos> findAll() {
        return (List<Codigos>) codigosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Codigos findAllByCodCodigo(String codCodigo ) {

        Codigos codigo = codigosDao.findAllByCodCodigo(codCodigo);
        return codigo;
    }



    @Override
    @Transactional
    public Codigos save(Codigos codigo) {
        System.out.println("Guardando codigos::"+ codigo.getCodCodigo());
        return codigosDao.save(codigo);
    }



}
