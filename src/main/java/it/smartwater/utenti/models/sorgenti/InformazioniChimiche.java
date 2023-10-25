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
@Table(name="informazionichimiche", schema = "smartwater_sorgenti")
public class InformazioniChimiche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="acidità")
    private float acidità;

    @Column(name="ferro")
    private float ferro;

    @Column(name="manganese")
    private float manganese;

    @Column(name="calcio")
    private float calcio;

    @Column(name="magnesio")
    private float magnesio;

    @Column(name="sodio")
    private float sodio;

    @Column(name="potassio")
    private float potassio;

    @Column(name="bicarbonati")
    private float bicarbonati;

    @Column(name="carbonio")
    private float carbonio;

    @Column(name="nitrati")
    private float nitrati;

    @Column(name="nitriti")
    private float nitriti;

    @Column(name="cloro")
    private float cloro;

    @Column(name="fluoruri")
    private float fluoruri;

    @Column(name="solfati")
    private float solfati;

    @Column(name="idSorgente")
    @NotNull
    private int idSorgente;


    @OneToOne
    @JoinColumn(name = "idSorgente", referencedColumnName = "id", table = "sorgente")
    private Sorgente sorgente;

}
