package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import selly.cash.back.models.entity.Marcas;
import selly.cash.back.models.entity.Parametros;
import selly.cash.back.models.services.IMarcasService;
import java.util.List;


@CrossOrigin(origins= {"${myapp.datasource.url}"})
@RestController
@RequestMapping("/marcas")
public class MarcaRestController {

    /*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }
*/
    @Autowired
    private IMarcasService marcasService;

    @GetMapping("/all")
    public List<Marcas> index(){

        return marcasService.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Marcas crear(@RequestBody Marcas marcas){

        return marcasService.save(marcas);
    }

}
