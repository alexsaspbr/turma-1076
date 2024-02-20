package tech.ada.locadoraveiculos.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.locadoraveiculos.model.Veiculo;
import tech.ada.locadoraveiculos.repository.VeiculoRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

        Optional<Veiculo> optionalVeiculo = this.veiculoRepository.findById(id);
        if(optionalVeiculo.isPresent()) {
            return optionalVeiculo.get();
        } else {
            return null;
        }

    }


    public Veiculo alterarVeiculo(Veiculo veiculo) {

        Veiculo veiculoBD = this.buscarVeiculoPorId(veiculo.getId());

        Veiculo veiculoAlterado = new Veiculo();
        veiculoAlterado.setId(veiculoBD.getId());
        veiculoAlterado.setPlaca(veiculo.getPlaca());
        veiculoAlterado.setMarca(veiculo.getMarca());
        veiculoAlterado.setModelo(veiculo.getModelo());
        veiculoAlterado.setTipo(veiculo.getTipo());
        veiculoAlterado.setDisponivel(veiculo.getDisponivel());

        return this.veiculoRepository.save(veiculoAlterado);

    }

    public void deletarVeiculo(Long id) {

    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        try {
            Veiculo veiculo = this.veiculoRepository.findByPlaca(placa);
            if(Objects.nonNull(veiculo))
                return veiculo;
            else
                throw new RuntimeException(String.format("Nenhum veiculo encontrado para a placa %s", placa));
        } catch (Exception e) {
            throw e;
        }
    }

    public void deletarVeiculo(String placa) {
        try {
            Veiculo veiculo = this.buscarVeiculoPorPlaca(placa);
            this.veiculoRepository.delete(veiculo);
        } catch(Exception e) {
            throw e;
        }
        //this.veiculoRepository.findByPlacaOp(placa).ifPresent(veiculoRepository::delete);
    }

}
