package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.Comision;
import selly.cash.back.models.entity.Pagos;
import selly.cash.back.models.services.IPagosService;

import java.util.List;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/pagos")
public class PagosController {

    @Autowired
    private IPagosService pagosService;

    @GetMapping("/user/{id}")
    public List<Pagos> search(@PathVariable Long id){

        System.out.println("El id del usuario"+ id);
        List<Pagos> pag = pagosService.findPagosByUsuId(id);
        System.out.println(pag.get(0).getPagValor());
        return  pagosService.findPagosByUsuId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Pagos create (@RequestBody Pagos pagos){

        System.out.println("El nombre del cliente en save::::::"+pagos.getUsuId());
        return pagosService.save(pagos);
    }

}
