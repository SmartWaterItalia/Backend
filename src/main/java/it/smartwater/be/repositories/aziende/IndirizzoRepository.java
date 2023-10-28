package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.Indirizzo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

public interface IndirizzoRepository extends ListCrudRepository<Indirizzo, Long> {

    Indirizzo getIndirizzoByLuogo_IdAndViaAndCivicoAndSezione(@NotNull Long idLuogo, @NotNull String via, @NotNull String civico, @NotNull String sezione);

    boolean existsByLuogo_IdAndViaAndCivicoAndSezione(@NotNull Long idLuogo, @NotNull String via, @NotNull String civico, @NotNull String sezione);

}
