package it.smartwater.be.controllers.utenti;

import it.smartwater.be.controllers.CrudController;
import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
import it.smartwater.be.models.utenti.ImmagineValutazione;
import it.smartwater.be.models.utenti.Tipo;
import it.smartwater.be.repositories.utenti.ImmagineValutazioniRepository;
import it.smartwater.be.repositories.utenti.TipoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ImmaginiValutazioneController extends CrudController<ImmagineValutazione, Long> {

    private final String ROOT = "/immagine-valutazione";
    private final ImmagineValutazioniRepository immagineValutazioniRepository;

    public ImmaginiValutazioneController(ImmagineValutazioniRepository immagineValutazioniRepository) {
        super(immagineValutazioniRepository);
        this.immagineValutazioniRepository = immagineValutazioniRepository;
    }

    @GetMapping(ROOT + "/getImmagineValutazionesByIdValutazioneIs/{idValutazione}")
    public List<ImmagineValutazione> getImmagineValutazionesByIdValutazioneIs(@PathVariable Long idValutazione) {
        if (idValutazione == null)
            throw new BadRequestException("Id valutazione is null");

        List<ImmagineValutazione> list = immagineValutazioniRepository.getImmagineValutazionesByIdValutazioneIs(idValutazione);

        if (list == null || list.isEmpty())
            throw new NoContentException();

        return list;
    }

    @Override
    @GetMapping(ROOT + "/findAll")
    public Iterable<ImmagineValutazione> findAll() {
        return super.findAll();
    }

    @Override
    @PutMapping(ROOT + "/save")
    public void save(@RequestBody ImmagineValutazione entity) {
        super.save(entity);
    }

    @Override
    @GetMapping(ROOT + "/findById/{id}")
    public ImmagineValutazione findById(@PathVariable Long id) {
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
    public void delete(@RequestBody ImmagineValutazione entity) {
        super.delete(entity);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAllById")
    public void deleteAllById(@RequestBody List<Long> ids) {
        super.deleteAllById(ids);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll(@RequestBody List<ImmagineValutazione> entities) {
        super.deleteAll(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAllById")
    public void saveAllById(@RequestBody Iterable<ImmagineValutazione> entities) {
        super.saveAllById(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAll")
    public void saveAll(@RequestBody List<ImmagineValutazione> entities) {
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
