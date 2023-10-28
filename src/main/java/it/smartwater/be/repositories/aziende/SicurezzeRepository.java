package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.Sicurezza;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SicurezzeRepository extends ListCrudRepository<Sicurezza, Integer> {

    Sicurezza getSicurezzaByNomeIs(@NotNull String nome);
    List<Sicurezza> getSicurezzaByNomeContains(@NotNull String nome);

}
