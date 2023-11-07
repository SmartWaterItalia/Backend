package it.smartwater.be.controllers.utenti;

import it.smartwater.be.controllers.CrudController;
import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
import it.smartwater.be.models.utenti.ImmagineValutazione;
import it.smartwater.be.models.utenti.Utente;
import it.smartwater.be.models.utenti.Valutazione;
import it.smartwater.be.repositories.utenti.ImmagineValutazioniRepository;
import it.smartwater.be.repositories.utenti.ValutazioniRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ValutazioniController extends CrudController<Valutazione, Long> {

    private final String ROOT = "/immagine-valutazione";
    private final ValutazioniRepository valutazioniRepository;

    public ValutazioniController(ValutazioniRepository valutazioniRepository) {
        super(valutazioniRepository);
        this.valutazioniRepository = valutazioniRepository;
    }

    @GetMapping(ROOT + "/getValutazionesByUtente_Id/{idUtente}")
    public Page<Valutazione> getValutazionesByUtente_Id(@PathVariable Long idUtente, @RequestBody Pageable pageable) {
        if (idUtente == null)
            throw new BadRequestException("Utente id is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByUtente_Id(idUtente, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getValutazionesByIdSorgente/{idSorgente}")
    public Page<Valutazione> getValutazionesByIdSorgente(@PathVariable Long idSorgente, @RequestBody Pageable pageable) {
        if (idSorgente == null)
            throw new BadRequestException("Id sorgente is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByIdSorgente(idSorgente, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getValutazionesByIdSorgenteAndUtente_Id/{idSorgente}/{idUtente}")
    public Page<Valutazione> getValutazionesByIdSorgenteAndUtente_Id(@PathVariable Long idSorgente, @PathVariable Long idUtente, @RequestBody Pageable pageable) {
        if (idSorgente == null || idUtente == null)
            throw new BadRequestException("Id sorgente or id utente is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByIdSorgenteAndUtente_Id(idSorgente, idUtente, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getValutazionesByIdSorgenteAndDataBetween/{idSorgente}")
    public Page<Valutazione> getValutazionesByIdSorgenteAndDataBetween(@PathVariable Long idSorgente, @RequestBody Date dataInizio, @RequestBody Date dataFine, @RequestBody Pageable pageable) {
        if (idSorgente == null)
            throw new BadRequestException("Id sorgente is null");
        else if (dataFine == null)
            throw new BadRequestException("Data fine is null");
        else if (dataInizio == null)
            throw new BadRequestException("Data inizio is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByIdSorgenteAndDataBetween(idSorgente, dataInizio, dataFine, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/countValutazionesByIdSorgente/{idSorgente}")
    public int countValutazionesByIdSorgente(@PathVariable Long idSorgente) {
        if (idSorgente == null)
            throw new BadRequestException("Id sorgente is null");

        return valutazioniRepository.countValutazionesByIdSorgente(idSorgente);
    }

    @GetMapping(ROOT + "/countValutazionesByIdSorgenteAndDataBetween/{idSorgente}")
    public int countValutazionesByIdSorgenteAndDataBetween(@PathVariable Long idSorgente, @RequestBody Date dataInizio, @RequestBody Date dataFine) {
        if (idSorgente == null)
            throw new BadRequestException("Id sorgente is null");
        else if (dataFine == null)
            throw new BadRequestException("Data fine is null");
        else if (dataInizio == null)
            throw new BadRequestException("Data inizio is null");

        return valutazioniRepository.countValutazionesByIdSorgenteAndDataBetween(idSorgente, dataInizio, dataFine);
    }

    @GetMapping(ROOT + "/countValutazionesByUtente_Id/{idUtente}")
    public int countValutazionesByUtente_Id(@PathVariable Long idUtente) {
        if (idUtente == null)
            throw new BadRequestException("Id utente is null");

        return valutazioniRepository.countValutazionesByUtente_Id(idUtente);
    }

    @GetMapping(ROOT + "/countValutazionesByUtente_IdAndDataBetween/{idUtente}")
    public int countValutazionesByUtente_IdAndDataBetween(@PathVariable Long idUtente, @RequestBody Date dataInizio, @RequestBody Date dataFine) {
        if (idUtente == null)
            throw new BadRequestException("Id utente is null");
        else if (dataFine == null)
            throw new BadRequestException("Data fine is null");
        else if (dataInizio == null)
            throw new BadRequestException("Data inizio is null");

        return valutazioniRepository.countValutazionesByUtente_IdAndDataBetween(idUtente, dataInizio, dataFine);
    }

    @GetMapping(ROOT + "/getValutazionesByVotoGreaterThanEqual/{voto}")
    public Page<Valutazione> getValutazionesByVotoGreaterThanEqual(@PathVariable Integer voto, @RequestBody Pageable pageable) {
        if (voto == null)
            throw new BadRequestException("Voto is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByVotoGreaterThanEqual(voto, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getValutazionesByVotoLessThanEqual/{voto}")
    public Page<Valutazione> getValutazionesByVotoLessThanEqual(@PathVariable Integer voto, @RequestBody Pageable pageable) {
        if (voto == null)
            throw new BadRequestException("Voto is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByVotoLessThanEqual(voto, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getValutazionesByVotoGreaterThanEqualAndVotoLessThanEqual/{votoMin}/{votoMax}")
    public Page<Valutazione> getValutazionesByVotoGreaterThanEqualAndVotoLessThanEqual(@PathVariable Integer votoMin, @PathVariable Integer votoMax, @RequestBody Pageable pageable) {
        if (votoMin == null)
            throw new BadRequestException("Voto min is null");
        else if (votoMax == null)
            throw new BadRequestException("Voto max is null");

        Page<Valutazione> pages = valutazioniRepository.getValutazionesByVotoGreaterThanEqualAndVotoLessThanEqual(votoMin, votoMax, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/countValutazionesByVotoGreaterThanEqual/{voto}")
    public int countValutazionesByVotoGreaterThanEqual(@PathVariable Integer voto) {
        if (voto == null)
            throw new BadRequestException("Voto is null");

        return valutazioniRepository.countValutazionesByVotoGreaterThanEqual(voto);
    }

    @GetMapping(ROOT + "/countValutazionesByVotoLessThanEqual/{voto}")
    public int countValutazionesByVotoLessThanEqual(@PathVariable Integer voto) {
        if (voto == null)
            throw new BadRequestException("Voto is null");

        return valutazioniRepository.countValutazionesByVotoLessThanEqual(voto);
    }

    @Override
    @GetMapping(ROOT + "/findAll")
    public Iterable<Valutazione> findAll() {
        return super.findAll();
    }

    @Override
    @PutMapping(ROOT + "/save")
    public void save(@RequestBody Valutazione entity) {
        super.save(entity);
    }

    @Override
    @GetMapping(ROOT + "/findById/{id}")
    public Valutazione findById(@PathVariable Long id) {
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
    public void delete(@RequestBody Valutazione entity) {
        super.delete(entity);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAllById")
    public void deleteAllById(@RequestBody List<Long> ids) {
        super.deleteAllById(ids);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll(@RequestBody List<Valutazione> entities) {
        super.deleteAll(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAllById")
    public void saveAllById(@RequestBody Iterable<Valutazione> entities) {
        super.saveAllById(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAll")
    public void saveAll(@RequestBody List<Valutazione> entities) {
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
