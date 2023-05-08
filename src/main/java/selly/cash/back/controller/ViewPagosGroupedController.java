package selly.cash.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import selly.cash.back.models.entity.ViewPagosGrouped;
import selly.cash.back.models.services.IViewPagosGroupedService;
import selly.cash.back.utilities.ConsultaSQL;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins={"${myapp.datasource.url}"})
@RestController
@RequestMapping("/pagosGroup")
public class ViewPagosGroupedController {

    @Autowired
    private IViewPagosGroupedService viewPagosGroupedService;

    @Autowired
    private ConsultaSQL consulta;

    @GetMapping("/all")
    public List<ViewPagosGrouped> search(){

        return(List<ViewPagosGrouped>) viewPagosGroupedService.findall();
    }
    @GetMapping("/all/{estado}")
    public List<ViewPagosGrouped> searchByEstado(@PathVariable String estado){

        System.out.println("Pagos group:::"+estado);
        return(List<ViewPagosGrouped>) viewPagosGroupedService.findViewPagosGroupedByConvEstado(estado);
    }

    @GetMapping("/all/fecha/{date}")
    public List<Map<String, Object>> searchByFecha(@PathVariable String date){

        String fechaFiltro = date;

        System.out.println("El date::"+fechaFiltro);

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
                "   WHERE c.com_fecha <= '"+ fechaFiltro +"'"+
                "   and c.com_estado = 'pendiente'\n" +
                "  GROUP BY c.usu_id, c.com_estado, u.user_name, u.user_email, u.cli_banco, u.cli_num_cuenta, u.cli_tipo_cuenta, co.cov_nombre,  co.cov_id;";
        System.out.println("Consulta:::"+consulta.ejecutarConsulta(query));
        return  consulta.ejecutarConsulta(query);
    }

}
