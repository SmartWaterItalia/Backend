package it.smartwater.be.models.sorgenti;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="informazionigenerali", schema = "smartwater_sorgenti")
public class InformazioniGenerali {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="proprietario")
    private String proprietario;

    @Column(name="dataInserimento")
    @NotNull
    private Date dataInserimento;

    @Column(name="dataInstallazione")
    private Date dataInstallazione;

    @Column(name="potabilità")
    @NotNull
    private boolean potabilità;

    @Column(name="idSorgente")
    @NotNull
    private int idSorgente;

    @OneToOne
    @JoinColumn(name = "idSorgente", referencedColumnName = "id", table = "sorgente")
    private Sorgente sorgente;

}
