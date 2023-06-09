package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Producto;
import selly.cash.back.models.services.IClienteService;
import selly.cash.back.models.services.IProductoService;

import java.util.List;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping( "/productos")
public class ProductosController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/all")
    public List<Producto> index(){
        System.out.println("Productos all");
        return productoService.findAll();
    }

    @GetMapping("/all/{id}")
    public List<Producto> search(){

        return productoService.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto producto){

        return productoService.save(producto);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto){

        System.out.println("UPDATE Producto:::"+ producto.getProId());

        Producto productoActual = productoService.findById(producto.getProId());

        System.out.println("ProductoActual::"+ productoActual.getProValor());
        System.out.println("ProductoOriginal::"+ producto.getProValor());

        productoActual.setProDescripcion(producto.getProDescripcion());
        productoActual.setProReferencia(producto.getProReferencia());
        productoActual.setProValor(producto.getProValor());

        System.out.println("ProductoFinal::"+ productoActual.getProValor());

        return productoService.save(productoActual);
    }

    @DeleteMapping("/op/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Long delete (@PathVariable long id){

        System.out.println("Borrando el id::" + id);
         productoService.delete(id);
        return id;
    }



}
