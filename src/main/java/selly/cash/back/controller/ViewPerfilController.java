package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.ViewPerfil;
import selly.cash.back.models.entity.ViewVentas;
import selly.cash.back.models.services.IViewPerfilService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins={"http://208.109.37.247"})
@RestController
@RequestMapping("/perfil")
public class ViewPerfilController {

    @Autowired
    private IViewPerfilService viewPerfilService;

    @GetMapping("/all/{id}")
    public Optional<ViewPerfil> search(@PathVariable Long id){

        return (Optional<ViewPerfil>)viewPerfilService.findViewPerfilByUsuId(id);
    }
}
