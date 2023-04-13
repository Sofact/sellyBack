package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IViewPerfilDao;
import selly.cash.back.models.dao.IViewVentasDao;
import selly.cash.back.models.entity.ViewPerfil;

import java.util.Optional;

@Service
public class IViewPerfilImpl implements IViewPerfilService {

    @Autowired
    private IViewPerfilDao perfilDao;


    @Override
    public Optional<ViewPerfil> findViewPerfilByUsuId(Long id) {
        return (Optional<ViewPerfil>) perfilDao.findViewPerfilByUsuId(id);
    }
}
