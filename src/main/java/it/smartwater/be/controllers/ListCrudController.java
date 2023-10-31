package it.smartwater.be.controllers;

import it.smartwater.be.controllers.CrudController;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class ListCrudController<T, ID> extends CrudController<T, ID> {

    public ListCrudController(ListCrudRepository<T, ID> repository) {
        super(repository);
    }

    public List<T> findAll() {
        return ((ListCrudRepository<T, ID>) super.repository).findAll();
    }

    public void saveAll(@RequestBody List<T> entities) {
        ((ListCrudRepository<T, ID>) super.repository).saveAll(entities);
    }

    public List<T> findAllById(@PathVariable List<ID> ids) {
        return ((ListCrudRepository<T, ID>) super.repository).findAllById(ids);
    }

}
