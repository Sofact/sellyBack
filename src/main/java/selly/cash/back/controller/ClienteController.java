package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.services.IClienteService;

import java.util.List;

@CrossOrigin(origins= "http://208.109.37.247")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/all")
    public List<Clientes> index(){

        return clienteService.findAll();
    }

    @GetMapping("/all/{id}")
    public Clientes search(@PathVariable Long id){

        return clienteService.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes create (@RequestBody Clientes cliente){

        System.out.println("El nombre del cliente::::::"+cliente.getCliNombre());
        return clienteService.save(cliente);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes cliente, @PathVariable Long id){

        Clientes clienteActual = clienteService.findById(id);

        clienteActual.setCliNombre(cliente.getCliNombre());
        clienteActual.setCliCedula(cliente.getCliCedula());

        return clienteService.save(clienteActual);

    }
}
