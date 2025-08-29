package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Permite de qualquer origem
public class CalculatorController {

    @Autowired
    private CalculatorService helloServiceClient;

    @GetMapping("/")
    public double calculate(@RequestParam double valor1,
                            @RequestParam double valor2,
                            @RequestParam String operacao) {
        return helloServiceClient.callRemoteService(valor1, valor2, operacao);
    }
}
