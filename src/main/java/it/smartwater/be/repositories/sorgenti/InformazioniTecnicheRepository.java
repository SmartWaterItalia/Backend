package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.InformazioniTecniche;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

public interface InformazioniTecnicheRepository extends ListCrudRepository<InformazioniTecniche, Long> {

    Page<InformazioniTecniche> getInformazioniTecnichesBySorgente_Id(@NotNull Long idSorgente);
    Page<InformazioniTecniche> getInformazioniTecnichesBySorgente_LatitudineBetweenAndSorgente_LongitudineBetween(@NotNull double latitudineMin, @NotNull double latitudineMax, @NotNull double longitudineMin, @NotNull double longitudineMax, Pageable pageable);

}
