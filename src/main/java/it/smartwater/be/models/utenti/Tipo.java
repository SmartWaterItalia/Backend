package it.smartwater.be.models.utenti;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tipoutente", schema = "smartwater_utenti")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="nome", unique = true ,length = 32)
    @NotNull
    private String nome;

    @Column(name="descrizione", length = 128)
    private String descrizione;
}
