package selly.cash.back.models.services;

import selly.cash.back.models.entity.User;


import java.util.List;
import java.util.Optional;

public interface IUserService {


    List<User> findAll();

    List<String> findAllDescripcion();

    public User save(User usuario);

    Optional<User> findById(Long id);


}
