package it.smartwater.be.repositories.utenti;

import it.smartwater.be.models.utenti.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UtentiRepository extends ListCrudRepository<Utente, Long> {

    List<Utente> getUtentesByEmail(String email);
    Page<Utente> getUtentesByNomeIsAndCognomeIs(String nome, String cognome, Pageable pageable);
    Page<Utente> getUtentesByEmailLikeIgnoreCase(String email, Pageable pageable);
    Page<Utente> getUtentesByTipoUtente_Id(int tipoUtente_id, Pageable pageable);
    Page<Utente> getUtentesByTipoUtente_Nome(String nome, Pageable pageable);
    Page<Utente> getUtentesByLuogoUtente_Provincia(String provincia, Pageable pageable);
    Page<Utente> getUtentesByLuogoUtente_Comune(String comune, Pageable pageable);


}
