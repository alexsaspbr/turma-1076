package tech.ada.locadoraveiculos.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.locadoraveiculos.model.Veiculo;
import tech.ada.locadoraveiculos.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo criarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return this.veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoPorId(Long id) {
        return null;
    }

}
