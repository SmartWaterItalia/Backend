package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.UtenteTecnico;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

public interface UtentiTecnicoRepository extends ListCrudRepository<UtenteTecnico, Long> {

    Page<UtenteTecnico> getUtenteTecnicoByAzienda_Id(@NotNull Long idAzienda, Pageable pageable);
    Page<UtenteTecnico> getUtenteTecnicoByIdUtente(@NotNull Long idUtente, @NotNull String nome, Pageable pageable);

    int countUtenteTecnicoByAzienda_Id(@NotNull Long idAzienda);
    int countUtenteTecnicoByIdUtente(@NotNull Long idUtente);

}
