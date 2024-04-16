package com.carro.repository.jdbc;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.carro.model.Carro;

public class CarroRowMapper implements RowMapper<Carro> {
    @Override
    public Carro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Carro carro = new Carro(rs.getString("nome"), 
        rs.getString("fabricante"),
        rs.getString("placa"), 
        null, 
        rs.getLong("id"));
        return carro;
    }
}
