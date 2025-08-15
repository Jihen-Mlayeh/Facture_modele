package Facture.Facture_Model.ligneFacture;

import Facture.Facture_Model.facture.Facture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "LIGNES_FACTURES") // création d'une entité ligne facture qui represente une ligne dans l'entité facture.
public class LigneFacture {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private int quantite;
    private double prixUnitaireHT;
    @Enumerated(EnumType.STRING)
    private TauxTVA tauxTVA;
    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

}
