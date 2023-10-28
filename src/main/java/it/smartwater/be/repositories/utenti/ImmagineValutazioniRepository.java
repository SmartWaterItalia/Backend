package it.smartwater.be.repositories.utenti;

import it.smartwater.be.models.utenti.ImmagineValutazione;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ImmagineValutazioniRepository extends ListCrudRepository<ImmagineValutazione, Long> {

    List<ImmagineValutazione> getImmagineValutazionesByIdValutazioneIs(@NotNull Long idValutazione);

}
