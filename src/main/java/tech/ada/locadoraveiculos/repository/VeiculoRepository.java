package tech.ada.locadoraveiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.locadoraveiculos.model.Veiculo;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Veiculo findByPlaca(String placa);

    //Optional<Veiculo> findByPlacaOp(String placa);

    //veiculo pela placa e tambem marca
    Optional<Veiculo> findByPlacaAndMarca(String placa, String marca);

    List<Veiculo> findByModeloAndMarca(String modelo, String marca);

    //@Query(value = "select v from veiculo v where v.placa = :placa", nativeQuery = false)
    //@Query(value = "select v from tb_veiculo v where v.placa = :placa", nativeQuery = true)
    //Veiculo findByPlaca2(@Param("placa") String placa);

}
