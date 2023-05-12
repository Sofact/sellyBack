package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.Clientes;
import selly.cash.back.models.entity.ViewComision;
import selly.cash.back.models.services.IViewComisionService;
import selly.cash.back.utilities.ConsultaSQL;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping( "/viewComision")
public class ViewComisionController {

    @Autowired
    private IViewComisionService comisionService;

    @Autowired
    private ConsultaSQL consulta;

    @GetMapping("/all")
    public List <ViewComision> index(){

        return comisionService.findAll();
    }

    @GetMapping("/estado/{estado}")
    public List <ViewComision> estado(@PathVariable String estado){

        return comisionService.findAllByEstado(estado);
    }
    @GetMapping("/estado/{estado}/{usuId}")
    public List<Map<String, Object>> estadoId(@PathVariable String estado, @PathVariable String usuId){

        System.out.println("El date::"+estado+ usuId);

        String query = " SELECT c.usu_id,\n" +
                "      c.com_estado,\n" +
                "    u.user_email,\n" +
                "    u.user_name,\n" +
                "    u.cli_banco,\n" +
                "    u.cli_num_cuenta,\n" +
                "    u.cli_tipo_cuenta,\n" +
                "    co.cov_nombre,\n" +
                "    co.cov_id,\n" +
                "    sum(c.com_valor) AS sum\n" +
                "   FROM sc.comision c\n" +
                "     JOIN sc.users u ON c.usu_id = u.user_id\n" +
                "     JOIN sc.convenio co ON u.conv_id = co.cov_id\n" +
                "   WHERE  c.com_estado = '"+ estado + "' and c.usu_id =" + usuId+
                "  GROUP BY c.usu_id, c.com_estado, u.user_name, u.user_email, u.cli_banco, u.cli_num_cuenta, u.cli_tipo_cuenta, co.cov_nombre,  co.cov_id;";
        System.out.println("Consulta:::"+consulta.ejecutarConsulta(query));
        return  consulta.ejecutarConsulta(query);
    }

    @GetMapping("/totalEstado/{estado}/{usuId}")
    public float totalEstado(@PathVariable String estado, @PathVariable Long usuId){

        System.out.println("El user::"+ usuId);
        float total = 0;
       List <ViewComision>  comisiones= comisionService.findAllByEstado(estado);

        for(ViewComision comision: comisiones){

            if(comision.getUsuId() == usuId)
             total += comision.getComValor();

        }

        System.out.println("El total:::"+ total);
        return total;
    }

    @GetMapping("/totalEstado/{estado}")
    public float totalEstadoSolo(@PathVariable String estado) {


        float total = 0;
        List<ViewComision> comisiones = comisionService.findAllByEstado(estado);

        for (ViewComision comision : comisiones) {


            total += comision.getComValor();


            System.out.println("El total:::" + total);

        }
        return total;
    }

    @GetMapping("/lastComision/{usuId}")
    public ViewComision getLastComision(@PathVariable String usuId){

        ViewComision viewComision = comisionService.findTopByUsuIdOrderByComIdDesc(usuId);
        return viewComision;
    }

}
