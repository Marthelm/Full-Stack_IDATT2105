package edu.ntnu.backend.controller;

import edu.ntnu.backend.model.Calculation;
import edu.ntnu.backend.model.CalculationMapper;
import edu.ntnu.backend.model.User;
import edu.ntnu.backend.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CalculationController {

    @Autowired
    CalculationRepository calculationRepository;

    @GetMapping("/calculations")
    public ResponseEntity<List<Calculation>> getAllCalculations(@RequestParam(required = false) String title){
        try {
            List<Calculation> calculations = new ArrayList<Calculation>();

            if (title == null) {
                calculations = calculationRepository.getAllCalculations();
            }
            if (calculations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(calculations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
