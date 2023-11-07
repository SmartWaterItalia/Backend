package it.smartwater.be.controllers.utenti;

import it.smartwater.be.controllers.CrudController;
import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
import it.smartwater.be.models.utenti.Luogo;
import it.smartwater.be.models.utenti.Tipo;
import it.smartwater.be.repositories.utenti.LuogoRepository;
import it.smartwater.be.repositories.utenti.TipoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LuogoController extends CrudController<Luogo, Long> {

    private final String ROOT = "/luogo-utente";
    private final LuogoRepository luogoRepository;

    public LuogoController(LuogoRepository luogoRepository) {
        super(luogoRepository);
        this.luogoRepository = luogoRepository;
    }

    @GetMapping(ROOT + "/getLuogosByProvincia/{provincia}")
    public Page<Luogo> getLuogosByProvincia(@PathVariable String provincia, @RequestParam Pageable pageable) {
        if (provincia == null)
            throw new BadRequestException("Provincia is null");

        Page<Luogo> pages = luogoRepository.getLuogosByProvincia(provincia, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/getLuogosByRegione/{regione}")
    public Page<Luogo> getLuogosByRegione(@PathVariable String regione, @RequestParam Pageable pageable) {
        if (regione == null)
            throw new BadRequestException("Regione is null");

        Page<Luogo> pages = luogoRepository.getLuogosByRegione(regione, pageable);

        if (pages.isEmpty())
            throw new NoContentException();

        return pages;
    }

    @GetMapping(ROOT + "/exists")
    public boolean existsByStatoAndRegioneAndProvinciaAndComuneAndPostale(@RequestParam String stato, @RequestParam String regione, @RequestParam String provincia, @RequestParam String comune, @RequestParam String postale) {
        if (stato == null || regione == null || provincia == null || comune == null || postale == null)
            throw new BadRequestException();

        return luogoRepository.existsByStatoAndRegioneAndProvinciaAndComuneAndPostale(stato, regione, provincia, comune, postale);
    }

    @Override
    @GetMapping(ROOT + "/findAll")
    public Iterable<Luogo> findAll() {
        return super.findAll();
    }

    @Override
    @PutMapping(ROOT + "/save")
    public void save(@RequestBody Luogo entity) {
        super.save(entity);
    }

    @Override
    @GetMapping(ROOT + "/findById/{id}")
    public Luogo findById(@PathVariable Long id) {
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
    public void delete(@RequestBody Luogo entity) {
        super.delete(entity);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAllById")
    public void deleteAllById(@RequestBody List<Long> integers) {
        super.deleteAllById(integers);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll(@RequestBody List<Luogo> entities) {
        super.deleteAll(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAllById")
    public void saveAllById(@RequestBody Iterable<Luogo> entities) {
        super.saveAllById(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAll")
    public void saveAll(@RequestBody List<Luogo> entities) {
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
