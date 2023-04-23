package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.Codigos;

import java.util.List;

public interface ICodigosDao extends CrudRepository<Codigos, Long> {



    public Codigos findAllByCodCodigo(String codCodigo);



}
