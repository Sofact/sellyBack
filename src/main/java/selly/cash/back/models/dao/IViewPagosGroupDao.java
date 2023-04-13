package selly.cash.back.models.dao;

import org.springframework.data.repository.CrudRepository;
import selly.cash.back.models.entity.ViewPagosGrouped;

import java.util.List;

public interface IViewPagosGroupDao extends CrudRepository <ViewPagosGrouped, Long> {

    List<ViewPagosGrouped> findViewPagosGroupedByConvEstado(String estado);


}



