package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.User;


public interface IUserDao extends CrudRepository<User, Long> {
}
