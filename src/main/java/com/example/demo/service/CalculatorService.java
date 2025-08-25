package com.example.demo.service;

import com.example.demo.corba.Calculadora;
import com.example.demo.corba.CalculadoraHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private ORB orb;

    @Value("${corba.service.url}")
    private String corbaServiceUrl;

    @Value("${corba.service.name}")
    private String corbaServiceName;

    public double callRemoteService(double valor1, double valor2, String operacao) {
        try {
            // Obtenha a referência do serviço a partir do URL CORBA
            org.omg.CORBA.Object obj = orb.string_to_object(corbaServiceUrl);

            // Use o serviço de nomes se necessário
            NamingContextExt ncRef = NamingContextExtHelper.narrow(obj);
            obj = ncRef.resolve_str("Calculadora");

            //Converta para o tipo específico do serviço
            Calculadora calc = CalculadoraHelper.narrow(obj);

            // Chame o método remoto
            return calc.calculate(valor1, valor2, operacao);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao chamar serviço CORBA", e);
        }
    }
}