package edu.ntnu.backend.repository;

import edu.ntnu.backend.model.Calculation;
import edu.ntnu.backend.model.CalculationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCalculationRepository implements CalculationRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Calculation calculation) {
        return jdbcTemplate.update("INSERT INTO calculation (num1,num2,op,sol,user) VALUES(?,?,?,?,?)",
                new Object[] {calculation.getNum1(),calculation.getNum2(),calculation.getOp(),calculation.getSol(),calculation.getUsername() });
    }

    @Override
    public List<Calculation> getAllCalculations() {
        String SQL = "select * from calculation";
        return jdbcTemplate.query(SQL,new CalculationMapper());
    }

    @Override
    public List<Calculation> findAllByUsername(String username) {
        try {
            String SQL = "SELECT * FROM calculation WHERE user= '" + username + "'";
            return jdbcTemplate.query(SQL, new CalculationMapper());
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
