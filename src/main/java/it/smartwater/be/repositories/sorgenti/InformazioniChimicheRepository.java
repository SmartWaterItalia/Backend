package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.InformazioniChimiche;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

public interface InformazioniChimicheRepository extends ListCrudRepository<InformazioniChimiche, Long> {

    InformazioniChimiche getInformazioniChimicheBySorgente_Id(Long idSorgente);

    Page<InformazioniChimiche> getInformazioniChimichesBySorgente_LatitudineBetweenAndSorgente_LongitudineBetween(@NotNull double latitudineMin, @NotNull double latitudineMax, @NotNull double longitudineMin, @NotNull double longitudineMax, Pageable pageable);

}
