package Facture.Facture_Model.ligneFacture;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneFactureResponse { // FactureResponse: le modéle de données que on expose au client
    private Long id;
    private String description;
    private int quantite;
    private double prixUnitaireHT;
    private TauxTVA tauxTVA;
}
