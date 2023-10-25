package it.smartwater.utenti.models.aziende;

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
@Table(name="manutenzione", schema = "smartwater_aziende")
public class Manutenzione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="data")
    @NotNull
    private Date data;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="idUtenteTecnico")
    @NotNull
    private long idUtenteTecnico;

    @Column(name="idTipoManutenzione")
    @NotNull
    private long idTipoManutenzione;


    @OneToOne
    @JoinColumn(name = "idUtenteTecnico", referencedColumnName = "id", table = "utenteTecnico")
    private UtenteTecnico utenteTecnico;

    @OneToOne
    @JoinColumn(name = "idTipoManutenzione", referencedColumnName = "id", table = "tipoManutenzione")
    private TipoManutenzione tipoManutenzione;

}
