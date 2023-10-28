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
@Table(name ="immaginevalutazione", schema = "smartwater_utenti")
public class ImmagineValutazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", length = 16)
    private String nome;

    @Column(name = "descrizione", length = 128)
    private String descrizione;

    @Column(name = "path", unique = true)
    @NotNull
    private String path;

    @Column(name = "idValutazione")
    @NotNull
    private Long idValutazione;

    @JoinColumn(name = "idValutazione", referencedColumnName = "id", table = "valutazione")
    @OneToOne
    private Valutazione valutazione;

}
