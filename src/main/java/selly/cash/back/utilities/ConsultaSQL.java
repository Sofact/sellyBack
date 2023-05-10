package selly.cash.back.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import selly.cash.back.models.entity.Convenio;

import java.util.List;
import java.util.Map;

@Component
public class ConsultaSQL {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> ejecutarConsulta(String query) {
        String sql = query ;//"SELECT * FROM sc.convenio";
        List<Map<String, Object>> resultado = jdbcTemplate.queryForList(sql);

        return resultado;

    }

    public List<Map<String, Object>> ejecutarActualizacion(String query) {
        String sql = query ;//"SELECT * FROM sc.convenio";
         jdbcTemplate.update(sql);

        return null;

    }
}