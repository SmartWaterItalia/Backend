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
@Table(name="luogo", schema = "smartwater_aziende")
public class Luogo {

    @Id
    @GeneratedValue
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
