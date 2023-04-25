package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import selly.cash.back.models.entity.Parametros;
import selly.cash.back.models.services.IParametroService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= {"${myapp.datasource.url}"})
@RestController
@RequestMapping("/parametros")
public class ParametrosRestController {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

    @Autowired
    private IParametroService parametroService;

    @GetMapping ("/taxes")
    public List<Parametros> index(){

        return parametroService.findAll();
    }

    @GetMapping ("/taxes/{id}")
    public Parametros show(@PathVariable Long id){

        return  parametroService.findById(id);
    }
    @PostMapping("/saveParams")
    @ResponseStatus(HttpStatus.CREATED)
    public Parametros create(@RequestBody Parametros parametro){


        return parametroService.save(parametro);
    }
    @DeleteMapping("/deleteParams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){

        parametroService.deleteById(id);
    }

    @PutMapping("/taxes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Parametros update( @RequestBody Parametros parametros, @PathVariable Long id){

        Parametros parametroActual = parametroService.findById(id);

        parametroActual.setparDescripcion(parametros.getparDescripcion());
        parametroActual.setParValor(parametros.getParValor());

        return parametroService.save(parametroActual);
    }


}
