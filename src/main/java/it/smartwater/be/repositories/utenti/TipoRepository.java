package it.smartwater.be.repositories.utenti;

import it.smartwater.be.models.utenti.Tipo;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;

public interface TipoRepository extends CrudRepository<Tipo, Integer> {

    Tipo getTipoByNome(@NotNull String nome);

}
