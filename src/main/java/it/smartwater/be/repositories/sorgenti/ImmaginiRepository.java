package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.Immagine;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ImmaginiRepository extends ListCrudRepository<Immagine, Long> {

    List<Immagine> getImmaginesByIdSorgenteIs(@NotNull Long idSorgente);

}
