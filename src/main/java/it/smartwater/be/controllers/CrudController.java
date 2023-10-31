package it.smartwater.be.controllers;

import it.smartwater.be.models.utenti.Utente;
import it.smartwater.be.repositories.utenti.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<T, ID> {

    protected CrudRepository<T, ID> repository ;

    public CrudController(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public void save(@RequestBody T entity) {
        this.repository.save(entity);
    }

    public T findById(@PathVariable ID id) {
        return this.repository.findById(id).orElse(null);
    }

    public long count() {
        return this.repository.count();
    }

    public void deleteById(@PathVariable ID id) {
        this.repository.deleteById(id);
    }

    public void delete(@RequestBody T entity) {
        this.repository.delete(entity);
    }

    public void deleteAllById(@RequestBody List<ID> ids) {
        for (ID id : ids) {
            this.repository.deleteById(id);
        }
    }

    public void deleteAll(@RequestBody List<T> entities) {
        this.repository.deleteAll(entities);
    }

    public void saveAllById(@RequestBody Iterable<T> entities) {
        this.repository.saveAll(entities);
    }

    public void saveAll(@RequestBody List<T> entities) {
        this.repository.saveAll(entities);
    }

    public boolean existsById(@PathVariable ID id) {
        return this.repository.existsById(id);
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }
}
