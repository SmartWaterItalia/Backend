package it.smartwater.be.models.sorgenti;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="immagine", schema = "smartwater_sorgenti")
public class Immagine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="path", unique = true)
    @NotNull
    private String path;

    @Column(name="idSorgente")
    @NotNull
    private long idSorgente;


    @OneToOne
    @JoinColumn(name = "idSorgente", referencedColumnName = "id", table = "sorgente")
    private Sorgente sorgente;

}
