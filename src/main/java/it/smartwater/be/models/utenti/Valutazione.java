package it.smartwater.be.models.utenti;

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
@Table(name ="valutazione", schema = "smartwater_utenti")
public class Valutazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titolo", length = 64)
    private String titolo;

    @Column(name = "descrizione", length = 1024)
    private String descrizione;

    @Column(name = "data")
    @NotNull
    private Date data;

    @Column(name = "voto")
    private int voto;

    @Column(name = "votoColore")
    @NotNull
    private int votoColore;

    @Column(name = "votoConsistenza")
    @NotNull
    private int votoConsistenza;

    @Column(name = "votoSapore")
    @NotNull
    private int votoSapore;

    @Column(name = "idSorgente")
    @NotNull
    private Long idSorgente;

    @Column(name = "idUtente")
    @NotNull
    private Long idUtente;


    @OneToOne
    @JoinColumn(name = "idUtente", referencedColumnName = "id", table = "utente")
    private Utente utente;

}
