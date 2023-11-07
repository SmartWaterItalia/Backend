package it.smartwater.be.controllers.utenti;

import it.smartwater.be.controllers.CrudController;
import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NotFoundException;
import it.smartwater.be.models.utenti.Tipo;
import it.smartwater.be.repositories.utenti.TipoRepository;
import it.smartwater.be.repositories.utenti.UtentiRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TipoController extends CrudController<Tipo, Integer> {

    private final String ROOT = "/tipo-utente";
    private final TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {
        super(tipoRepository);
        this.tipoRepository = tipoRepository;
    }

    @GetMapping(ROOT + "/getTipoByNome/{nome}")
    public Tipo getTipoByNome(@PathVariable String nome) {
        if (nome == null)
            throw new BadRequestException("Nome is null");

        Tipo tipo = tipoRepository.getTipoByNome(nome);

        if (tipo == null)
            throw new NotFoundException();

        return tipo;
    }

    @Override
    @GetMapping(ROOT + "/findAll")
    public Iterable<Tipo> findAll() {
        return super.findAll();
    }

    @Override
    @PutMapping(ROOT + "/save")
    public void save(@RequestBody Tipo entity) {
        super.save(entity);
    }

    @Override
    @GetMapping(ROOT + "/findById/{id}")
    public Tipo findById(@PathVariable Integer id) {
        return super.findById(id);
    }

    @Override
    @GetMapping(ROOT + "/count")
    public long count() {
        return super.count();
    }

    @Override
    @DeleteMapping(ROOT + "/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        super.deleteById(id);
    }

    @Override
    @DeleteMapping(ROOT + "/delete")
    public void delete(@RequestBody Tipo entity) {
        super.delete(entity);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAllById")
    public void deleteAllById(@RequestBody List<Integer> integers) {
        super.deleteAllById(integers);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll(@RequestBody List<Tipo> entities) {
        super.deleteAll(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAllById")
    public void saveAllById(@RequestBody Iterable<Tipo> entities) {
        super.saveAllById(entities);
    }

    @Override
    @PutMapping(ROOT + "/saveAll")
    public void saveAll(@RequestBody List<Tipo> entities) {
        super.saveAll(entities);
    }

    @Override
    @GetMapping(ROOT + "/existsById/{id}")
    public boolean existsById(@PathVariable Integer id) {
        return super.existsById(id);
    }

    @Override
    @DeleteMapping(ROOT + "/deleteAll")
    public void deleteAll() {
        super.deleteAll();
    }
}
