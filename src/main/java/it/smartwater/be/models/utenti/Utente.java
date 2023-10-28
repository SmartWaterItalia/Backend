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
@Table(name ="utente", schema = "smartwater_utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 32)
    @NotNull
    private String nome;

    @Column(name = "cognome", length = 32)
    @NotNull
    private String cognome;

    @Column(name = "nickname", length = 64)
    private String nickname;

    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "idLuogo")
    private Long idLuogo;

    @Column(name = "idTipo")
    @NotNull
    private int idTipo;
    //Va messo poi il join a tipoutente


    @OneToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id", table = "tipoutente")
    private Tipo tipoUtente;

    @OneToOne
    @JoinColumn(name = "idLuogo", referencedColumnName = "id", table = "luogo")
    private Luogo luogoUtente;

}
