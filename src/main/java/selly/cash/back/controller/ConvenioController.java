package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Convenio;
import selly.cash.back.models.services.IConvenioService;

import java.util.List;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    private IConvenioService convenioService;

    @GetMapping("/all")
    public List<Convenio> index(){

        return convenioService.findAll();
    }

    @GetMapping("/all/{id}")
    public Convenio search(@PathVariable Long id){

        System.out.println("EL id del convenio:::"+ id);
        return convenioService.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Convenio create (@RequestBody Convenio convenio){

        System.out.println("El nombre del cliente::::::"+convenio.getCovNombre());
        return convenioService.save(convenio);
    }

    @DeleteMapping("/del/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public HttpStatus delete (@PathVariable long id){

        System.out.println("Borrando el id::" + id);

        try {
            convenioService.delete(id);
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

}
