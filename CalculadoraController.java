package br.edu.usj.calculadora.calculadoralul;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalculadoraController {

    Historico hist = new Historico();
        
    @PostMapping(value="/calcula")
    public ModelAndView postCalcula(@RequestParam String numero1, @RequestParam String numero2, @RequestParam String operador) {
        
        ModelAndView modelAndView = new ModelAndView("index");
        Double total = 0.0;

        switch (operador) {
            case "+":
                total = Double.parseDouble(numero1) + Double.parseDouble(numero2);
                break;
            case "-":
                total = Double.parseDouble(numero1) - Double.parseDouble(numero2);
                break;
            case "x":
                total = Double.parseDouble(numero1) * Double.parseDouble(numero2);
                break;
            case "/":
                total = Double.parseDouble(numero1) / Double.parseDouble(numero2);
                break;
        }

        String resultado = "O resultado é: " + total;
        String operacao = numero1 + operador + numero2 + "=" + total;
        modelAndView.addObject("mensagem", resultado);
        hist.add(operacao);
        modelAndView.addObject("historico", hist.lerLista());
        return modelAndView;
    }
    
}