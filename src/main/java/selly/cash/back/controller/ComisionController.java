package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.Comision;
import selly.cash.back.models.services.IClienteService;
import selly.cash.back.models.services.IComisionService;
import selly.cash.back.utilities.ConsultaSQL;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/comision")
public class ComisionController {

    @Autowired
    private IComisionService comisionService;

    @Autowired
    private ConsultaSQL consulta;


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Comision create (@RequestBody Comision comision){

        System.out.println("El nombre del cliente en save::::::"+comision.getComEstado());
        return comisionService.save(comision);
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public void test(){
        System.out.println("test");
    }
    @PostMapping("/update/{nombre}/{fecha}")
    @ResponseStatus(HttpStatus.CREATED)
    public  void update (@PathVariable String nombre, @PathVariable String fecha){

        System.out.println("El nombre del cliente::::::"+nombre+" fecha::"+ fecha);
        String query = "update sc.comision\n" +
                        "set com_estado = 'pagado'\n" +
                        "where com_id in (\n" +
                        "Select com_id\n" +
                        "from sc.comision c  inner join \n" +
                        "sc.users u\n" +
                        "on c.usu_id = u.user_id \n" +
                        "where u.user_name = '"+ nombre +
                        "' and c.com_fecha <= '"+  fecha +" 23:59:59.496')";

        consulta.ejecutarActualizacion(query);
        System.out.println("El resultado::");
     //   return resultado;// comisionService.save(comision);
    }
}
