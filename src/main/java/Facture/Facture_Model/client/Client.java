package Facture.Facture_Model.client;

import Facture.Facture_Model.facture.Facture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "CLIENTS") // création de l'entité client avec tous les attributs et les relations necessaire.
public class Client{
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false, unique = true)
    private String siret;
    @Column(nullable = false, unique = true)
    private String email;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDate date;
    @OneToMany(mappedBy = "client")
    private List<Facture> factures;



}
