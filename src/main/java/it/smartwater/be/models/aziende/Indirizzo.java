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
@Table(name="indirizzo", schema = "smartwater_aziende")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="via")
    @NotNull
    private String via;

    @Column(name="civico")
    @NotNull
    private String civico;

    @Column(name="sezione")
    @NotNull
    private String sezione;

    @Column(name="idLuogo")
    @NotNull
    private long idLuogo;


    @OneToOne
    @JoinColumn(name = "idLuogo", referencedColumnName = "id", table = "luogo")
    private Luogo luogo;

}
