package it.smartwater.be.models.aziende;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tipoTecnico", schema = "smartwater_aziende")
public class TipoTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="descrizione")
    @NotNull
    private String descrizione;

    @Column(name="idAzienda")
    @NotNull
    private long idAzienda;


    @OneToOne
    @JoinColumn(name = "idAzienda", referencedColumnName = "id", table = "azienda")
    private Azienda azienda;

}
