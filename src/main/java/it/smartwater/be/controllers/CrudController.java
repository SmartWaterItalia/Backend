package it.smartwater.be.controllers;

import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
import it.smartwater.be.exceptions.globals.NotFoundException;
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
        Iterable<T> list = repository.findAll();

        if (!list.iterator().hasNext())
            throw new NoContentException();

        return list;
    }

    public void save(@RequestBody T entity) {
        if (entity == null)
            throw new BadRequestException("Entity is null");

        this.repository.save(entity);
    }

    public T findById(@PathVariable ID id) {
        T entity = this.repository.findById(id).orElse(null);

        if (entity == null)
            throw new NotFoundException();

        return entity;
    }

    public long count() {
        return this.repository.count();
    }

    public void deleteById(@PathVariable ID id) {
        if (id == null)
            throw new BadRequestException("Id is null");

        this.repository.deleteById(id);
    }

    public void delete(@RequestBody T entity) {
        if (entity == null)
            throw new BadRequestException();

        this.repository.delete(entity);
    }

    public void deleteAllById(@RequestBody List<ID> ids) {
        if (ids == null)
            throw new BadRequestException();

        for (ID id : ids)
            this.repository.deleteById(id);
    }

    public void deleteAll(@RequestBody List<T> entities) {
        if (entities == null)
            throw new BadRequestException();

        this.repository.deleteAll(entities);
    }

    public void saveAllById(@RequestBody Iterable<T> entities) {
        if (entities == null)
            throw new BadRequestException();

        this.repository.saveAll(entities);
    }

    public void saveAll(@RequestBody List<T> entities) {
        if (entities == null)
            throw new BadRequestException();

        this.repository.saveAll(entities);
    }

    public boolean existsById(@PathVariable ID id) {
        return this.repository.existsById(id);
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }
}
