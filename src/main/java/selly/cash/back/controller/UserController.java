package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.User;
import selly.cash.back.models.services.IUserService;
import selly.cash.back.utilities.ConsultaSQL;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ConsultaSQL consulta;



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
    @GetMapping("/allusers")
    public List<Map<String, Object>> search(){


        String query = " select user_email, \n" +
                "user_name,  \n" +
                "sum(c.com_valor) AS sum \n" +
                "from sc.users u left join sc.comision c\n" +
                "on u.user_id = c.usu_id\n" +
                " GROUP BY  user_email, user_name";
        System.out.println("Consulta:::"+consulta.ejecutarConsulta(query));
        return  consulta.ejecutarConsulta(query);
    }
}
