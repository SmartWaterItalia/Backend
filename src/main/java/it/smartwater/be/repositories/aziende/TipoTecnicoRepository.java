package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.TipoTecnico;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TipoTecnicoRepository extends ListCrudRepository<TipoTecnico, Integer> {

    List<TipoTecnico> getTipoTecnicoByNomeContainsAndAzienda_Id(@NotNull String nome, @NotNull Long idAzienda);
    List<TipoTecnico> getTipoTecnicoByAzienda_Id(@NotNull Long idAzienda);

    boolean existsByNomeAndAzienda_Id(@NotNull String nome, @NotNull Long idAzienda);

    int countTipoTecnicosByAzienda_Id(@NotNull Long idAzienda);

}
