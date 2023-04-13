package selly.cash.back.models.services;

import selly.cash.back.models.entity.Comision;

import java.util.List;

public interface IComisionService {

    List<Comision> findAll();

    List<Comision> findAllbyStatus(String status);
    public float totalByEstatus(String status);

    public Comision save ( Comision comision);
}
