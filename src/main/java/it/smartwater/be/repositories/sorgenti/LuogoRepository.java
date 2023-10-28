package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.Luogo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface LuogoRepository extends CrudRepository<Luogo, Long> {

    Page<Luogo> getLuogosByProvincia(@NotNull String provincia, Pageable pageable);
    Page<Luogo> getLuogosByRegione(@NotNull String regione, Pageable pageable);


    boolean existsByStatoAndRegioneAndProvinciaAndComuneAndPostale(@NotNull String stato, @NotNull String regione, @NotNull String provincia, @NotNull String comune, @NotNull String postale);

}
