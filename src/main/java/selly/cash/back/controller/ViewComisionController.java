package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.ViewComision;
import selly.cash.back.models.services.IViewComisionService;

import java.util.List;
import java.util.function.Consumer;

@CrossOrigin(origins={"http:localhost:4200"})
@RestController
@RequestMapping( "/viewComision")
public class ViewComisionController {

    @Autowired
    private IViewComisionService comisionService;

    @GetMapping("/all")
    public List <ViewComision> index(){

        return comisionService.findAll();
    }

    @GetMapping("/estado/{estado}")
    public List <ViewComision> estado(@PathVariable String estado){

        return comisionService.findAllByEstado(estado);
    }

    @GetMapping("/totalEstado/{estado}/{usuId}")
    public float totalEstado(@PathVariable String estado, @PathVariable Long usuId){

        System.out.println("El user::"+ usuId);
        float total = 0;
       List <ViewComision>  comisiones= comisionService.findAllByEstado(estado);

        for(ViewComision comision: comisiones){

            if(comision.getUsuId() == usuId)
             total += comision.getComValor();

        }

        System.out.println("El total:::"+ total);
        return total;
    }

    @GetMapping("/lastComision/{usuId}")
    public ViewComision getLastComision(@PathVariable String usuId){

        ViewComision viewComision = comisionService.findTopByUsuIdOrderByComIdDesc(usuId);
        return viewComision;
    }

}
