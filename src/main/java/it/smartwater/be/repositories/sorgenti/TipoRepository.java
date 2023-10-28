package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.Tipo;
import org.springframework.data.repository.CrudRepository;

public interface TipoRepository extends CrudRepository<Tipo, Integer> {

    Tipo getTipoByNome(String nome);

}
