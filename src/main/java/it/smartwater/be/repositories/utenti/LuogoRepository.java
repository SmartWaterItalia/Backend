package it.smartwater.be.repositories.utenti;

import it.smartwater.be.models.utenti.Luogo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LuogoRepository extends CrudRepository<Luogo, Long> {

    Page<Luogo> getLuogosByProvincia(@NotNull String provincia, Pageable pageable);
    Page<Luogo>getLuogosByRegione(@NotNull String regione, Pageable pageable);

    boolean existsByStatoAndRegioneAndProvinciaAndComuneAndPostale(@NotNull String stato, @NotNull String regione, @NotNull String provincia, @NotNull String comune, @NotNull String postale);

}
