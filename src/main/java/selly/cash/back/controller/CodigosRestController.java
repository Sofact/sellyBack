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

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins= "${myapp.datasource.url}")
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


        String text = "http://208.109.37.247/auth/loginCliente/" ;
        System.out.println("id en el save code:::"+ codigos.getCodId());
        Long cantidad=codigos.getCodId();
        Codigos cod = null;

        for (int x=0; x<cantidad; x++) {
            codigos.setCodId((long) x);
            codigos.setCodCodigo(generadorService.generar(codigos));
            codigos.setCodUrl(text+codigos.getCodCodigo());
            File f = new File("F:\\ANGULAR\\04-pipesApp\\src\\assets\\images\\"+codigos.getCodCodigo()+".png");
            System.out.println("Esta generando codigos::"+ codigos.getCodCodigo());
            generadorService.generarQR(f, codigos.getCodUrl(), 300, 300);

            cod= codigoService.save(codigos);
        }
        crearArchivo();


        return cod;
    }

    public void crearArchivo(){

        File archivoBatch = new File("src/main/resources/static/copy.bat");

        try {
            FileWriter escritorArchivo = new FileWriter(archivoBatch);
            BufferedWriter escritorBuffer = new BufferedWriter(escritorArchivo);

            escritorBuffer.write("COPY F:\\2023\\VITHALIA\\DESARROLLO\\BACKEND\\back\\src\\main\\resources\\static\\[B@4fe42bfc.png F:\\ANGULAR\\04-pipesApp\\src\\assets\\images");


            escritorBuffer.close();
            escritorArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ejecutarBat(){

        try {
            Process proceso = Runtime.getRuntime().exec("src/main/resources/static/copy.bat");

            // Espera a que el proceso termine antes de continuar
            proceso.waitFor();

            // Obtiene el código de salida del proceso
            int codigoSalida = proceso.exitValue();

            System.out.println("El archivo batch se ha ejecutado con éxito. Código de salida: " + codigoSalida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/update/{codCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Codigos update ( @PathVariable String codCodigo){

        String[] parts = codCodigo.split("codbearer");

        System.out.println("el parts::"+parts[0]);
        System.out.println("el partsother::"+parts[1]);
        String[] codigoPartir = parts[1].split("IDTOSPLIT");

        Codigos codigoActual = codigoService.findAllByCodCodigo("[B@"+parts[0]);

        saveComision(codigoActual.getProId(), Long.parseLong(codigoPartir[0]), Long.parseLong(codigoPartir[1]));
        codigoActual.setCodEstado("redimido");


        System.out.println("el usuario actual"+codigoActual.getUsuId());

        return codigoService.save(codigoActual);

    }

    public Comision saveComision (Long proId, Long usuId, Long cliId){

        System.out.println("El id del cliente"+ cliId);
        Producto product = productoService.findById(proId);
        java.util.Date fecha = new Date();

        Comision com = new Comision();

        com.setComEstado("pendiente");
        com.setComFecha(fecha);
        com.setComValor(product.getProValor());
        com.setUsuId(usuId);
        com.setProId(product.getProId());
        com.setCliId(cliId);

        return comisionService.save(com);

    }



}
