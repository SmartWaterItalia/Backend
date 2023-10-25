package it.smartwater.be.models.utenti;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="luogo", schema = "smartwater_sorgenti")
public class Luogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="stato")
    @NotNull
    private String stato;

    @Column(name="regione")
    @NotNull
    private String regione;

    @Column(name="provincia")
    @NotNull
    private String provincia;

    @Column(name="comune")
    @NotNull
    private String comune;

    @Column(name="postale")
    @NotNull
    private String postale;

}
