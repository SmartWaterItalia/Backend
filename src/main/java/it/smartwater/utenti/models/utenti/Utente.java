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
@Table(name ="utente", schema = "smartwater_utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "cognome")
    @NotNull
    private String cognome;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "idTipo")
    @NotNull
    private int idTipo;
    //Va messo poi il join a tipoutente


    @OneToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id", table = "tipoutente")
    private Tipo tipoUtente;

}
