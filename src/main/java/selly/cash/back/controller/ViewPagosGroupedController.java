package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.ViewPagosGrouped;
import selly.cash.back.models.services.IViewPagosGroupedService;

import java.util.List;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/pagosGroup")
public class ViewPagosGroupedController {

    @Autowired
    private IViewPagosGroupedService viewPagosGroupedService;

    @GetMapping("/all")
    public List<ViewPagosGrouped> search(){

        return(List<ViewPagosGrouped>) viewPagosGroupedService.findall();
    }
    @GetMapping("/all/{estado}")
    public List<ViewPagosGrouped> searchByEstado(@PathVariable String estado){

        System.out.println("Pagos group:::"+estado);
        return(List<ViewPagosGrouped>) viewPagosGroupedService.findViewPagosGroupedByConvEstado(estado);
    }
}
