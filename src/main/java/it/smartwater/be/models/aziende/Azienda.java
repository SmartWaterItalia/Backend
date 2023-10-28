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
@Table(name="azienda", schema = "smartwater_aziende")
public class Azienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="idInformazioniAzienda")
    @NotNull
    private long idInformazioniAzienda;

    @Column(name="idContattiAzienda")
    @NotNull
    private long idContattiAzienda;


    @OneToOne
    @JoinColumn(name = "idInformazioniAzienda", referencedColumnName = "id", table = "informazioni_azienda")
    private InformazioniAzienda informazioniAzienda;

    @OneToOne
    @JoinColumn(name = "idContattiAzienda", referencedColumnName = "id", table = "contatti_azienda")
    private ContattiAzienda contattiAzienda;

}
