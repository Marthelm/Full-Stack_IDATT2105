package edu.ntnu.backend.repository;

import edu.ntnu.backend.model.Calculation;

import java.util.List;

public interface CalculationRepository {
    int save(Calculation calculation);
    List<Calculation> findAll();
    List<Calculation> findAllByUserName();



}
