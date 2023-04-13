package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.ViewComision;
import selly.cash.back.models.entity.ViewVentas;
import selly.cash.back.models.services.IViewVentasService;

import java.util.List;

@CrossOrigin(origins={"http:localhost:4200"})
@RestController
@RequestMapping("/viewVentas")
public class ViewVentasController {

    @Autowired
    private IViewVentasService viewVentasService;

    @GetMapping("/all")
    public List<ViewVentas> index(){

        return viewVentasService.findAll();
    }

    @GetMapping("/all/{id}")
    public List<ViewVentas> search(@PathVariable Long id){

        return viewVentasService.findViewVentasByUsuId(id);
    }

    @GetMapping("/total/{id}")
    public Float total(@PathVariable Long id){

        float total = 0;
        List<ViewVentas> ventas = viewVentasService.findViewVentasByUsuId(id);

        for(ViewVentas venta: ventas){

            total += venta.getComValor();

        }
        return total;
    }
}
