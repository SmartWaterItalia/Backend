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
@Table(name="installazione", schema = "smartwater_sorgenti")
public class Installazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="idSorgente")
    @NotNull
    private long idSorgente;

    @Column(name="idLuogo")
    @NotNull
    private long idLuogo;


    @OneToOne
    @JoinColumn(name = "idSorgente", referencedColumnName = "id", table = "sorgente")
    private Sorgente sorgente;

    @OneToOne
    @JoinColumn(name = "idLuogo", referencedColumnName = "id", table = "luogo")
    private Luogo luogo;

}
