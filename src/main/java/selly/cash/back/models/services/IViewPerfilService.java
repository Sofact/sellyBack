package selly.cash.back.models.services;

import selly.cash.back.models.entity.ViewPerfil;

import java.util.Optional;

public interface IViewPerfilService {

    Optional<ViewPerfil> findViewPerfilByUsuId(Long id);
}
