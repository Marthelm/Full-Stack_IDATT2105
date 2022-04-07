package edu.ntnu.backend.controller;

import edu.ntnu.backend.model.Calculation;
import edu.ntnu.backend.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
public class CalculationController {

    @Autowired
    CalculationRepository calculationRepository;


    @GetMapping("/calculations/{username}")
    public ResponseEntity<List<Calculation>> getCalculationsByUsername(@PathVariable("username") String username) {
        try {
            List<Calculation> calculations = calculationRepository.findAllByUsername(username);
            if (calculations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(calculations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/calculations")
    public ResponseEntity<String> createCalculation(@RequestBody Calculation calculation) {
        try {
            calculationRepository.save(new Calculation(calculation.getNum1(),calculation.getNum2(),calculation.getOp(),calculation.getSol(),calculation.getUsername()));
            return new ResponseEntity<>("Calculation was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
