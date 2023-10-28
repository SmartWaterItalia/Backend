package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.Installazione;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface InstallazioniRepository extends ListCrudRepository<Installazione, Long> {

    Installazione getInstallazioneBySorgente_Id(@NotNull Long id);
    Installazione getInstallazioneByLuogo_Id(@NotNull Long id);
    List<Installazione> getInstallazioneByLuogo_Provincia(@NotNull String provincia);
    Page<Installazione> getInstallazioneByLuogo_Comune(@NotNull String comune, Pageable pageable);
    Page<Installazione> getInstallazioneByLuogo_Regione(@NotNull String regione, Pageable pageable);

}
