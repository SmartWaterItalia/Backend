package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.PermessoTecnico;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PermessiTecnicoRepository extends ListCrudRepository<PermessoTecnico, Long> {

    List<PermessoTecnico> getPermessoTecnicoByTipoTecnico_Id(@NotNull Integer idTipoTecnico);


}
