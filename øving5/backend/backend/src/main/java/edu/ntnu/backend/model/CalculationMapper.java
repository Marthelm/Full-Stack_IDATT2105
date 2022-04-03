package edu.ntnu.backend.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculationMapper implements RowMapper<Calculation> {
    @Override
    public Calculation mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("this far");
        Calculation calculation = new Calculation();
        calculation.setId(rs.getInt("id"));
        calculation.setNum1(rs.getDouble("num1"));
        calculation.setNum2(rs.getDouble("num2"));
        calculation.setOp(rs.getString("op").charAt(0));
        calculation.setSol(rs.getDouble("sol"));
        calculation.setUsername(rs.getString("user"));
        return calculation;
    }
}
