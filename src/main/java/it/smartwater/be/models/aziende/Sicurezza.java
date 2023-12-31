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
public class Sicurezza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="nome", unique = true)
    @NotNull
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

}
