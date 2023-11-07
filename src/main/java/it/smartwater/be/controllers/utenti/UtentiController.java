package it.smartwater.be.controllers.utenti;

import it.smartwater.be.controllers.CrudController;
import it.smartwater.be.controllers.ListCrudController;
import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
import it.smartwater.be.models.utenti.Utente;
import it.smartwater.be.models.utenti.Utente;
import it.smartwater.be.repositories.utenti.UtentiRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtentiController extends ListCrudController<Utente, Long> {

    private final String ROOT = "/utente";
    private final UtentiRepository utentiRepository;

    public UtentiController(UtentiRepository utentiRepository) {
        super(utentiRepository);
        this.utentiRepository = utentiRepository;
    }

    @GetMapping(ROOT + "/getUtentiByEmail/{email}")
    public List<Utente> getUtentesByEmail(@PathVariable String email) {
        if (email == null)
            throw new BadRequestException("Email is null");

        List<Utente> list = utentiRepository.getUtentesByEmail(email);

        if (list == null || list.isEmpty())
            throw new NoContentException();

        return list;
    }

    @GetMapping(ROOT + "/getUtentiByNomeAndCognome/{nome}/{cognome}")
    public Page<Utente> getUtentesByNomeIsAndCognomeIs(@PathVariable String nome, @PathVariable String cognome, @RequestParam Pageable pageable) {
        if (nome == null || cognome == null)
            throw new BadRequestException("Nome or cognome is null");

        Page<Utente> pages = utentiRepository.getUtentesByNomeIsAndCognomeIs(nome, cognome, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getUtentiByEmailLike/{email}")
    public Page<Utente> getUtentesByEmailLikeIgnoreCase(@PathVariable String email, @RequestParam Pageable pageable) {
        if (email == null)
            email = "";

        Page<Utente> pages = utentiRepository.getUtentesByEmailLikeIgnoreCase(email, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getUtentiByUtenteUtenteId/{tipoUtenteId}")
    public Page<Utente> getUtentesByUtenteUtente_Id(@PathVariable Integer tipoUtenteId, @RequestParam Pageable pageable) {
        if (tipoUtenteId == null)
            throw new BadRequestException("Type id is null");

        Page<Utente> pages = utentiRepository.getUtentesByTipoUtente_Id(tipoUtenteId, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getUtentiByUtenteUtenteNome/{nome}")
    public Page<Utente> getUtentesByTipoUtente_Nome(@PathVariable String nome, @RequestParam Pageable pageable) {
        if (nome == null)
            throw new BadRequestException("Type name is null");

        Page<Utente> pages = utentiRepository.getUtentesByTipoUtente_Nome(nome, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getUtentiByLuogoUtenteProvincia/{provincia}")
    public Page<Utente> getUtentesByLuogoUtente_Provincia(@PathVariable String provincia, @RequestParam Pageable pageable) {
        if (provincia == null)
            throw new BadRequestException("Province is null");

        Page<Utente> pages = utentiRepository.getUtentesByLuogoUtente_Provincia(provincia, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getUtentiByLuogoUtenteComune/{comune}")
    public Page<Utente> getUtentesByLuogoUtente_Comune(@PathVariable String comune, @RequestParam Pageable pageable) {
        if (comune == null)
            throw new BadRequestException("Comune is null");

        Page<Utente> pages = utentiRepository.getUtentesByLuogoUtente_Comune(comune, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @Override
    @GetMapping(ROOT + "/findAll")
    public List<Utente> findAll() {
        return super.findAll();
    }

    @Override
    @PutMapping(ROOT + "/save")
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
    @DeleteMapping(ROOT + "/deleteAllById")
    public void deleteAllById(@RequestBody List<Long> values) {
        super.deleteAllById(values);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll(@RequestBody List<Utente> entities) {
        super.deleteAll(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAllById")
    public void saveAllById(@RequestBody Iterable<Utente> entities) {
        super.saveAllById(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAll")
    public void saveAll(@RequestBody List<Utente> entities) {
        super.saveAll(entities);
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
