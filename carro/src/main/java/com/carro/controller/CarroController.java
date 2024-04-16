package com.carro.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.carro.model.Carro;
import com.carro.repository.CarroRepository;
import com.carro.util.ValidaPlaca;

@Controller
public class CarroController {
    
    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PostMapping("/entrada")
    public String EntradaCarro(@RequestParam("nome") String nome, 
        @RequestParam("fabricante") String fabricante,
        @RequestParam("placa") String placa, Model m) {

            String resultado = "Ops, a placa não é válida!";

            m.addAttribute("carro", resultado);

            if(ValidaPlaca.validar(placa)){
                Carro carro = new Carro(nome, fabricante, placa, null, null);
                carroRepository.save(carro);
                
                resultado = "Carro modelo " + carro.getNome() + " cadastrado com sucesso!";
                
                return "redirect:/carro";

            }else{ // não válido
                return "sucesso_carro";
            }
        };
    
    @GetMapping("/carro")
    public String ListCarroAll(Model m) {

        List<Carro> carros = carroRepository.findAll();
        m.addAttribute("carros", carros);

        return "lista_carros";
    }

    @GetMapping("/carro/{id}")
    public String mostrarCarro(@PathVariable Long id, Model model) {
        Carro carro = carroRepository.findById(id);
        model.addAttribute("carro", carro);

        return "carro_editar";
    }

    @PostMapping("/carro_editar")
    public String atualizarCarro(@ModelAttribute Carro carro) {
        carroRepository.update(carro.getId(), carro);
        return "redirect:/carro";
    }

    @GetMapping("/carro/deletar/{id}")
    public String deletarCarro(@PathVariable Long id) {
        carroRepository.delete(id);
        return "redirect:/carro";
    }

}
