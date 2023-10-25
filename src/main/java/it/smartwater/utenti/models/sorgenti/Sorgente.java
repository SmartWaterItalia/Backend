package it.smartwater.utenti.models.sorgenti;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sorgente", schema = "smartwater_sorgenti")
public class Sorgente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "latitudine")
    @NotNull
    private double latitudine;

    @Column(name = "longitudine")
    @NotNull
    private double longitudine;

    @Column(name = "idTipo")
    @NotNull
    private long idTipo;

    @OneToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id", table = "tiposorgente")
    private Tipo tipo;


}
