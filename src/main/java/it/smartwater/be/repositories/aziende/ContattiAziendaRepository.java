package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.ContattiAzienda;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContattiAziendaRepository extends ListCrudRepository<ContattiAzienda, Long> {

    List<ContattiAziendaRepository> getContattiAziendasByMail(@NotNull String mail);
    List<ContattiAziendaRepository> getContattiAziendasByTelefono(@NotNull String telefono);
    List<ContattiAziendaRepository> getContattiAziendasByFax(@NotNull String fax);

    boolean existsByMailAndFaxAndWebsiteAndTelefono(@NotNull String mail, @NotNull String fax, @NotNull String website, @NotNull String telefono);

}
