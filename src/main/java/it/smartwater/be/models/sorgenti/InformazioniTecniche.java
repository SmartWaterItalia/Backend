package it.smartwater.be.models.sorgenti;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="informazionitecniche", schema = "smartwater_sorgenti")
public class InformazioniTecniche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="idManutenzione")
    @NotNull
    private long idManutenzione;

    @Column(name="idSorgente")
    @NotNull
    private long idSorgente;


    @OneToOne
    @JoinColumn(name = "idSorgente", referencedColumnName = "id", table = "sorgente")
    private Sorgente sorgente;
}
