package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.Municipio;
import selly.cash.back.models.services.IMunicipioService;

import java.util.List;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private IMunicipioService municipioService;

    @GetMapping("/all")
    public List<Municipio> index(){

        return municipioService.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Municipio create (@RequestBody Municipio municipio){

        System.out.println("El nombre del municipio::::::"+municipio.getMunDescripcion());
        return municipioService.save(municipio);
    }
}
