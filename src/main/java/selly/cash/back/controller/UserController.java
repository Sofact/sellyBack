package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.User;
import selly.cash.back.models.services.IUserService;

import java.util.Optional;

@CrossOrigin(origins={"http:localhost:4200"})
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/all/{id}")
    public Optional<User> search(@PathVariable Long id){

        return userService.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User create (@RequestBody User usuario){

        System.out.println("El nombre del usuario::::::"+usuario.getUsername());
        return userService.save(usuario);
    }
}
