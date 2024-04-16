package com.carro.repositoryJDBC;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.carro.model.Carro;
import com.carro.repository.CarroRepository;
import com.carro.repository.jdbc.CarroRowMapper;

@Repository
public class CarroRepositoryJDBC implements CarroRepository {
    private final JdbcTemplate jdbcTemplate;

    public CarroRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Carro> findAll() {
        String sql = "SELECT * FROM Entrada";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Carro carro = new Carro(rs.getString("nome"), 
                                    rs.getString("fabricante"), 
                                    rs.getString("placa"), 
                                    rs.getTimestamp("dataEntrada"),
                                    rs.getLong("id"));    
            return carro;
        });
    }

    @Override
    public Carro findById(Long id) {
        String sql = "SELECT * FROM entrada WHERE id = ?";
        @SuppressWarnings("deprecation")
        Carro carro = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CarroRowMapper());

        return carro;
    }

    @Override
    public void save(Carro carro) {
        String sql = "INSERT INTO Entrada (nome, fabricante, placa) VALUE (?, ?, ?)";
        jdbcTemplate.update(sql, carro.getNome(), carro.getFabricante(), carro.getPlaca());
    }

    @Override
    public void update(Long id, Carro carro) {
        String sql = "UPDATE entrada SET nome = ?, fabricante = ?, placa = ? WHERE id = ?";
        jdbcTemplate.update(sql, carro.getNome(), carro.getFabricante(), carro.getPlaca(), id);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM entrada WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    
}
