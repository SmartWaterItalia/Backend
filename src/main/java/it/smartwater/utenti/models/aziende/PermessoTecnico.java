package it.smartwater.utenti.models.aziende;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tipoManutenzione", schema = "smartwater_aziende")
public class PermessoTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="idTipoTecnico")
    @NotNull
    private long idTipoTecnico;

    @Column(name="idSicurezza")
    @NotNull
    private long idSicurezza;


    @OneToOne
    @JoinColumn(name = "idTipoTecnico", referencedColumnName = "id", table = "tipoTecnico")
    private TipoTecnico tipoTecnico;

    @OneToOne
    @JoinColumn(name = "idSicurezza", referencedColumnName = "id", table = "sicurezza")
    private Sicurezza sicurezza;

}
