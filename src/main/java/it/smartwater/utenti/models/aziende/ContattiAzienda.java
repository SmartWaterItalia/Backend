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
@Table(name="contattiAzienda", schema = "smartwater_aziende")
public class ContattiAzienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="contattoMail")
    private String contattoMail;

    @Column(name="contattoWeb")
    private String contattoWeb;

    @Column(name="telefono")
    private String telefono;

    @Column(name="idAzienda")
    @NotNull
    private long idAzienda;


    @OneToOne
    @JoinColumn(name = "idAzienda", referencedColumnName = "id", table = "azienda")
    private Azienda azienda;

}
