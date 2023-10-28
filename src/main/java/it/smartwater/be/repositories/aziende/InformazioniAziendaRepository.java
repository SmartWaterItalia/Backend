package it.smartwater.be.repositories.aziende;

import it.smartwater.be.models.aziende.InformazioniAzienda;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface InformazioniAziendaRepository extends ListCrudRepository<InformazioniAzienda, Long> {

    List<InformazioniAzienda> getInformazioniAziendaByRagioneSociale(@NotNull String ragioneSociale);
    InformazioniAzienda getInformazioniAziendaByIndirizzo_Id(@NotNull Long id);
    List<InformazioniAzienda> getInformazioniAziendaByPartitaIva(@NotNull String partitaIva);
    Page<InformazioniAzienda> getInformazioniAziendaByNomeContains(@NotNull String nome, Pageable pageable);

    boolean existsByRagioneSocialeAndPartitaIvaAndIndirizzo_Id(@NotNull String ragioneSociale, @NotNull String partitaIva, @NotNull Long idIndirizzo);

}
