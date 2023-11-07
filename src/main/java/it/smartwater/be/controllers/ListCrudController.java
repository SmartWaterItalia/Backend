package it.smartwater.be.controllers;

import it.smartwater.be.controllers.CrudController;
import it.smartwater.be.exceptions.globals.BadRequestException;
import it.smartwater.be.exceptions.globals.NoContentException;
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
        if (entities == null)
            throw new BadRequestException("Entities is null");

        ((ListCrudRepository<T, ID>) super.repository).saveAll(entities);
    }

    public List<T> findAllById(@PathVariable List<ID> ids) {
        if (ids == null)
            throw new BadRequestException("Ids is null");

        List<T> list = ((ListCrudRepository<T, ID>) super.repository).findAllById(ids);

        if (list.isEmpty())
            throw new NoContentException("List is null or empty");

        return list;
    }

}
