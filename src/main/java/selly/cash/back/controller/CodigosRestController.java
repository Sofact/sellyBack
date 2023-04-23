package selly.cash.back.controller;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import selly.cash.back.models.entity.*;
import selly.cash.back.models.services.ICodigosService;
import selly.cash.back.models.services.IComisionService;
import selly.cash.back.models.services.IGeneradorService;
import selly.cash.back.models.services.IProductoService;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.io.File;

@CrossOrigin(origins= "http://208.109.37.247")
@RestController
@RequestMapping("/codigos")
public class CodigosRestController {

    @Bean
    public WebMvcConfigurer corsConfigurerCodigo() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS");
            }
        };
    }

    @Autowired
    private ICodigosService codigoService;
    @Autowired
    private IGeneradorService generadorService;

    @Autowired
    private IComisionService comisionService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private CrossOriginConfig cof;





    @GetMapping("/all")
    @Transactional(readOnly = true)
    public List<Codigos> index(){

        return codigoService.findAll();
    }

    @GetMapping ("/code/{id}")
    public Codigos show(@PathVariable Long id){

        System.out.println("Codigos/all");

        return null;// codigoService.findById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Codigos crear(@RequestBody Codigos codigos) throws NoSuchAlgorithmException, IOException, WriterException {


        String text = "http://208.109.37.247/registro?code=" ;
        System.out.println("id en el save code:::"+ codigos.getCodId());
        Long cantidad=codigos.getCodId();
        Codigos cod = null;

        for (int x=0; x<cantidad; x++) {
            codigos.setCodId((long) x);
            codigos.setCodCodigo(generadorService.generar(codigos));
            codigos.setCodUrl(text+codigos.getCodCodigo());
            File f = new File("src/main/resources/static/"+codigos.getCodCodigo()+".png");
            System.out.println("Esta generando codigos::"+ codigos.getCodCodigo());
            generadorService.generarQR(f, codigos.getCodUrl(), 300, 300);

            cod= codigoService.save(codigos);
        }
        return cod;
    }

    @PutMapping("/update/{codCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Codigos update ( @PathVariable String codCodigo){

        String[] parts = codCodigo.split("codbearer");

        System.out.println("el parts::"+parts[0]);
        System.out.println("el partsother::"+parts[1]);

        Codigos codigoActual = codigoService.findAllByCodCodigo("[B@"+parts[0]);

        saveComision(codigoActual.getProId(), Long.parseLong(parts[1]));
        codigoActual.setCodEstado("redimido");


        System.out.println("el usuario actual"+codigoActual.getUsuId());

        return codigoService.save(codigoActual);

    }

    public Comision saveComision (Long proId, Long usuId){

        Producto product = productoService.findById(proId);
        java.util.Date fecha = new Date();
        Long id = 1L;

        Comision com = new Comision();

        com.setComEstado("pendiente");
        com.setComFecha(fecha);
        com.setComValor(product.getProValor());
        com.setUsuId(usuId);
        com.setProId(product.getProId());
        com.setCliId(id);

        return comisionService.save(com);

    }



}
