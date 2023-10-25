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

    /*

Indirizzo [id, Via, Civico, Sezione, idLuogo]
Luogo [id, Stato, Regione, Provincia, Comune, Postale]
UtenteTecnico [id, idUtente, idAzienda]
Manutenzione [id, data, descrizione, idUtenteTecnico, idTipoManutenzione]
TipoManutenzione [id, nome, descrizione]
TipoTecnico [id, nome, descrizione, idAzienda]
Sicurezza [id, nome, descrizione] //Indica il permesso
PermessoTecnico [id, idTipoTecnico, idSicurezza]
// L’id azienda lega il tipoTecnico, che è univoco. UtenteTecnico ha un idTipoTecnico e sicurezze è legata solo dall’idTipoTecnino


     */

}
