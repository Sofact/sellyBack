package selly.cash.back.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import selly.cash.back.models.dao.IUserDao;
import selly.cash.back.models.dao.IUsuarioDao;
import selly.cash.back.models.entity.User;



import java.util.List;
import java.util.Optional;

@Service
public class IUserImpl implements IUserService{


    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public List<String> findAllDescripcion() {
        return null;
    }

    @Override
    public User save(User usuario) {
        return userDao.save(usuario);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

}

