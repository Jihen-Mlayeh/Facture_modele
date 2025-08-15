package Facture.Facture_Model.facture;

import Facture.Facture_Model.client.Client;
import Facture.Facture_Model.ligneFacture.LigneFacture;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "FACTURES") // création de l'entité facture avec tous les attributs necessaire.
public class Facture {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(updatable = false, nullable = false)
    private LocalDate date;
    @OneToMany(mappedBy = "facture",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Size(min = 1)//pour avoir au minimun une ligne sur une collection on fait @Size
    private List<LigneFacture> lignesFactures;
    @Column(nullable = false)
    private double totaleHT;
    @Column(nullable = false)
    private double totaleTVA;
    @Column(nullable = false)
    private double totaleTTC;


}
