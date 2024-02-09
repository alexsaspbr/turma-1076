package tech.ada.locadoraveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.locadoraveiculos.model.Veiculo;
import tech.ada.locadoraveiculos.service.VeiculoService;

@RestController //para API REST
//@Controller     //para MVC
@RequestMapping("/veiculo")
public class VeiculoRestController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/criar")
    public String criarVeiculo(@RequestBody Veiculo veiculo) {

        this.veiculoService.criarVeiculo(veiculo);

        return String.format("Veiculo com placa %s, criado com sucesso!", veiculo.getPlaca());
    }

}
