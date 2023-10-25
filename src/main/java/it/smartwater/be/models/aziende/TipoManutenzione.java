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
@Table(name="tipoManutenzione", schema = "smartwater_aziende")
public class TipoManutenzione {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="descrizione")
    @NotNull
    private String descrizione;

}
