package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.ViewCodigos;
import selly.cash.back.models.services.IViewCodigosService;

import java.util.List;

@CrossOrigin(origins= "${myapp.datasource.url}")
@RestController
@RequestMapping("/viewCodigos")
public class ViewCodigosController {

    @Autowired
    private IViewCodigosService viewCodigosService;

    @GetMapping("/code/{id}")
    public ViewCodigos show(@PathVariable Long id){

        System.out.println("Codigos/all");

        return null;// viewCodigosService.findById(id);
    }

    @GetMapping("/all")
    public List<ViewCodigos> index(){

        System.out.println("ingreso a viewCodigos");
        return viewCodigosService.findAll();
    }


}
