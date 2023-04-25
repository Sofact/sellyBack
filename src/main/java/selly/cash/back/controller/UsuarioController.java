package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.Usuario;
import selly.cash.back.models.services.IUsuarioService;

import java.util.Optional;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


    @GetMapping("/all/{id}")
    public Optional<Usuario> search(@PathVariable Long id){

        return usuarioService.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create (@RequestBody Usuario usuario){

        System.out.println("El nombre del cliente::::::"+usuario.getUsuNombre());
        return usuarioService.save(usuario);
    }
}
