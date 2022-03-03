package edu.ntnu.assignment4.controller;

import edu.ntnu.assignment4.service.Calculation;
import edu.ntnu.assignment4.model.Equation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    Calculation service;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "bootemp") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/calculation/all")
    public List<String> getCalculations(){
        logger.info("All calculations returned");
        return service.getCalculations();
    }

    @GetMapping("/calculation")
    public String getAnwser(){
        logger.info("Last answer returned");
        return service.getCalculations().get(service.getCalculations().size() -1 );
    }

    @PostMapping("/calculation")
    public Equation postCalculation(@RequestBody Equation equation){
        try{
            double sol = service.calculate(equation.getNum1(),equation.getNum2(),equation.getOp());
            equation.setSolution(sol);
            service.getCalculations().add(equation.toString());
            logger.info("Calculation Added");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return equation;
    }
}
