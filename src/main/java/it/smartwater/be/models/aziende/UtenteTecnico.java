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
@Table(name="utenteTecnico", schema = "smartwater_aziende")
public class UtenteTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="idUtente")
    @NotNull
    private long idUtente;

    @Column(name="idAzienda")
    @NotNull
    private long idAzienda;


    @OneToOne
    @JoinColumn(name = "idAzienda", referencedColumnName = "id", table = "azienda")
    private Azienda azienda;

}
