package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.Manutenzione;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Date;
import java.util.List;

public interface ManutenzioneRepository extends ListCrudRepository<Manutenzione, Long> {

    Page<Manutenzione> getManutenzionesByDataBetweenAndUtenteTecnico_Azienda_Id(@NotNull Date dataInizio, @NotNull Date dataFine, @NotNull Long idAzienda, Pageable pageable);
    Page<Manutenzione> getManutenzionesByDataBetween(@NotNull Date dataInizio, @NotNull Date dataFine, Pageable pageable);
    Page<Manutenzione> getManutenzionesByUtenteTecnico_Id(@NotNull Long idUtenteTecnico, Pageable pageable);

}
