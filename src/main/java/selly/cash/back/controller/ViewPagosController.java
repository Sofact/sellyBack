package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Pagos;
import selly.cash.back.models.entity.ViewPagos;
import selly.cash.back.models.services.IViewPagosService;

import java.util.List;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/pagos")
public class ViewPagosController  {

    @Autowired
    private IViewPagosService viewPagosService;

    @GetMapping("/all")
    public List<ViewPagos> all (){

        System.out.println("EL id en viewPagos::::");

        return  viewPagosService.findall();
    }

    @GetMapping("/total")
    public float total (){

        float total = 0;

        List<ViewPagos> pagos = viewPagosService.findall();

        for(ViewPagos pay: pagos ){

            total += pay.getPagValor();
        }

        return  total;
    }
    @GetMapping("/all/{id}")
    public List<ViewPagos> search (@PathVariable Long id){

        System.out.println("EL id en viewPagos::::" + id);

        return  viewPagosService.findViewPagosByUsuId(id);
    }

    @GetMapping("/totalId/{id}")
    public float searchId (@PathVariable Long id){


        System.out.println("El ID by id:::"+id);
        float total = 0;

        List<ViewPagos> pagos = viewPagosService.findViewPagosByUsuId(id);

        for(ViewPagos pay: pagos ){

            total += pay.getPagValor();
        }

        System.out.println("El total by id:::"+id);

        return  total;


    }
}
