package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.Comision;
import selly.cash.back.models.services.IClienteService;
import selly.cash.back.models.services.IComisionService;

@CrossOrigin(origins={"http://208.109.37.247"})
@RestController
@RequestMapping("/comision")
public class ComisionController {

    @Autowired
    private IComisionService comisionService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Comision create (@RequestBody Comision comision){

        System.out.println("El nombre del cliente::::::"+comision.getComEstado());
        return comisionService.save(comision);
    }
}
