package it.smartwater.be.repositories.utenti;

import it.smartwater.be.models.utenti.ImmagineValutazione;
import it.smartwater.be.models.utenti.Valutazione;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Date;

public interface ValutazioniRepository extends ListCrudRepository<Valutazione, Long> {

    Page<Valutazione> getValutazionesByUtente_Id(@NotNull Long utente_id, Pageable pageable);
    Page<Valutazione> getValutazionesByIdSorgente(@NotNull Long idSorgente, Pageable pageable);
    Page<Valutazione> getValutazionesByIdSorgenteAndUtente_Id(@NotNull Long idSorgente, @NotNull Long utente_id, Pageable pageable);
    Page<Valutazione> getValutazionesByIdSorgenteAndDataBetween(@NotNull Long idSorgente, @NotNull Date dataInizio, @NotNull Date dataFine, Pageable pageable);
    int countValutazionesByIdSorgente(@NotNull Long idSorgente);
    int countValutazionesByIdSorgenteAndDataBetween(@NotNull Long idSorgente, @NotNull Date dataInizio, @NotNull Date dataFine);
    int countValutazionesByUtente_Id(@NotNull Long utente_id);
    int countValutazionesByUtente_IdAndDataBetween(@NotNull Long utente_id, @NotNull Date data, @NotNull Date data2);
    Page<Valutazione> getValutazionesByVotoGreaterThanEqual(int voto, Pageable pageable);
    Page<Valutazione> getValutazionesByVotoLessThanEqual(int voto, Pageable pageable);
    Page<Valutazione> getValutazionesByVotoGreaterThanEqualAndVotoLessThanEqual(int votoMin, int votoMax, Pageable pageable);
    int countValutazionesByVotoGreaterThanEqual(int voto);
    int countValutazionesByVotoLessThanEqual(int voto);

}
