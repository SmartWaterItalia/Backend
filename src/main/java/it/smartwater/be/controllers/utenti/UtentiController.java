package it.smartwater.be.controllers.utenti;

import it.smartwater.be.controllers.ListCrudController;
import it.smartwater.be.models.utenti.Utente;
import it.smartwater.be.repositories.utenti.UtentiRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtentiController extends ListCrudController<Utente, Long> {

    private final String ROOT = "/utenti";
    private final UtentiRepository utentiRepository;

    public UtentiController(UtentiRepository utentiRepository) {
        super(utentiRepository);
        this.utentiRepository = utentiRepository;
    }

    @GetMapping(ROOT + "/getUtentiByEmail/{email}")
    public List<Utente> getUtentesByEmail(@PathVariable String email) {
        return utentiRepository.getUtentesByEmail(email);
    }

    @GetMapping(ROOT + "/getUtentiByNomeAndCognome/{nome}/{cognome}/{pageable}")
    public Page<Utente> getUtentesByNomeIsAndCognomeIs(@PathVariable String nome, @PathVariable String cognome, @PathVariable Pageable pageable) {
        return utentiRepository.getUtentesByNomeIsAndCognomeIs(nome, cognome, pageable);
    }

    @GetMapping(ROOT + "/getUtentiByEmailLike/{email}/{pageable}")
    public Page<Utente> getUtentesByEmailLikeIgnoreCase(@PathVariable String email, @PathVariable Pageable pageable) {
        return utentiRepository.getUtentesByEmailLikeIgnoreCase(email, pageable);
    }

    @GetMapping(ROOT + "/getUtentiByTipoUtenteId/{tipoUtente_id}/{pageable}")
    public Page<Utente> getUtentesByTipoUtente_Id(@PathVariable int tipoUtente_id, @PathVariable Pageable pageable) {
        return utentiRepository.getUtentesByTipoUtente_Id(tipoUtente_id, pageable);
    }

    @GetMapping(ROOT + "/getUtentiByTipoUtenteNome/{nome}/{pageable}")
    public Page<Utente> getUtentesByTipoUtente_Nome(@PathVariable String nome, @PathVariable Pageable pageable) {
        return utentiRepository.getUtentesByTipoUtente_Nome(nome, pageable);
    }

    @GetMapping(ROOT + "/getUtentiByLuogoUtenteProvincia/{provincia}/{pageable}")
    public Page<Utente> getUtentesByLuogoUtente_Provincia(@PathVariable String provincia, @PathVariable Pageable pageable) {
        return utentiRepository.getUtentesByLuogoUtente_Provincia(provincia, pageable);
    }

    @GetMapping(ROOT + "/getUtentiByLuogoUtenteComune/{comune}/{pageable}")
    public Page<Utente> getUtentesByLuogoUtente_Comune(@PathVariable String comune, @PathVariable Pageable pageable) {
        return utentiRepository.getUtentesByLuogoUtente_Comune(comune, pageable);
    }

    @Override
    @GetMapping(ROOT + "/findAll")
    public List<Utente> findAll() {
        return super.findAll();
    }

    @Override
    @PostMapping(ROOT + "/saveAll")
    public void saveAll(@RequestBody List<Utente> entities) {
        super.saveAll(entities);
    }

    @Override
    @GetMapping(ROOT + "/findAllById/{ids}")
    public List<Utente> findAllById(@RequestBody List<Long> ids) {
        return super.findAllById(ids);
    }


    @Override
    @PostMapping(ROOT + "/save")
    public void save(@RequestBody Utente entity) {
        super.save(entity);
    }

    @Override
    @GetMapping(ROOT + "/findById/{id}")
    public Utente findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Override
    @GetMapping(ROOT + "/count")
    public long count() {
        return super.count();
    }

    @Override
    @DeleteMapping(ROOT + "/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        super.deleteById(id);
    }

    @Override
    @DeleteMapping(ROOT + "/delete")
    public void delete(@RequestBody Utente entity) {
        super.delete(entity);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAllById/{ids}")
    public void deleteAllById(@PathVariable List<Long> ids) {
        super.deleteAllById(ids);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll(@RequestBody List<Utente> entities) {
        super.deleteAll(entities);
    }

    @Override
    @PostMapping(ROOT + "/saveAll")
    public void saveAllById(@RequestBody Iterable<Utente> entities) {
        super.saveAllById(entities);
    }

    @Override
    @GetMapping(ROOT + "/existsById/{id}")
    public boolean existsById(@PathVariable Long id) {
        return super.existsById(id);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll() {
        super.deleteAll();
    }
}
