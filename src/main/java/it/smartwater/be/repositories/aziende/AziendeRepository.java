package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.Azienda;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AziendeRepository extends ListCrudRepository<Azienda, Long> {

    List<Azienda> getAziendasByContattiAzienda_Mail(@NotNull String email);
    List<Azienda> getAziendasByContattiAzienda_Telefono(@NotNull String telefono);
    List<Azienda> getAziendasByContattiAzienda_Fax(@NotNull String fax);

    List<Azienda> getAziendasByInformazioniAzienda_IdIndirizzo(@NotNull Long idIndirizzo);
    List<Azienda> getAziendasByInformazioniAzienda_RagioneSociale(@NotNull String ragioneSociale);
    List<Azienda> getAziendasByInformazioniAzienda_PartitaIva(@NotNull String partitaIva);
}
