package selly.cash.back.models.services;

import selly.cash.back.models.entity.ViewPagosGrouped;

import java.util.List;

public interface IViewPagosGroupedService {

    List<ViewPagosGrouped> findall();
    List<ViewPagosGrouped> findViewPagosGroupedByConvEstado(String estado);
}
