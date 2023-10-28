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
@Table(name="contattiAzienda", schema = "smartwater_aziende")
public class ContattiAzienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="mail", unique = true)
    @NotNull
    private String mail;

    @Column(name="website")
    private String website;

    @Column(name="fax")
    private String fax;

    @Column(name="telefono")
    private String telefono;

}
