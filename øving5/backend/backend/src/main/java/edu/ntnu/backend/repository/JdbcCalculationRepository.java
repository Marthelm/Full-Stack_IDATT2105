package edu.ntnu.backend.repository;

import edu.ntnu.backend.model.Calculation;

import java.util.List;

public class JdbcCalculationRepository implements CalculationRepository{
    @Override
    public int save(Calculation calculation) {
        return 0;
    }

    @Override
    public List<Calculation> findAll() {
        return null;
    }

    @Override
    public List<Calculation> findAllByUserName() {
        return null;
    }
}
