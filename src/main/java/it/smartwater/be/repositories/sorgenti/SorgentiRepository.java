package it.smartwater.be.repositories.sorgenti;

import it.smartwater.be.models.sorgenti.Sorgente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

public interface SorgentiRepository extends ListCrudRepository<Sorgente, Long> {

    Sorgente getSorgentesByLatitudineAndLongitudine(double latitudine, double longitudine);
    Page<Sorgente> getSorgentesByLatitudineBetweenAndLongitudineBetween(double latitudineMin, double latitudineMax, double longitudineMin, double longitudineMax, Pageable pageable);

    int countSorgentesByLatitudineBetweenAndLongitudineBetween(double latitudineMin, double latitudineMax, double longitudineMin, double longitudineMax);
    boolean existsSorgenteByLatitudineAndLongitudine(double latitudine, double longitudine);

}
