package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.InformazioniGenerali;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

public interface InformazioniGeneraliRepository extends ListCrudRepository<InformazioniGenerali, Long> {

    InformazioniGenerali getInformazioniGeneraliBySorgente_Id(Long idSorgente);
    Page<InformazioniGenerali> getInformazioniGeneralisByPotabilitàAndSorgente_LatitudineBetweenAndSorgente_LongitudineBetween(@NotNull boolean potabilità, @NotNull double latitudineMin, @NotNull double latitudineMax, @NotNull double longitudineMin, @NotNull  double longitudineMax, Pageable pageable);
    Page<InformazioniGenerali> getInformazioniGeneralisBySorgente_LatitudineBetweenAndSorgente_LongitudineBetween(@NotNull double latitudineMin, @NotNull double latitudineMax, @NotNull double longitudineMin, @NotNull  double longitudineMax, Pageable pageable);
}
