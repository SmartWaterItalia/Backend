package it.smartwater.be.models.aziende;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="informazioniAzienda", schema = "smartwater_aziende")
public class InformazioniAzienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="nome")
    @NotNull
    private String nome;

    @Column(name="ragioneSociale")
    @NotNull
    private String ragioneSociale;

    @Column(name="partitaIva")
    @NotNull
    private String partitaIva;

    @Column(name="idIndirizzo")
    @NotNull
    private Long idIndirizzo;


    @OneToOne
    @JoinColumn(name = "idIndirizzo", referencedColumnName = "id", table = "indirizzo")
    private Indirizzo indirizzo;

}
