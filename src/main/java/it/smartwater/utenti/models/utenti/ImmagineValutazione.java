package it.smartwater.utenti.models.utenti;

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

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "path")
    @NotNull
    private String path;

    @Column(name = "idValutazione")
    @NotNull
    private int idValutazione;

}
